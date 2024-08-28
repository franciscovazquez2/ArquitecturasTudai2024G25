package Daos.MYSQLDaos;

import Daos.Interfaces.ClientDAO;
import Entity.Client;
import Factory.ConnectionMYQSL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MYSQLClientDAO implements ClientDAO {

    private static MYSQLClientDAO instance = null;
    private final Connection conn;

    private MYSQLClientDAO() throws SQLException {
        this.conn= ConnectionMYQSL.getConnection();
    }

    public static MYSQLClientDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new MYSQLClientDAO();
        }
        return instance;
    }
    @Override
    public int insert(Client c) throws SQLException {
        String insert = "INSERT INTO client(name, email) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, c.getName());
        ps.setString(2, c.getEmail());
        int value = ps.executeUpdate();
        ps.close();
        conn.commit();
        return value;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
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
