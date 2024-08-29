package Daos.Interfaces;

import Entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void insert(Product p) throws SQLException;
    boolean delete(int id) throws SQLException;

    List<Product> selectAll() throws SQLException;

    boolean update() throws SQLException;

    Product select(int id) throws SQLException;
}
