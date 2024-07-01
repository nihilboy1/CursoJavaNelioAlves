package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.dao.utils.Inst;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDAOJDBC implements SellerDAO{
    private final Connection connection;

    public SellerDAOJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller){
        PreparedStatement prepStatement = null;
        try{
            prepStatement = connection.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, seller.getName());
            prepStatement.setString(2, seller.getEmail());
            prepStatement.setDate(3, new Date(seller.getBirthDate().getTime()));
            prepStatement.setDouble(4, seller.getBaseSalary());
            prepStatement.setInt(5, seller.getDepartment().getId());

            int affectedRows = prepStatement.executeUpdate();
            if(affectedRows > 0){
                ResultSet resultSet = prepStatement.getGeneratedKeys();
                if(resultSet.next()){
                    seller.setId(resultSet.getInt(1));
                }
                DB.closeResultSet(resultSet);
            }else{
                throw new DbException("Unexpected error: no rows affected.");
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
        }
    }

    @Override
    public void update(Seller seller){
        PreparedStatement prepStatement = null;
        try{
            prepStatement = connection.prepareStatement("UPDATE seller SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);

            prepStatement.setString(1, seller.getName());
            prepStatement.setString(2, seller.getEmail());
            prepStatement.setDate(3, new Date(seller.getBirthDate().getTime()));
            prepStatement.setDouble(4, seller.getBaseSalary());
            prepStatement.setInt(5, seller.getDepartment().getId());
            prepStatement.setInt(6, seller.getId());

            prepStatement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
        }
    }

    @Override
    public void deleteById(Integer id){
        PreparedStatement prepStatement = null;
        try{
            prepStatement = connection.prepareStatement("DELETE FROM seller WHERE Id = ?");
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
        }
    }

    @Override
    public Seller findById(Integer id){
        PreparedStatement prepStatement = null;

        ResultSet resultSet = null;
        try{
            prepStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepartmentName " + "FROM" + " " + "seller" + " " + "INNER" + " JOIN department " + "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();

            if(resultSet.next()){
                Department department = Inst.instanciateDepartment(resultSet);
                return Inst.instanciateSeller(resultSet, department);
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Seller> findAll(){
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        try{
            prepStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepartmentName FROM" + " seller INNER JOIN department " + "ON seller.DepartmentId = department.Id ORDER BY Name");
            resultSet = prepStatement.executeQuery();

            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> departmentMap = new HashMap<>();

            while(resultSet.next()){
                Integer resultDepartmentId = resultSet.getInt("DepartmentId");
                Department department = departmentMap.get(resultDepartmentId);

                if(department == null){
                    department = Inst.instanciateDepartment(resultSet);
                    departmentMap.put(resultDepartmentId, department);
                }

                Seller seller = Inst.instanciateSeller(resultSet, department);
                sellerList.add(seller);
            }
            return sellerList;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Seller> findByDepartmentId(Integer departmentId){
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        try{
            prepStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepartmentName FROM" + " seller INNER JOIN department " + "ON seller.DepartmentId = department.Id " + "WHERE DepartmentId = ? " + "ORDER BY Name");
            prepStatement.setInt(1, departmentId);
            resultSet = prepStatement.executeQuery();

            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> departmentMap = new HashMap<>();

            while(resultSet.next()){
                Integer resultDepartmentId = resultSet.getInt("DepartmentId");
                Department department = departmentMap.get(resultDepartmentId);

                if(department == null){
                    department = Inst.instanciateDepartment(resultSet);
                    departmentMap.put(resultDepartmentId, department);
                }

                Seller seller = Inst.instanciateSeller(resultSet, department);
                sellerList.add(seller);
            }
            return sellerList;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
            DB.closeResultSet(resultSet);
        }
    }
}
