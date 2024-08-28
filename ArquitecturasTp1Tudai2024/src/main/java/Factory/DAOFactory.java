package Factory;

import Daos.Interfaces.ClientDAO;
import Daos.Interfaces.FactureDAO;
import Daos.Interfaces.ProductDAO;

import java.sql.SQLException;

public abstract class DAOFactory {
    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;

    public abstract ClientDAO getClientDAO() throws SQLException;
    public abstract FactureDAO getFactureDAO() throws SQLException;
    public abstract ProductDAO getProductDAO() throws SQLException;

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
