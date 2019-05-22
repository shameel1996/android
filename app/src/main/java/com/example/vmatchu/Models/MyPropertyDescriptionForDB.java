package com.example.vmatchu.Models;

public class MyPropertyDescriptionForDB {
    String pid;
    String description;

    public MyPropertyDescriptionForDB(String pid, String description) {
        this.pid = pid;
        this.description = description;
    }

    public String getPid() {
        return pid;
    }

    public String getDescription() {
        return description;
    }
}
