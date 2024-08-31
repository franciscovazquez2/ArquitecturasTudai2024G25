package Daos.MYSQLDaos;

import Daos.Interfaces.Facture_ProductDAO;
import Entity.Facture_Product;
import Entity.Product;
import Factory.ConnectionMYQSL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MYSQLFacture_ProductDAO implements Facture_ProductDAO {
    private static MYSQLFacture_ProductDAO instance = null;
    private Connection conn;

    private MYSQLFacture_ProductDAO() throws SQLException{
        this.conn = ConnectionMYQSL.getConnection();
    }

    public static MYSQLFacture_ProductDAO getInstance() throws SQLException{
        if(instance == null){
            instance = new MYSQLFacture_ProductDAO();
        }
        return instance;
    }

    private boolean getExistFacture(int id_f){
        try{
            String sql = "SELECT * FROM facture where idFacture = ?" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_f);
            return ps.execute();
        }
        catch (SQLException e){
            System.out.println(e + "Error existencia factura!");
            return false;
        }
    }

    private boolean getExistProduct(int id_p){
        try{
            String sql = "SELECT * FROM product where idProduct = ?" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_p);
            return ps.execute();
        }
        catch (SQLException e){
            System.out.println(e + "Error existencia producto!");
            return false;
        }
    }

    @Override
    public void insert(Facture_Product fp) throws SQLException {
        if(getExistFacture(fp.getIdFacture()) && getExistProduct(fp.getIdProduct())) {
            try {
                String sql = "INSERT INTO facture_product(idFacture, idProduct, cantidad) VALUES(?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, fp.getIdFacture());
                ps.setInt(2, fp.getIdProduct());
                ps.setInt(3, fp.getCantidad());
                ps.execute();
                conn.commit();
            }
            catch (SQLException e){
                System.out.println(e + "Error!");
            }
        }
    }

    @Override
    public boolean delete(int id_f, int id_p) throws SQLException {
        int arowsAffected = 0;
        try{
            String sql = "DELETE FROM facture_product WHERE idFacture = ? AND idProduct = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id_f);
        ps.setInt(2, id_p);
        arowsAffected = ps.executeUpdate();
        ps.close();
        conn.commit();
        }
        catch (SQLException e){
            System.out.println(e + "Error!");
        }
        if(arowsAffected > 0) {
            System.out.println(arowsAffected + "Registro con idFactura "+ id_f + " y idProducto "+id_p+" eliminado.");
        }else {
            System.out.println("No existe registro con idFactura "+ id_f + " y idProducto "+id_p);
        }
        return false;
    }

    @Override
    public List<Facture_Product> selectAll() throws SQLException {
        List<Facture_Product> fp = new ArrayList<>();
        try{
            String sql = "SELECT * FROM facture_product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                fp.add(new Facture_Product(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            conn.commit();
        }catch (SQLException e){
            System.out.println(e + "Error!");
        }
        return fp;
    }

    @Override
    public boolean update() throws SQLException {
        return false;
    }

    @Override
    public Facture_Product select(int id_f, int id_p) throws SQLException {
        Facture_Product fp = null;
        try {
            String select = "SELECT * FROM facture_product WHERE idFacture = ? AND idProduct = ?";
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, id_f);
            ps.setInt(2, id_p);
            ResultSet rs = ps.executeQuery();
            fp.setIdProduct(rs.getInt(1));
            fp.setIdFacture(rs.getInt(2));
            fp.setCantidad(rs.getInt(3));
            conn.commit();
        }catch (SQLException e){
            System.out.println(e + "Error!");
        }
        return fp;
    }

}
