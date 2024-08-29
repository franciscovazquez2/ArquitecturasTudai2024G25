package org.example;

import Daos.Interfaces.ClientDAO;
import Daos.Interfaces.FactureDAO;
import Daos.Interfaces.Facture_ProductDAO;
import Daos.Interfaces.ProductDAO;
import Daos.MYSQLDaos.MYSQLClientDAO;
import Daos.MYSQLDaos.MYSQLProductDAO;
import Entity.Client;
import Entity.Facture;
import Entity.Facture_Product;
import Entity.Product;
import Factory.ConnectionMYQSL;
import Factory.DAOFactory;
import SchemaDataBase.SchemaMYSQL;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        Connection conn = ConnectionMYQSL.getConnection();
        /* creacion de esquema completo*
        SchemaMYSQL schemaMYSQL = new SchemaMYSQL();
        schemaMYSQL.createSchema();
        */

        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
        if (daoFactory != null) {
            ProductDAO productDAO = daoFactory.getProductDAO();
            ClientDAO clientDAO = daoFactory.getClientDAO();
            FactureDAO factureDAO = daoFactory.getFactureDAO();
            Facture_ProductDAO facture_productDAO = daoFactory.getFacture_ProductDAO();

            //Client client1 = new Client("pablo","olgaolga@gmail.com");
            //Client client2 = new Client("Nico","olgaolga@hotmail.com");
            //clientDAO.insert(client1);clientDAO.insert(client2);

            /*
            Facture facture1 = new Facture(2);
            factureDAO.insert(facture1);

            Product product1= new Product("Prueba", 50);
            Product product2= new Product("Vaso", 40);
            productDAO.insert(product2);
            productDAO.insert(product1);
            */

            //Facture_Product fp = new Facture_Product(2,1,4);
            //facture_productDAO.insert(fp);

            //boolean delete= productDAO.delete(3);//
            /*
            List<Product> listaProductos = productDAO.selectAll();
            for (Product p : listaProductos) {
                System.out.println(p.getIdProduct() + "," + p.getName() + "," + p.getValue());
            }
             */

        }
        conn.close();
    }
}
