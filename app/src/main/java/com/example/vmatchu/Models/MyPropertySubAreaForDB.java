package com.example.vmatchu.Models;

public class MyPropertySubAreaForDB {
    String pid;
    String sub_area;

    public MyPropertySubAreaForDB(String pid, String sub_area) {
        this.pid = pid;
        this.sub_area = sub_area;
    }

    public String getPid() {
        return pid;
    }

    public String getSub_area() {
        return sub_area;
    }
}
