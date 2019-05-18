package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyCity {
    @SerializedName("city")
    @Expose
    private String city;

    public String getCity() {
        return city;
    }
}
