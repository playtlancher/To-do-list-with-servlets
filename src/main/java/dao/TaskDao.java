package dao;

import models.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    public List<Task> getTasksByUserId(int userId) throws SQLException;
}
