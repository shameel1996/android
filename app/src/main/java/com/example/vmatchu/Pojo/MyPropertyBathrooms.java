package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyBathrooms {
    @SerializedName("bathroom")
    @Expose
    private String bathroom;

    public String getBathroom() {
        return bathroom;
    }
}
