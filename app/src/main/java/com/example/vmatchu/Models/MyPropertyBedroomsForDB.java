package com.example.vmatchu.Models;

public class MyPropertyBedroomsForDB {
    String pid;
    String bedrooms;

    public MyPropertyBedroomsForDB(String pid, String bedrooms) {
        this.pid = pid;
        this.bedrooms = bedrooms;
    }

    public String getPid() {
        return pid;
    }

    public String getBedrooms() {
        return bedrooms;
    }
}
