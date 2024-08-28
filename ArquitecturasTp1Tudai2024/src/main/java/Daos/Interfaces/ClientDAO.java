package Daos.Interfaces;

import Entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {

    int insert(Client c) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    List findCustomer(int id) throws SQLException;

    public boolean updateCustomer() throws SQLException;

    public List selectCustomersRS() throws SQLException;
}
