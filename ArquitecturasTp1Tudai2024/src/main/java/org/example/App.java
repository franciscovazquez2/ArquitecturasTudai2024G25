package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/dbArquiTpG25";
        try{
            Connection conn = DriverManager.getConnection(uri,"user", "password");//en derby el parametro es solo uri
            conn.setAutoCommit(false);//por defecto se encuentra en true y no permite commitear.
            //createTables(conn);
            //addPersona(conn, 1, "pancho", 33);
            //addPersona(conn, 2, "vico", 28);
            removePersona(conn,1);
            String select = "SELECT * FROM persona";
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id: "+rs.getInt(1)+
                        ", name: "+rs.getString(2)+
                        ", edad: "+rs.getInt(3));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables(Connection conn) throws SQLException{
        String table= "CREATE TABLE persona(id INT, name VARCHAR(500), edad INT, PRIMARY KEY(id))";
        conn.prepareStatement(table).execute();
        conn.commit();
    }

    public static void addPersona(Connection conn, int id, String name, int edad) throws SQLException{
        String insert = "INSERT INTO persona(id, name, edad) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, edad);
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