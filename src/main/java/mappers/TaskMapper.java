package mappers;

import models.Task;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static List<Task> mapToTasks(ResultSet resultSet) throws SQLException {
        List<Task> taskList = new ArrayList<>();

        while (resultSet.next()) {
            Task task = new Task();
            task.setTask(resultSet.getString("task"));
            task.setDescription(resultSet.getString("description"));
//            task.setDate((Data) resultSet.getDate("date"));
            task.setStatus(resultSet.getString("status"));
            taskList.add(task);
        }

        return taskList;
    }
}
