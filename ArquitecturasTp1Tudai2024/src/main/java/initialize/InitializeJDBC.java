package initialize;

import csvFiles.CSVreader;
import dao.Interfaces.ClientDAO;
import dao.Interfaces.FactureDAO;
import dao.Interfaces.Facture_ProductDAO;
import dao.Interfaces.ProductDAO;
import entity.Client;
import entity.Facture;
import entity.Facture_Product;
import entity.Product;
import factory.DAOFactory;
import schemaDataBase.SchemaMYSQL;

import java.sql.SQLException;
import java.util.List;

public class InitializeJDBC {


    public static void createSchema() throws SQLException {
        SchemaMYSQL schemaMYSQL = new SchemaMYSQL();
        schemaMYSQL.createSchema();
    }

    public static void loadTables() throws SQLException{
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
        CSVreader csv = new CSVreader();
        if (daoFactory != null) {
            ProductDAO productDAO = daoFactory.getProductDAO();
            loadProduct(csv.readFileProduct(), productDAO);
            ClientDAO clientDAO = daoFactory.getClientDAO();
            loadClient(csv.readFileClient(), clientDAO);
            FactureDAO factureDAO = daoFactory.getFactureDAO();
            loadFacture(csv.readFileFacture(), factureDAO);
            Facture_ProductDAO facture_productDAO = daoFactory.getFacture_ProductDAO();
            loadFacture_Product(csv.readFileFactureProduct(),facture_productDAO);
        }

    }

    private static void loadProduct(List<Product> products,ProductDAO productDAO){
        products.forEach(p -> {
            try {
                productDAO.insert(p);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void loadClient(List<Client> clients, ClientDAO clientDAO){
        clients.forEach(c -> {
            try {
                clientDAO.insert(c);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void loadFacture(List<Facture> factures, FactureDAO factureDAO){
        factures.forEach(f -> {
            try {
                factureDAO.insert(f);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void loadFacture_Product(List<Facture_Product> fProducs, Facture_ProductDAO facture_productDAO){
        fProducs.forEach(fp -> {
            try {
                facture_productDAO.insert(fp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
