package Initialize;

import CSVfiles.CSVreader;
import Daos.Interfaces.ClientDAO;
import Daos.Interfaces.FactureDAO;
import Daos.Interfaces.Facture_ProductDAO;
import Daos.Interfaces.ProductDAO;
import Entity.Client;
import Entity.Facture;
import Entity.Facture_Product;
import Entity.Product;
import Factory.DAOFactory;
import SchemaDataBase.SchemaMYSQL;

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
