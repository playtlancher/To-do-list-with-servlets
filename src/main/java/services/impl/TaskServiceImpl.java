package services.impl;

import services.TaskService;
import utills.DataBaseConnection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TaskServiceImpl implements TaskService {
    @Override
    public void addTask(String task , String description , LocalDate date , int userId) {
        DataBaseConnection con = new DataBaseConnection();


        if (!task.isEmpty() && !description.isEmpty()) {
            String sql = "INSERT INTO tasks (task, description, date , status , user_id) VALUES (?, ?, ?, ?, ?)";
            con.insertData(sql, task, description, date, "Scheduled", userId);
        }
    }
}
