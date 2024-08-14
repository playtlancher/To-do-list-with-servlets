package servlets;

import dao.impl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UserService;
import services.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    private final UserService userService;

    public LogOutServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.logOut(req, resp);
    }
}
