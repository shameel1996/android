package com.example.vmatchu.Models;

public class MyPropertyBathroomsForDB {
    String pid;
    String bathrooms;

    public MyPropertyBathroomsForDB(String pid, String bathrooms) {
        this.pid = pid;
        this.bathrooms = bathrooms;
    }

    public String getPid() {
        return pid;
    }

    public String getBathrooms() {
        return bathrooms;
    }
}


