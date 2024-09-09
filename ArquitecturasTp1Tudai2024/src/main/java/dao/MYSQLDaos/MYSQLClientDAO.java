package dao.MYSQLDaos;

import dto.ClientMaxFactureDTO;
import dao.Interfaces.ClientDAO;
import entity.Client;
import factory.ConnectionMYQSL;

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
    public void insert (Client c) throws SQLException {
        try {
            String sql = "INSERT INTO client(name, email) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.commit();
        } catch (SQLException e) {
            System.out.print(e + "Error");
        }
    }

    @Override
    public boolean delete (Integer id) throws SQLException {
        int rowsAffected = 0;
        try {
            String sql = "DELETE FROM persona WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id.intValue());
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
    public Client select (Integer id) throws SQLException {
        Client client = null;
        try {
            String sql = "SELECT * FROM client WHERE idClient=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id.intValue());
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
    public boolean update () {
        return false;
    }

    @Override
    public List<Client> selectAll () throws SQLException {
        List<Client> clients = new ArrayList<>();
        try {
            String sql = "SELECT * FROM client";
            PreparedStatement ps = conn.prepareStatement(sql);
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

    public List<ClientMaxFactureDTO> selectMaxFacture () throws SQLException{
        List<ClientMaxFactureDTO> maxFacturesClients = new ArrayList<>();
        try{
            String sql = "select c.id,c.name,c.email, sum(fr.cantidad*p.price)totalfacturado from facture_product fr\n" +
                         "join product p on (fr.idProduct = p.idProduct)\n" +
                         "join facture f on (fr.idFacture = f.idFacture)\n" +
                         "join client c on (f.idClient = c.id)\n" +
                         "group by c.id order by totalfacturado desc;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                maxFacturesClients.add(new ClientMaxFactureDTO(rs.getInt(1),rs.getString(2),
                                                               rs.getString(3), rs.getInt(4)));
            }
            ps.close();
            conn.commit();
        }
        catch(SQLException e){
            System.out.print(e+"Error");
        }
        return maxFacturesClients;
    }
}