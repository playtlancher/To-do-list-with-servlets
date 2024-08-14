package servlets;

import dao.TaskDao;

import dao.impl.TaskDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Task;
import services.TaskService;
import services.impl.TaskServiceImpl;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/taskPage")
public class TaskPageServlet extends HttpServlet {

    private final TaskDao taskDao;
    private final TaskService taskService;

    public TaskPageServlet() {
        this.taskDao = new TaskDaoImpl();
        this.taskService = new TaskServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        List<Task> tasks = null;
        try {
            tasks = taskDao.getTasksByUserId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("tasks", tasks);

        request.getRequestDispatcher("/taskPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String strDate = request.getParameter("date");
        strDate = strDate.substring(0, 4) + strDate.substring(strDate.length() - 6, strDate.length());
        DateTimeFormatter dataPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(strDate, dataPattern);
        taskService.addTask(request.getParameter("task"), request.getParameter("description"), date, (int) session.getAttribute("id"));
        response.sendRedirect(request.getContextPath() + "/taskPage");
    }
}
