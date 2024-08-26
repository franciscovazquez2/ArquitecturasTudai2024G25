package Factory;

import Daos.Interfaces.ClientDAO;
import Daos.Interfaces.FactureDAO;
import Daos.Interfaces.ProductDAO;
import Daos.MYSQLDaos.MYSQLClientDAO;
import Daos.MYSQLDaos.MYSQLFactureDAO;
import Daos.MYSQLDaos.MYSQLProductDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLDaoFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public MYSQLDaoFactory(){
        createDriver();
    }

    //creacion driver se puede hacer en bloque static
    private void createDriver() {
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public ClientDAO getClientDAO() {
        createDriver();
        return new MYSQLClientDAO();
    }

    @Override
    public FactureDAO getFactureDAO() throws SQLException {
        //createDriver();
        return MYSQLFactureDAO.getInstance();
    }

    @Override
    public ProductDAO getProductDAO() throws SQLException {
        //createDriver();
        return MYSQLProductDAO.getInstance();
    }
}
