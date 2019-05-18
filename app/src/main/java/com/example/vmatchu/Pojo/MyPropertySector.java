package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertySector {
    @SerializedName("sector")
    @Expose
    private String sector;

    public String getSector() {
        return sector;
    }
}
