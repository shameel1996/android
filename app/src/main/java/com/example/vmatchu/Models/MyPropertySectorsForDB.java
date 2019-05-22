package com.example.vmatchu.Models;

public class MyPropertySectorsForDB {
    String pid;
    String sectors;

    public MyPropertySectorsForDB(String pid, String sectors) {
        this.pid = pid;
        this.sectors = sectors;
    }

    public String getPid() {
        return pid;
    }

    public String getSectors() {
        return sectors;
    }
}
