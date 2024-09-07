package Daos.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao <T,K>{
    void insert(T t) throws SQLException;

    boolean delete(K k) throws SQLException;

    List<T> selectAll() throws SQLException;

    boolean update() throws SQLException;

    T select(K k) throws SQLException;
}
