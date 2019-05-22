package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyPropertyType {
    @SerializedName("propertyType")
    @Expose
    private String propertyType;

    public String getPropertyType() {
        return propertyType;
    }
}
