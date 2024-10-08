package org.example;

import dto.ClientMaxFactureDTO;
import dto.ProductColletedDTO;
import dao.MYSQLDaos.MYSQLClientDAO;
import dao.MYSQLDaos.MYSQLProductDAO;
import factory.ConnectionMYQSL;
import initialize.InitializeJDBC;

import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        ConnectionMYQSL.getConnection();

        InitializeJDBC.createSchema();
        InitializeJDBC.loadTables();

        System.out.println("\nEl producto que mas recaudo es: "); //Ejercicio 3

        List<ProductColletedDTO>productCollected = MYSQLProductDAO.getInstance().selectMostProductColleted();

        for (ProductColletedDTO c : productCollected){
            System.out.println(c.toString());
        }

        System.out.println("\nClientes mas facturados: "); //Ejercicio 4

        List<ClientMaxFactureDTO>clientesMasFacturados = MYSQLClientDAO.getInstance().selectMaxFacture();

        for (ClientMaxFactureDTO c : clientesMasFacturados){
            System.out.println(c.toString());
        }

        ConnectionMYQSL.closeConnection();
    }
}
