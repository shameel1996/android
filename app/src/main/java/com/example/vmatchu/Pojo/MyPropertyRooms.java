package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyRooms {
    @SerializedName("room")
    @Expose
    private String room;

    public String getRoom() {
        return room;
    }
}
