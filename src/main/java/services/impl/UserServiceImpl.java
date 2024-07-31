package services.impl;

import Classes.User;
import dao.UserDao;
import exceptions.UserWithThisEmailAlreadyExistException;
import services.UserService;
import exceptions.UserWithThisNameAlreadyExistException;
import utills.DataBaseConnection;
import utills.PasswordHasher;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void registration(User user) throws UserWithThisEmailAlreadyExistException, UserWithThisNameAlreadyExistException, SQLException {
        DataBaseConnection con = new DataBaseConnection();

        String username = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();

        if (!con.userExistByName(user.getName()) && !con.userExistByEmail(user.getEmail())) {
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            con.insertData(sql, username, email, PasswordHasher.hashPassword(password));
        }else if (con.userExistByName(username)){
            throw new UserWithThisNameAlreadyExistException(username);
        }else if(con.userExistByEmail(email)) {
            throw new UserWithThisEmailAlreadyExistException(email);
        }
    }

    @Override
    public User login(User user) throws SQLException {
        if (user.isValidUser()) {
            return userDao.getByName(user.getName());
        }
        return new User();
    }
}
