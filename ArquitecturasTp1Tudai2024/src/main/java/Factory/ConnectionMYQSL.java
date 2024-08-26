package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMYQSL {

    public static final String URI="jdbc:mysql://localhost:3306/dbArquiTpG25";
    public static final String USER="user";
    public static final String PASSWORD="password";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null){
            conn = DriverManager.getConnection(URI,USER,PASSWORD);
            conn.setAutoCommit(false);
        }
        return conn;
    }
}
