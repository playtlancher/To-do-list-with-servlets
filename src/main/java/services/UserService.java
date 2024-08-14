package services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import exceptions.IncorrectUsernameOrPasswordException;
import exceptions.UserWithThisEmailAlreadyExistException;
import exceptions.UserWithThisNameAlreadyExistException;

import java.io.IOException;
import java.sql.SQLException;

public interface UserService {
    void registration(User user) throws UserWithThisEmailAlreadyExistException,UserWithThisNameAlreadyExistException, SQLException;
    User login(User user) throws IncorrectUsernameOrPasswordException, SQLException;
    void logOut(HttpServletRequest request , HttpServletResponse response) throws IOException;
}
