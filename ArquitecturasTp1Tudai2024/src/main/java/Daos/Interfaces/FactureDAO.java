package Daos.Interfaces;

import Entity.Facture;

import java.sql.SQLException;
import java.util.List;

public interface FactureDAO {
    void insert(Facture f) throws SQLException;

    boolean delete(Facture f) throws SQLException;

    List<Facture> selectAll() throws SQLException;

    boolean update() throws SQLException;

    Facture select() throws SQLException;
}
