package Factory;

import Dao.CustomerDAO;

public abstract class DAOFactory {
    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;

    public abstract CustomerDAO getClientDAO();
    public abstract CustomerDAO getFactureDAO();
    public abstract CustomerDAO getProductDAO();

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
