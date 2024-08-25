package Dao;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    public void pruebaSelect() throws SQLException;
    public int insertCustomer();
    public boolean deleteCustomer();
    public List findCustomer();
    public boolean updateCustomer();
    public List selectCustomersRS();
}
