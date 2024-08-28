package Daos.Interfaces;

import Entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void insert(Product p) throws SQLException;

    boolean delete(Product p) throws SQLException;

    List<Product> selectAll() throws SQLException;

    boolean update() throws SQLException;

    Product select(Product p) throws SQLException;
}
