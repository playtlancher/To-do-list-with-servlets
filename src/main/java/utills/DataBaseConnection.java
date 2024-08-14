package utills;

import java.sql.*;

public class DataBaseConnection {
    String username = "root";
    String password = "12345";
    String url = "jdbc:mysql://localhost:3306/todolist";

    Connection connection;


    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }
    }

    public void insertData(String sql, Object... params) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String getData(String name, String request) {
        String sql = "SELECT " + request + " FROM users WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString(request);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean userExistByName(String name) {
        String sql = "SELECT COUNT(*) FROM users WHERE name = ?";
        try (
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Якщо count > 0 користувач існує
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking user existence", e);
        }
        return false;
    }
    public boolean userExistByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Якщо count > 0 користувач існує
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking user existence", e);
        }
        return false;
    }
}
