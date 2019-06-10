package com.example.vmatchu.Models;

public class MyPropertyRoomsForDB {
    String pid;
    String rooms;

    public MyPropertyRoomsForDB(String pid, String rooms) {
        this.pid = pid;
        this.rooms = rooms;
    }

    public String getPid() {
        return pid;
    }

    public String getRooms() {
        return rooms;
    }
}
