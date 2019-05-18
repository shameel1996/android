package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyBedrooms {
    @SerializedName("bedroom")
    @Expose
    private String bedroom;

    public String getBedroom() {
        return bedroom;
    }
}
