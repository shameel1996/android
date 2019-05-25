package com.example.vmatchu.Models;

public class MyPropertyAreaForDB {
    String pid;
    String area;

    public MyPropertyAreaForDB(String pid, String area) {

        this.pid = pid;
        this.area = area;
    }

    public String getPid() {
        return pid;
    }

    public String getArea() {
        return area;
    }
}
