package dao.impl;

import dao.TaskDao;
import mappers.TaskMapper;
import models.Task;
import utills.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TaskDaoImpl implements TaskDao {
    private Connection connection;

    public TaskDaoImpl() {
        this.connection = new MySQLConnector().getConnection();
    }

    @Override
    public List<Task> getTasksByUserId(int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT task, description, date, status FROM todolist.tasks WHERE user_id = ?");
        statement.setString(1, String.valueOf(userId));
        ResultSet resultSet = statement.executeQuery();
        return TaskMapper.mapToTasks(resultSet);
    }
}
