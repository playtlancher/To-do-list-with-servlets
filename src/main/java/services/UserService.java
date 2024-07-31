package services;

import Classes.User;
import exceptions.IncorrectUsernameOrPasswordException;
import exceptions.UserWithThisEmailAlreadyExistException;
import exceptions.UserWithThisNameAlreadyExistException;

import java.sql.SQLException;

public interface UserService {
    void registration(User user) throws UserWithThisEmailAlreadyExistException,UserWithThisNameAlreadyExistException, SQLException;
    User login(User user) throws IncorrectUsernameOrPasswordException, SQLException;
}
