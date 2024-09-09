package factory;

import dao.Interfaces.ClientDAO;
import dao.Interfaces.FactureDAO;
import dao.Interfaces.Facture_ProductDAO;
import dao.Interfaces.ProductDAO;

import java.sql.SQLException;

public abstract class DAOFactory {
    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;

    public abstract ClientDAO getClientDAO() throws SQLException;
    public abstract FactureDAO getFactureDAO() throws SQLException;
    public abstract ProductDAO getProductDAO() throws SQLException;
    public abstract Facture_ProductDAO getFacture_ProductDAO() throws SQLException;

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC:
                return new MYSQLDaoFactory();
            case DERBY_JDBC:
                return null;
            default:
                return null;
        }
    }

}
