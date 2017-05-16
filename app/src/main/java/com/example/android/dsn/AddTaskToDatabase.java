package com.example.android.dsn;

/**
 * Created by ShazaHassan on 14-May-17.
 */

public class AddTaskToDatabase {
    private String taskID,taskNo,taskDescription,taskDeadline;

    public AddTaskToDatabase(String taskID, String taskNo, String taskDescription, String taskDeadline) {
        this.taskID = taskID;
        this.taskNo = taskNo;
        this.taskDescription = taskDescription;
        this.taskDeadline = taskDeadline;
    }

    public AddTaskToDatabase() {
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }
}
