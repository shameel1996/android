package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyStatus implements Serializable {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("id")
    @Expose
    private String id;

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }
}
