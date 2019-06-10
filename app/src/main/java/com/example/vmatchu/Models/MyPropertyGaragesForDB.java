package com.example.vmatchu.Models;

public class MyPropertyGaragesForDB {
    String pid;
    String garages;

    public MyPropertyGaragesForDB(String pid, String garages) {
        this.pid = pid;
        this.garages = garages;
    }

    public String getPid() {
        return pid;
    }

    public String getGarages() {
        return garages;
    }
}
