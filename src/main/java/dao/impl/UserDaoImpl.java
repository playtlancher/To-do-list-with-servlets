package dao.impl;

import models.User;
import dao.UserDao;
import mappers.UserMapper;
import utills.MySQLConnector;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl() {
        this.connection = new MySQLConnector().getConnection();
    }

    @Override
    public void insert(User object) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO todolist.users(name, email, password, id) VALUES (?, ?, ?, ?)");
        statement.setString(1, object.getName());
        statement.setString(2, object.getEmail());
        statement.setString(3, object.getPassword());
        statement.setString(4, String.valueOf(object.getId()));
        statement.execute();
    }

    @Override
    public User getById(int id) throws SQLException {
        return new User();
    }

    @Override
    public Optional<User> getByEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name , email, password, id FROM todolist.users WHERE email = ?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        return Optional.ofNullable(UserMapper.mapToUser(resultSet));
    }

    public User getByName (String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name, email, password, id FROM todolist.users WHERE name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        User user = UserMapper.mapToUser(resultSet);
        return user;
    }
}
