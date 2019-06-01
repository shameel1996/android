package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyPropertyType implements Serializable {
    @SerializedName("propertyType")
    @Expose
    private String propertyType;

    @SerializedName("id")
    @Expose
    private String id;

    public String getPropertyType() {
        return propertyType;
    }

    public String getId() {
        return id;
    }
}
