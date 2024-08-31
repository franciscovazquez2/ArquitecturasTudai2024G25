package Daos.MYSQLDaos;

import Daos.Interfaces.FactureDAO;
import Entity.Facture;
import Entity.Product;
import Factory.ConnectionMYQSL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void insert (Facture f) throws SQLException {
        try{
            String sql = "INSERT INTO facture(idClient)VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,f.getIdClient());
            ps.executeUpdate();
            conn.commit();
        }
        catch (SQLException e){
            System.out.println(e + "No se puede ingresar registro" );
        }
    }

    @Override
    public boolean delete (int id) throws SQLException {
        int rowsAffected = 0;
        try {
            String sql = "DELETE FROM facture WHERE idFacture = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            conn.commit();
        }
        catch (SQLException e){
            System.out.println(e + "Error");
        }
        //ver que hacer con esto.. si lo necesitan o no
        if(rowsAffected > 0){
            System.out.println("registro id: "+id+ " eliminado");
        }else{
            System.out.print("No existe registro id: "+id);
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Facture> selectAll () throws SQLException {
        List<Facture> factures = new ArrayList<>();
        try{
            String sql = "SELECT * FROM facture;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                factures.add(new Facture(rs.getInt(1),rs.getInt(2)));
            }
            conn.commit();
        }
        catch (SQLException e){
            System.out.println(e+"Error");
        }
        return factures;
    }

    @Override
    public boolean update () throws SQLException {
        return false;
    }

    @Override
    public Facture select (int id) throws SQLException {
        Facture facture = null;
        try{
            String sql = "SELECT * FROM facture WHERE idFacture=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            facture.setIdFacture(rs.getInt(1));
            facture.setIdClient(rs.getInt(2));
            conn.commit();
        }
        catch (SQLException e){
            System.out.println(e+"Error");
        }
        return facture;
    }

}
