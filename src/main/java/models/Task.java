package models;

import javax.xml.crypto.Data;

@lombok.Data
public class Task {
    private Data date;
    private String task;
    private String description;
    private String status = "Scheduled";

    public Task(Data data, String task, String description) {
        this.task = task;
        this.description = description;
        this.date = data;
    }

    public Task(Data data, String task, String description, String status) {
        this.task = task;
        this.description = description;
        this.date = data;
        this.status = status;
    }

    public Task() {
    }

    public String toString() {
        return task + " " + description + " " + status + " ";
    }
}
