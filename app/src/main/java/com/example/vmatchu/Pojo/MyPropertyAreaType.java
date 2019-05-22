package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyAreaType {
    @SerializedName("areaType")
    @Expose
    private String areaType;

    public String getAreaType() {
        return areaType;
    }
}
