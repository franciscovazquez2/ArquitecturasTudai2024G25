package Factory;

import Dao.CustomerDAO;
import Dao.MYSQLClientDAO;
import Dao.MYSQLFactureDAO;
import Dao.MYSQLProductDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    public CustomerDAO getClientDAO() {
        createDriver();
        return new MYSQLClientDAO();
    }

    @Override
    public CustomerDAO getFactureDAO() {
        createDriver();
        return new MYSQLFactureDAO();
    }

    @Override
    public CustomerDAO getProductDAO() {
        createDriver();
        return new MYSQLProductDAO();
    }
}
