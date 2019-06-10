package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyDescription implements Serializable {
    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }
}
