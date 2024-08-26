package Daos.Interfaces;

import Entity.Facture;

import java.sql.SQLException;
import java.util.List;

public interface FactureDAO {
    void insert(Facture f) throws SQLException;

    boolean deleteCustomer() throws SQLException;

    List findCustomer() throws SQLException;

    public boolean updateCustomer() throws SQLException;

    public List selectCustomersRS() throws SQLException;
}
