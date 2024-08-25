package Factory;

import Dao.Interfaces.ClientDAO;
import Dao.Interfaces.FactureDAO;
import Dao.Interfaces.ProductDAO;

public abstract class DAOFactory {
    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;

    public abstract ClientDAO getClientDAO();
    public abstract FactureDAO getFactureDAO();
    public abstract ProductDAO getProductDAO();

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
