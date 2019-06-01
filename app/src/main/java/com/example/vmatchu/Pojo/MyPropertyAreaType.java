package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyAreaType implements Serializable {
    @SerializedName("areaType")
    @Expose
    private String areaType;

    @SerializedName("id")
    @Expose
    private String id;

    public String getAreaType() {
        return areaType;
    }

    public String getId() {
        return id;
    }
}
