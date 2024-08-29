package Daos.Interfaces;

import Entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {

    int insert(Client c) throws SQLException;

    boolean delete(int id) throws SQLException;

    public List<Client> selectAll() throws SQLException;

    public boolean update() throws SQLException;

    Client select(int id) throws SQLException;

}
