import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBaseConnection con = new DataBaseConnection();
        PasswordHasher hasher = new PasswordHasher();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String hashedPassword = con.getData(username,"password");

        HttpSession session = request.getSession();

        session.setAttribute("enteredUsername", username);

        if (hasher.checkPassword(password, hashedPassword)) {
            session.setAttribute("EnteredUsername",null);

            Cookie cookieUser = new Cookie("username",username);
            Cookie cookiePassword = new Cookie("password",hashedPassword);

            cookieUser.setMaxAge(3600);
            cookiePassword.setMaxAge(3600);


            response.addCookie(cookieUser);
            response.addCookie(cookiePassword);

            response.sendRedirect(request.getContextPath() + "/taskPage.jsp");
        }else {
            session.setAttribute("message", "Wrong username or password");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}