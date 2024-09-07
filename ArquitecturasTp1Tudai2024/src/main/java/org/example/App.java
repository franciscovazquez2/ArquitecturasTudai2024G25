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
import Initialize.InitializeJDBC;
import SchemaDataBase.SchemaMYSQL;

import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        ConnectionMYQSL.getConnection();

        InitializeJDBC.createSchema();
        InitializeJDBC.loadTables();

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

        ConnectionMYQSL.closeConnection();
    }
}
