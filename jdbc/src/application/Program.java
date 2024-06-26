package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Program{
    public static void main(String[] args){

    }



    /**
     * Método que executa múltiplas operações de atualização em uma única transação.
     *
     * Este método demonstra como usar transações no JDBC para garantir que um grupo de operações
     * SQL sejam executadas de forma atômica. A transação é confirmada apenas se todas as operações
     * forem bem-sucedidas; caso contrário, todas as mudanças são revertidas.
     */
    public static void TRANSACTIONS() {
        Statement st = null;
        Connection conn = null;

        try {
            // Obtendo a conexão com o banco de dados
            conn = DB.getConnection();

            // Desabilitando o autocommit para iniciar a transação
            conn.setAutoCommit(false);

            // Criando um Statement para executar as operações SQL
            st = conn.createStatement();

            // Executando a primeira operação de atualização
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            // Executando a segunda operação de atualização
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            // Confirmando a transação se todas as operações forem bem-sucedidas
            conn.commit();

            // Imprimindo o número de linhas afetadas por cada operação
            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);
        } catch (SQLException e) {
            try {
                // Revertendo a transação em caso de erro
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        } finally {
            // Fechando o Statement e a conexão, garantindo que os recursos sejam liberados
            DB.closeStatement(st);
            DB.closeConnection();
        }
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