package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDAOJDBC implements SellerDAO{
    private Connection connection;

    public SellerDAOJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Seller department){

    }

    @Override
    public void update(Seller department){

    }

    @Override
    public void deleteById(Integer Id){

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
                Department department = instanciateDepartment(resultSet);
                return instanciateSeller(resultSet, department);
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
                    department = instanciateDepartment(resultSet);
                    departmentMap.put(resultDepartmentId, department);
                }

                Seller seller = instanciateSeller(resultSet, department);
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
                    department = instanciateDepartment(resultSet);
                    departmentMap.put(resultDepartmentId, department);
                }

                Seller seller = instanciateSeller(resultSet, department);
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

    private Seller instanciateSeller(ResultSet resultSet, Department department) throws SQLException{
        return new Seller(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getDate("BirthDate"), resultSet.getDouble("BaseSalary"), department);
    }

    private Department instanciateDepartment(ResultSet resultSet) throws SQLException{
        return new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepartmentName"));
    }
}
