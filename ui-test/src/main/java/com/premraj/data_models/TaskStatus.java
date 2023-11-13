package com.premraj.data_models;

public class TaskStatus {
    private final String all;
    private final String completed;
    private final String active;

    public TaskStatus(String all, String completed, String active) {
        this.all = all;
        this.completed = completed;
        this.active = active;
    }

    public String getActive() {
        return active;
    }

    public String getCompleted() {
        return completed;
    }

    public String getAll() {
        return all;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "active=" + active +
                ", completed=" + completed +
                ", all=" + all +
                '}';
    }
}
