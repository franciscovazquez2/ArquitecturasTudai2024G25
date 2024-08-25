package Dao;

import java.sql.SQLException;
import java.util.List;

public class MYSQLProductDAO implements CustomerDAO{
    @Override
    public void pruebaSelect() throws SQLException {

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
    public List selectCustomersRS() {
        return List.of();
    }
}
