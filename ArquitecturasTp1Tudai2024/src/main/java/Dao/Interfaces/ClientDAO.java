package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {

    int insertCustomer(int id, String name, String email) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    List findCustomer(int id) throws SQLException;

    public boolean updateCustomer() throws SQLException;

    public List selectCustomersRS() throws SQLException;
}
