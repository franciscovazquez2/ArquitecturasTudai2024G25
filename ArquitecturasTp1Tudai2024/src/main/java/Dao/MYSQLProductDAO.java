package Dao;

import Dao.Interfaces.ProductDAO;

import java.sql.SQLException;
import java.util.List;

public class MYSQLProductDAO implements ProductDAO {

    @Override
    public int insertCustomer() throws SQLException {
        return 0;
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
