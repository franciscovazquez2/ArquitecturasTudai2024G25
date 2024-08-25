package Dao;

import Entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MYSQLClientDAO implements CustomerDAO{

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

    // Metodo de prueba  -- ELIMINAR
    public void pruebaSelect() throws SQLException {
        Connection conn = getConnection();
        String select = "SELECT * FROM persona";
        PreparedStatement ps = conn.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id: "+rs.getInt(1)+
                    ", name: "+rs.getString(2)+
                    ", edad: "+rs.getInt(3));
        }
        conn.close();
    }

    @Override
    public int insertCustomer() {
        return 0;
    }

    @Override
    public boolean deleteCustomer() {
        return false;
    }

    @Override
    public List findCustomer() {
        return List.of();
    }

    @Override
    public boolean updateCustomer() {
        return false;
    }

    @Override
    public List selectCustomersRS() throws SQLException {
        Connection conn = getConnection();
        String select = "SELECT * FROM persona";
        PreparedStatement ps = conn.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        conn.close();
    }
}
