package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyDescription {
    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }
}
