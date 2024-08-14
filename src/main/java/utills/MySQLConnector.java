package utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements Connector {
    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String username = "root";
    private final static String password = "12345";
    private final static String url = "jdbc:mysql://localhost:3306/todolist";

    @Override
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
}
