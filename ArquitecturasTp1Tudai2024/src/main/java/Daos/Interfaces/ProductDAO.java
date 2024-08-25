package Daos.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    int insertCustomer() throws SQLException;

    boolean deleteCustomer() throws SQLException;

    List findCustomer() throws SQLException;

    public boolean updateCustomer() throws SQLException;

    public List selectCustomersRS() throws SQLException;
}
