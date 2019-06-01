package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyBedrooms implements Serializable {
    @SerializedName("bedroom")
    @Expose
    private String bedroom;

    public String getBedroom() {
        return bedroom;
    }
}
