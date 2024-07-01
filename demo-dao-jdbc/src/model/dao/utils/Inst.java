package model.dao.utils;

import model.entities.Department;
import model.entities.Seller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Inst{

    public static Department instanciateDepartment(ResultSet resultSet) throws SQLException{
        return new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepartmentName"));
    }

    public static Seller instanciateSeller(ResultSet resultSet, Department department) throws SQLException{
        return new Seller(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getDate("BirthDate"), resultSet.getDouble("BaseSalary"), department);
    }
}
