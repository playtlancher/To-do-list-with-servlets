package servlets;

import Classes.User;
import dao.impl.UserDaoImpl;
import exceptions.IncorrectUsernameOrPasswordException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import services.UserService;
import services.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();


        User user = new User(username, password);
        try {
            user = userService.login(user);
            session.setAttribute("id", user.getId());
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            response.sendRedirect("taskPage.jsp");
        } catch (IncorrectUsernameOrPasswordException | SQLException e) {
            session.setAttribute("message", "Wrong username or password");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
