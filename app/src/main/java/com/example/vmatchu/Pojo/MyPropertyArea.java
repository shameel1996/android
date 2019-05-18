package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyArea {
    @SerializedName("area")
    @Expose
    private String area;

    public String getArea() {
        return area;
    }
}
