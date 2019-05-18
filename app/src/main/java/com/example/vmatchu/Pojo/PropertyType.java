package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyType {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private List<PropertyTypeData> data;

    public String getError() {
        return error;
    }

    public List<PropertyTypeData> getData() {
        return data;
    }
}
