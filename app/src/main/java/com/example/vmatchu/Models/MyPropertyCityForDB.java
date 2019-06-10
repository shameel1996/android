package com.example.vmatchu.Models;

public class MyPropertyCityForDB {
    String pid;
    String city;

    public MyPropertyCityForDB(String pid, String city) {
        this.pid = pid;
        this.city = city;
    }

    public String getPid() {
        return pid;
    }

    public String getCity() {
        return city;
    }
}
