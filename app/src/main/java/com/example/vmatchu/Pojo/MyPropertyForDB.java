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

<<<<<<< HEAD
=======
    public MyPropertyForDB() {

    }

    public MyPropertyForDB(String area, String sub_area, String sector) {
        this.area = area;
        this.sub_area = sub_area;
        this.sector = sector;
    }
>>>>>>> a1c7e90cbe6668373bcb3bf19b9116eb91d00b90

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
