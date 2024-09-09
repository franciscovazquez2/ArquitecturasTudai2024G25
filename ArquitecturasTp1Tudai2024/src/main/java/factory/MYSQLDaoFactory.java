package factory;

import dao.Interfaces.ClientDAO;
import dao.Interfaces.FactureDAO;
import dao.Interfaces.Facture_ProductDAO;
import dao.Interfaces.ProductDAO;
import dao.MYSQLDaos.MYSQLClientDAO;
import dao.MYSQLDaos.MYSQLFactureDAO;
import dao.MYSQLDaos.MYSQLFacture_ProductDAO;
import dao.MYSQLDaos.MYSQLProductDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class MYSQLDaoFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    //constructor crea el driver una unica vez
    public MYSQLDaoFactory(){
        createDriver();
    }

    //creacion driver se puede hacer en bloque static
    public static void createDriver() {
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public ClientDAO getClientDAO() throws SQLException {
        return MYSQLClientDAO.getInstance();
    }

    @Override
    public FactureDAO getFactureDAO() throws SQLException {
        return MYSQLFactureDAO.getInstance();
    }

    @Override
    public ProductDAO getProductDAO() throws SQLException {
        return MYSQLProductDAO.getInstance();
    }

    public Facture_ProductDAO getFacture_ProductDAO() throws SQLException {
        return MYSQLFacture_ProductDAO.getInstance();
    }
}
