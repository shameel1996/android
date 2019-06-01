package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyRooms implements Serializable {
    @SerializedName("room")
    @Expose
    private String room;

    public String getRoom() {
        return room;
    }
}
