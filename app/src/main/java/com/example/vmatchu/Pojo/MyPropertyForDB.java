package com.example.vmatchu.Pojo;

public class MyPropertyForDB {
    String pid;
    String title;
    String date;
    String status;
    String city;
    String area;
    String sub_area;
    String sector;


    public MyPropertyForDB(String pid,String title, String date, String status, String city) {
        this.pid = pid;
        this.title = title;
        this.date = date;
        this.status = status;
        this.city = city;
    }

    public MyPropertyForDB(String area, String sub_area, String sector) {
        this.area = area;
        this.sub_area = sub_area;
        this.sector = sector;
    }

    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getSub_area() {
        return sub_area;
    }

    public String getSector() {
        return sector;
    }
}
