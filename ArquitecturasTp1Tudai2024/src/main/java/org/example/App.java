package org.example;

import Daos.Interfaces.ClientDAO;

import Factory.DAOFactory;

import java.sql.*;

import java.util.List;


public class App {
    public static void main(String[] args) throws SQLException {

        DAOFactory f1 = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
        ClientDAO c1 = f1.getClientDAO();

        List l1 = c1.findCustomer(2);
        l1.forEach(next -> System.out.println(next.toString()));

        List l2 = c1.selectCustomersRS();
        l2.forEach(next -> System.out.println(next.toString()));
        l2.clear();

        c1.insertCustomer(3, "juan", "papito@melocoton.com.ar");
        l2 = c1.selectCustomersRS();
        l2.forEach(next -> System.out.println(next.toString()));


        c1.deleteCustomer(2);
        l2 = c1.selectCustomersRS();
        l2.forEach(next -> System.out.println(next.toString()));
    }}
        //---------------------------------------------------------------
/*
=======
    //}}
        //---------------------------------------------------------------




        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                 NoSuchMethodException | SecurityException | ClassNotFoundException |
                 InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/dbArquiTpG25";
        try{
            Connection conn = DriverManager.getConnection(uri,"user", "password");//en derby el parametro es solo uri
            conn.setAutoCommit(false);//por defecto se encuentra en true y no permite commitear.

            createTables(conn);
            addPersona(conn, 1, "pancho", "panchito@tito.com.ar");
            addPersona(conn, 2, "vico", "vikito@kito.com.ar");

            //createTables(conn);
            //addPersona(conn, 1, "pancho", 33);
            //addPersona(conn, 2, "vico", 28);
            //removePersona(conn,1);
            //createTables(conn);
            //addPersona(conn, 1, "pancho", 33);
            //addPersona(conn, 2, "vico", 28);
            //removePersona(conn,1);
            String select = "SELECT * FROM persona";
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id: "+rs.getInt(1)+
                        ", name: "+rs.getString(2)+
                        ", email: "+rs.getString(3));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables(Connection conn) throws SQLException{
        String table= "CREATE TABLE persona(id INT, name VARCHAR(500), email VARCHAR(250), PRIMARY KEY(id))";
        conn.prepareStatement(table).execute();
        conn.commit();
    }

    public static void addPersona(Connection conn, int id, String name, String email) throws SQLException{
        String insert = "INSERT INTO persona(id, name, email) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    public static void removePersona (Connection conn, int id) throws SQLException {
        String rv = "DELETE FROM persona WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(rv);
        ps.setInt(1, id);
        ps.execute();
        ps.close();
        conn.commit();
    }
}