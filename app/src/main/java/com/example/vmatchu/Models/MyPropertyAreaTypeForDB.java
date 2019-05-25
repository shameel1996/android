package com.example.vmatchu.Models;

public class MyPropertyAreaTypeForDB {
    String pid;
    String area_type;

    public MyPropertyAreaTypeForDB(String pid, String area_type) {
        this.pid = pid;
        this.area_type = area_type;
    }

    public String getPid() {
        return pid;
    }

    public String getArea_type() {
        return area_type;
    }
}
