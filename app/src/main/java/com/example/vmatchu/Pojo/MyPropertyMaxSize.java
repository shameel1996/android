package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyMaxSize {
    @SerializedName("maxSize")
    @Expose
    private String maxSize;

    @SerializedName("pid")
    @Expose
    private String pid;

    public String getMaxSize() {
        return maxSize;
    }

    public String getPid() {
        return pid;
    }
}
