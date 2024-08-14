package servlets;
import models.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/auto-login")
public class AutoLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();
                }
            }
        }
        User user = new User(username,password);
        if (user.isValidUser()) {
            response.sendRedirect(request.getContextPath() + "/taskPage.jsp");
        } else {
            System.out.println("autoLogin failed");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }



}
