package com.example.vmatchu.Pojo;

public class MyPropertyForDB {
    String pid;
    String title;
    String date;

    public MyPropertyForDB(String pid,String title, String date) {
        this.pid = pid;
        this.title = title;
        this.date = date;
    }


    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }


}
