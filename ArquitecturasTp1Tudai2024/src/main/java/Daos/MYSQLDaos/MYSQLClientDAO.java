package Daos.MYSQLDaos;

import Daos.Interfaces.ClientDAO;
import Entity.Client;
import Entity.ClientMaxFacture;
import Entity.Product;
import Factory.ConnectionMYQSL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MYSQLClientDAO implements ClientDAO {

    private static MYSQLClientDAO instance = null;
    private final Connection conn;

    private MYSQLClientDAO() throws SQLException {
        this.conn = ConnectionMYQSL.getConnection();
    }

    public static MYSQLClientDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new MYSQLClientDAO();
        }
        return instance;
    }

    @Override
    public int insert(Client c) throws SQLException {
        try {
            String insert = "INSERT INTO client(name, email) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            int value = ps.executeUpdate();
            ps.close();
            conn.commit();
            return value;
        } catch (SQLException e) {
            System.out.print(e + "Error");
            return 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        int rowsAffected = 0;
        try {
            String rv = "DELETE FROM persona WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(rv);
            ps.setInt(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e + "Error");
        }
        //ver que hacer con esto.. si lo necesitan o no
        if (rowsAffected > 0) {
            System.out.println("registro id: " + id + " eliminado");
        } else {
            System.out.print("No existe registro id: " + id);
        }
        return rowsAffected > 0;
    }

    @Override
    public Client select(int id) throws SQLException {
        Client client = null;
        try {
            String select = "SELECT * FROM client WHERE idClient=?";
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            client.setIdClient(rs.getInt(1));
            client.setName(rs.getString(2));
            client.setEmail(rs.getString(3));
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e + "Error");
        }
        return client;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public List<Client> selectAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        try {
            String select = "SELECT * FROM client";
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e + "Error");
        }
        return clients;
    }

    public List<ClientMaxFacture>selectMasFacturado(){
        List<ClientMaxFacture> clientesMasFacturados = new ArrayList<>();
        try{
            String sql = "select c.id,c.name,c.email, sum(fr.cantidad*p.price)totalfacturado from facture_product fr\n" +
                         "join product p on (fr.idProduct = p.idProduct)\n" +
                         "join facture f on (fr.idFacture = f.idFacture)\n" +
                         "join client c on (f.idClient = c.id)\n" +
                         "group by c.id order by totalfacturado desc;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Client c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
                ClientMaxFacture cmf = new ClientMaxFacture(c,rs.getInt(4));
                clientesMasFacturados.add(cmf);
            }
            ps.close();
            conn.commit();
        }
        catch(SQLException e){
            System.out.print(e+"Error");
        }
        return clientesMasFacturados;
    }
}