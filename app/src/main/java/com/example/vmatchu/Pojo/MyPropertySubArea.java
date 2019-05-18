package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertySubArea {
    @SerializedName("subArea")
    @Expose
    private String subArea;

    public String getSubArea() {
        return subArea;
    }
}
