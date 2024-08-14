package services;


import java.time.LocalDate;


public interface TaskService {
    void addTask(String task , String description , LocalDate date , int userId);
}
