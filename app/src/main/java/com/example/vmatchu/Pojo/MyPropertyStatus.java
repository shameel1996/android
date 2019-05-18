package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyStatus {
    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }
}
