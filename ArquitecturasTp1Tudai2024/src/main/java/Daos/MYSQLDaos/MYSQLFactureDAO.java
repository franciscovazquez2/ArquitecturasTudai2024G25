package Daos.MYSQLDaos;

import Daos.Interfaces.FactureDAO;
import Entity.Facture;
import Factory.ConnectionMYQSL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MYSQLFactureDAO implements FactureDAO {

    private static MYSQLFactureDAO instance = null;
    private final Connection conn;

    private MYSQLFactureDAO() throws SQLException {
        this.conn= ConnectionMYQSL.getConnection();
    }

    public static MYSQLFactureDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new MYSQLFactureDAO();
        }
        return instance;
    }


    @Override
    public void insert(Facture f) throws SQLException {
        
    }

    @Override
    public boolean deleteCustomer() throws SQLException {
        return false;
    }

    @Override
    public List findCustomer() throws SQLException {
        return List.of();
    }

    @Override
    public boolean updateCustomer() throws SQLException {
        return false;
    }

    @Override
    public List selectCustomersRS() throws SQLException {
        return List.of();
    }
}
