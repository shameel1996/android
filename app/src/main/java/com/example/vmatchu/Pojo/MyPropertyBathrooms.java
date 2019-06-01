package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyBathrooms implements Serializable {
    @SerializedName("bathroom")
    @Expose
    private String bathroom;

    public String getBathroom() {
        return bathroom;
    }
}
