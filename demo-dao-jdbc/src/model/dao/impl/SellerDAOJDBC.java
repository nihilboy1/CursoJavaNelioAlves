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
import java.util.List;

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
            prepStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepName " + "FROM seller INNER JOIN department " + "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");
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

    private Seller instanciateSeller(ResultSet resultSet, Department department) throws SQLException{
        return new Seller(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getDate("BirthDate"), resultSet.getDouble("BaseSalary"), department);
    }

    private Department instanciateDepartment(ResultSet resultSet) throws SQLException{
        return new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepName"));
    }

    @Override
    public List<Seller> findAll(){
        return List.of();
    }
}
