package ru.tiger.bookprototype.webservice;

/**
 *
 * @author Igor
 */
public class CreateTaskRequest {
    private String taskText;
    private String taskDetails;

    public CreateTaskRequest() {
    }

    public CreateTaskRequest(String taskText, String taskDetails) {
        this.taskText = taskText;
        this.taskDetails = taskDetails;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String task) {
        this.taskText = task;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
