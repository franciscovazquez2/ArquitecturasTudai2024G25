package Daos.MYSQLDaos;

import Daos.Interfaces.ProductDAO;
import Entity.Product;
import Entity.ProductColleted;
import Factory.ConnectionMYQSL;
import com.mysql.cj.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void insert (Product p) throws SQLException {
        try {
            String sql = "INSERT INTO product(name,price)VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setFloat(2, p.getValue());
            ps.executeUpdate();
            conn.commit();
        }
        catch (SQLException e){
            System.out.println( e + "No se puede ingresar registro");
        }
    }

    @Override
    public boolean delete (int id) throws SQLException {
        int rowsAffected = 0;
        try {
            String sql = "DELETE FROM product WHERE idProduct = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();//ver que pasa aca..
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
    public List<Product> selectAll () throws SQLException {
            List<Product> products = new ArrayList<>();
        try{
            String sql = "SELECT * FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                products.add(new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
            }
            conn.commit();
        }
        catch (SQLException e){
            System.out.println(e+"Error");
        }
        return products;
    }

    @Override
    public boolean update () throws SQLException {
        return false;
    }

    @Override
    public Product select (int id) throws SQLException {
        Product product = null;
        try{
            String sql = "SELECT * FROM product WHERE idProduct=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            product.setIdProduct(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setPrice(rs.getFloat(3));
            conn.commit();
        }
        catch (SQLException e){
            System.out.println(e+"Error");
        }
        return product;
    }

    public List<ProductColleted> selectMostProductColleted () throws SQLException{
        List<ProductColleted> productColleted = new ArrayList<ProductColleted>();
        try {
            String sql = "select p.idProduct, pr.name, pr.price price, sum(p.cantidad) cantTotal, (sum(p.cantidad) * price) recaudacion" +
                         "from facture_product p" +
                         "join product pr on (p.idProduct = pr.idProduct)" +
                         "group by p.idProduct order by recaudacion desc;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                productColleted.add(new ProductColleted(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3)),rs.getInt(4),rs.getInt(5)));
            }
            conn.commit();
        }catch (SQLException e){
            System.out.println(e + "Error");
        }
        return productColleted;
    }
}
