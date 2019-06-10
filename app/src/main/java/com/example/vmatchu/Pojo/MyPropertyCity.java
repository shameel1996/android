package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyCity implements Serializable {
    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("id")
    @Expose
    private String id;

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }
}
