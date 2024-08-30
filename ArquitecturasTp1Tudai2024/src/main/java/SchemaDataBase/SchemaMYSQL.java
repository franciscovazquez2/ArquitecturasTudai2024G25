package SchemaDataBase;

import Factory.ConnectionMYQSL;
import Factory.MYSQLDaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class SchemaMYSQL {

    private Connection conn;
    //creacion tablas

    public SchemaMYSQL() throws SQLException {
        this.conn= ConnectionMYQSL.getConnection();
    }

    public void createSchema() throws SQLException {
        MYSQLDaoFactory.createDriver();//revisar... createDriver() es publico, antes no

        String tableClient = "CREATE TABLE client(" +
                            "id INT PRIMARY KEY AUTO_INCREMENT," +
                            "name VARCHAR(500)," +
                            "email VARCHAR(250)" +
                            ");";
        conn.prepareStatement(tableClient).execute();
        conn.commit();

        String tableFacture="CREATE TABLE facture(" +
                            "idFacture INT PRIMARY KEY AUTO_INCREMENT," +
                            "idClient INT,"+
                            "FOREIGN KEY (idClient) REFERENCES client(id)" +
                            ");";
        conn.prepareStatement(tableFacture).execute();
        conn.commit();

        String tableProduct="CREATE TABLE product(" +
                            "idProduct INT PRIMARY KEY AUTO_INCREMENT," +
                            "name VARCHAR(45)," +
                            "price float" +
                            ");";
        conn.prepareStatement(tableProduct).execute();
        conn.commit();

        String tableFacture_Product="CREATE TABLE facture_product(" +
                                    "idFacture INT," +
                                    "idProduct INT," +
                                    "cantidad INT," +
                                    "PRIMARY KEY (idFacture,idProduct)," +
                                    "FOREIGN KEY (idFacture) REFERENCES facture(idFacture)," +
                                    "FOREIGN KEY (idProduct) REFERENCES product(idProduct)" +
                                    ");";
        conn.prepareStatement(tableFacture_Product).execute();
        conn.commit();
    }
}
