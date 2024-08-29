package Daos.Interfaces;

import Entity.Client;
import Entity.Facture_Product;

import java.sql.SQLException;
import java.util.List;

public interface Facture_ProductDAO {

    void insert(Facture_Product fp) throws SQLException;

    boolean delete(int id_f, int id_p) throws SQLException;

    public List<Facture_Product> selectAll() throws SQLException;

    public boolean update() throws SQLException;

    Facture_Product select(int id_f, int id_p) throws SQLException;
}
