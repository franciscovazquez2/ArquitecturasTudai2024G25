package Daos.MYSQLDaos;

import Daos.Interfaces.ClientDAO;
import Entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MYSQLClientDAO implements ClientDAO {

    private static final String URI = "jdbc:mysql://localhost:3306/dbArquiTpG25";

 // Conexcion a la base de datos
    private Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(URI, "user", "password");//en derby el parametro es solo uri
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insertCustomer(int id, String name, String email) throws SQLException {
        Connection conn = getConnection();
        String insert = "INSERT INTO persona(id, name, email) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, email);
        int value = ps.executeUpdate();
        ps.close();
        conn.commit();
        conn.close();
        return value;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        Connection conn = getConnection();
        String rv = "DELETE FROM persona WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(rv);
        ps.setInt(1, id);
        boolean value = ps.execute();
        ps.close();
        conn.commit();
        return value;
    }

    @Override
    public List findCustomer(int id) throws SQLException {
        List<Client> listClient = new ArrayList<>();
        Connection conn = getConnection();
        String select = "SELECT * FROM persona WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(select);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Client c1 = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
            listClient.add(c1);
        }
        ps.close();
        conn.close();
        return listClient;
    }

    @Override
    public boolean updateCustomer() {
        return false;
    }

    @Override
    public List selectCustomersRS() throws SQLException {
        List<Client> listClient = new ArrayList<>();
        Connection conn = getConnection();
        String select = "SELECT * FROM persona";
        PreparedStatement ps = conn.prepareStatement(select);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Client c1 = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
            listClient.add(c1);
        }
        ps.close();
        conn.close();
        return listClient;
    }
}
