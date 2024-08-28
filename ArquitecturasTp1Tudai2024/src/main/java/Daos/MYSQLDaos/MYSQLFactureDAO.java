package Daos.MYSQLDaos;

import Daos.Interfaces.FactureDAO;
import Entity.Facture;
import Entity.Product;
import Factory.ConnectionMYQSL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MYSQLFactureDAO implements FactureDAO {

    private static MYSQLFactureDAO instance = null;
    private final Connection conn;

    private MYSQLFactureDAO() throws SQLException {
        this.conn= ConnectionMYQSL.getConnection();
    }

    public static MYSQLFactureDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new MYSQLFactureDAO();
        }
        return instance;
    }


    @Override
    public void insert(Facture f) throws SQLException {
        String sql = "INSERT INTO facture(idClient)VALUES(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,f.getIdClient());

        ps.executeUpdate();
        conn.commit();
    }

    @Override
    public boolean delete(Facture f) throws SQLException {
        return false;
    }

    @Override
    public List<Facture> selectAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update() throws SQLException {
        return false;
    }

    @Override
    public Facture select() throws SQLException {
        return null;
    }
}
