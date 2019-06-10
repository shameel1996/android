package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertySubArea implements Serializable {
    @SerializedName("subArea")
    @Expose
    private String subArea;

    @SerializedName("id")
    @Expose
    private String id;

    public String getSubArea() {
        return subArea;
    }

    public String getId() {
        return id;
    }
}
