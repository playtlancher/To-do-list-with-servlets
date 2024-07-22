import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBaseConnection con = new DataBaseConnection();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        HttpSession session = request.getSession();

        if (password1.equals(password2) && !password1.isEmpty() && !con.userExistByName(username) && !con.userExistByEmail(email)) {
            String sql = "insert into users (name, email, password) values (?, ?, ?)";
            con.insertData(sql, username, email, PasswordHasher.hashPassword(password1));
            session.setAttribute("message", "Successfully registered");
        }else if (con.userExistByName(username)){
            session.setAttribute("message", "User with this username already exists");
        }else if(con.userExistByEmail(email)) {
            session.setAttribute("message", "User with this email already exists");
        }else if(!password1.equals(password2)) {
            session.setAttribute("message", "Passwords do not match");
        }
        response.sendRedirect(request.getContextPath() + "/register");
    }
}
