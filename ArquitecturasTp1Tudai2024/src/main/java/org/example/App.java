package org.example;

import CSVfiles.CSVreader;
import DTO.ClientMaxFactureDTO;
import DTO.ProductColletedDTO;
import Daos.Interfaces.ClientDAO;
import Daos.Interfaces.FactureDAO;
import Daos.Interfaces.Facture_ProductDAO;
import Daos.Interfaces.ProductDAO;
import Daos.MYSQLDaos.MYSQLClientDAO;
import Daos.MYSQLDaos.MYSQLProductDAO;
import Entity.*;
import Factory.ConnectionMYQSL;
import Factory.DAOFactory;
import SchemaDataBase.SchemaMYSQL;

import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        Connection conn = ConnectionMYQSL.getConnection();
        //creacion de esquema completo*
        //SchemaMYSQL schemaMYSQL = new SchemaMYSQL();
        //schemaMYSQL.createSchema();



        /*DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
        if (daoFactory != null) {
            ProductDAO productDAO = daoFactory.getProductDAO();
            ClientDAO clientDAO = daoFactory.getClientDAO();
            FactureDAO factureDAO = daoFactory.getFactureDAO();
            Facture_ProductDAO facture_productDAO = daoFactory.getFacture_ProductDAO();

            CSVreader csv = new CSVreader();
            List<Client>clients = csv.readFileClient();
            List<Product>products = csv.readFileProduct();
            List<Facture>factures = csv.readFileFacture();
            List<Facture_Product> factureProducts = csv.readFileFactureProduct();

            for(Client c : clients){
                clientDAO.insert(c);
            }
            for(Facture f : factures){
                factureDAO.insert(f);
            }

            for(Product p : products){
                productDAO.insert(p);
            }

            for(Facture_Product fp : factureProducts){
                facture_productDAO.insert(fp);
            }*/
            System.out.println("Clientes mas facturados");
            List<ClientMaxFactureDTO>clientesMasFacturados = MYSQLClientDAO.getInstance().selectMaxFacture();

            for (ClientMaxFactureDTO c : clientesMasFacturados){
                System.out.println(c.toString());
            }
            System.out.println("Product Collected");

            List<ProductColletedDTO>productCollected = MYSQLProductDAO.getInstance().selectMostProductColleted();

            for (ProductColletedDTO c : productCollected){
                System.out.println(c.toString());
            }
        //}
        conn.close();
    }
}
