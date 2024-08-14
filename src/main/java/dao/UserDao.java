package dao;

import models.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao {
    void insert(User object) throws SQLException;
    User getById(int id) throws SQLException;
    Optional<User> getByEmail(String email) throws SQLException;
    User getByName(String name) throws SQLException;
}
