package com.example.vmatchu.Models;

public class MyPropertyPropertyTypeForDB {
    String pid;
    String property_type;

    public MyPropertyPropertyTypeForDB(String pid, String property_type) {
        this.pid = pid;
        this.property_type = property_type;
    }

    public String getPid() {
        return pid;
    }

    public String getProperty_type() {
        return property_type;
    }
}
