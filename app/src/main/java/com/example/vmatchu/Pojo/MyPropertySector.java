package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertySector implements Serializable {
    @SerializedName("sector")
    @Expose
    private String sector;

    @SerializedName("id")
    @Expose
    private String id;

    public String getSector() {
        return sector;
    }

    public String getId() {
        return id;
    }
}
