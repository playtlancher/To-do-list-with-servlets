package servlets;

import jakarta.servlet.http.HttpSession;
import models.User;
import dao.impl.UserDaoImpl;
import services.UserService;
import services.impl.UserServiceImpl;
import exceptions.UserWithThisEmailAlreadyExistException;
import exceptions.UserWithThisNameAlreadyExistException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2)) {
            User user = new User(username, email, password1);

            try {
                userService.registration(user);
                user = userService.login(user);
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("name", user.getName());
                session.setAttribute("email", user.getEmail());
                response.sendRedirect(request.getContextPath() + "/taskPage");
            } catch (UserWithThisNameAlreadyExistException | UserWithThisEmailAlreadyExistException | SQLException e) {
                e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        }

    }
}
