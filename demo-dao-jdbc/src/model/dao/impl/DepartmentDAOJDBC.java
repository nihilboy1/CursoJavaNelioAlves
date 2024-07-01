package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.dao.utils.Inst;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOJDBC implements DepartmentDAO{

    private final Connection connection;

    public DepartmentDAOJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public Department insert(String departmentName){
        PreparedStatement prepStatement = null;
        try{
            prepStatement = connection.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, departmentName);

            int affectedRows = prepStatement.executeUpdate();
            if(affectedRows > 0){
                ResultSet resultSet = prepStatement.getGeneratedKeys();
                Department department = null;
                if(resultSet.next()){
                    int id = resultSet.getInt(1);
                    department = new Department(id, departmentName);
                }
                DB.closeResultSet(resultSet);
                return department;
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
    public void update(Department department){
        PreparedStatement prepStatement = null;
        try{
            prepStatement = connection.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);

            prepStatement.setString(1, department.getName());
            prepStatement.setInt(2, department.getId());

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
            prepStatement = connection.prepareStatement("DELETE FROM department WHERE Id = ?");
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
        }
    }

    @Override
    public Department findById(Integer id){
        PreparedStatement prepStatement = null;

        ResultSet resultSet = null;
        try{
            prepStatement = connection.prepareStatement("SELECT department.Id AS DepartmentId, department.Name AS DepartmentName FROM department WHERE department.Id = ?");
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();

            if(resultSet.next()){
                return Inst.instanciateDepartment(resultSet);
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
    public List<Department> findAll(){
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        try{
            prepStatement = connection.prepareStatement("SELECT department.Id AS DepartmentId, department.Name AS DepartmentName FROM department ORDER BY Name");
            resultSet = prepStatement.executeQuery();

            List<Department> departmentList = new ArrayList<>();

            while(resultSet.next()){
                Department department = Inst.instanciateDepartment(resultSet);
                departmentList.add(department);
            }
            return departmentList;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(prepStatement);
            DB.closeResultSet(resultSet);
        }
    }
}
