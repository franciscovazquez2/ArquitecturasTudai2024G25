package Daos.MYSQLDaos;

import Daos.Interfaces.ProductDAO;
import Entity.Product;
import Factory.ConnectionMYQSL;
import com.mysql.cj.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MYSQLProductDAO implements ProductDAO {

    private static MYSQLProductDAO instance = null;
    private final Connection conn;

    private MYSQLProductDAO() throws SQLException {
        this.conn= ConnectionMYQSL.getConnection();
    }

    public static MYSQLProductDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new MYSQLProductDAO();
        }
        return instance;
    }

    @Override
    public void insert(Product p) throws SQLException {
        String sql = "INSERT INTO product(idProduct,name,value)VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,p.getIdProduct());
        ps.setString(2,p.getName());
        ps.setFloat(3,p.getValue());

        ps.executeUpdate();
        conn.commit();
    }


    @Override
    public boolean delete(Product p) throws SQLException {
        int rowsAffected=0;
        float id = p.getIdProduct();
        try {
            String rv = "DELETE FROM product WHERE idProduct = ?";
            PreparedStatement ps = conn.prepareStatement(rv);
            ps.setFloat(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            conn.commit();
        }
        catch (SQLException e){
            conn.rollback();
            throw e;
        }

        return rowsAffected>0;
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        return List.of();
    }

    @Override
    public boolean update() throws SQLException {
        return false;
    }

    @Override
    public Product select(Product p) throws SQLException {
        return null;
    }
}
