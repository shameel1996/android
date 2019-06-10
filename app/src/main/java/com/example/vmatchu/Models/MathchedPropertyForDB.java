package com.example.vmatchu.Models;

public class MathchedPropertyForDB {
    String pid;
    String title;
    String post_date;
    String status;
    String city;

    public MathchedPropertyForDB(String pid, String title, String post_date, String status, String city) {
        this.pid = pid;
        this.title = title;
        this.post_date = post_date;
        this.status = status;
        this.city = city;
    }

    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getPost_date() {
        return post_date;
    }

    public String getStatus() {
        return status;
    }

    public String getCity() {
        return city;
    }
}
