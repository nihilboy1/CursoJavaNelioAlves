package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Program{
    public static void main(String[] args){

    }


    public static void DELETE(){
        Connection connection = null;
        PreparedStatement st = null;

        try{
            connection = DB.getConnection();
            st = connection.prepareStatement("delete from department " + "where " + "Id = ?");
            st.setInt(1, 2);
            int rowsAffected = st.executeUpdate();
            System.out.print(rowsAffected);
        }catch(SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
    public static void UPDATE(){
        Connection connection = null;
        PreparedStatement st = null;

        try{
            connection = DB.getConnection();

            st = connection.prepareStatement("update seller " + "set BaseSalary = BaseSalary + ? " + "where " +
                    "(DepartmentId = ?)" );
            st.setDouble(1, 1500);
            st.setInt(2, 4);

            int rowsAffected = st.executeUpdate();
            System.out.print(rowsAffected);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
    public static void CREATE(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement st = null;
        try{
            connection = DB.getConnection();
            st = connection.prepareStatement("insert into department " + "(Name) " + "values " + "(?)");
            st.setString(1, "Relations");



            int affectedRows = st.executeUpdate();


        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
    public static void READ(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from department");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));
            }
        }catch(SQLException error){
            error.printStackTrace();
        }
        finally{
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}