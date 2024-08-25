package Factory;

import Daos.Interfaces.ClientDAO;
import Daos.Interfaces.FactureDAO;
import Daos.Interfaces.ProductDAO;
import Daos.MYSQLDaos.MYSQLClientDAO;
import Daos.MYSQLDaos.MYSQLFactureDAO;
import Daos.MYSQLDaos.MYSQLProductDAO;

import java.lang.reflect.InvocationTargetException;

public class MYSQLDaoFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Metodo para crear el driver --- VER SI SE PUEDE MEJORAR O COLOCAR EN OTRO LADO ya que se llama en cada get y el driver es uno solo
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
    public FactureDAO getFactureDAO() {
        createDriver();
        return new MYSQLFactureDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        createDriver();
        return new MYSQLProductDAO();
    }
}
