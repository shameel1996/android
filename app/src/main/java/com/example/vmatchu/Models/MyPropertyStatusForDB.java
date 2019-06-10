package com.example.vmatchu.Models;

public class MyPropertyStatusForDB {
    String pid;
    String status;

    public MyPropertyStatusForDB(String pid, String status) {
        this.pid = pid;
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public String getStatus() {
        return status;
    }
}
