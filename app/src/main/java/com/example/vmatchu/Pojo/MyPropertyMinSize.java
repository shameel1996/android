package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyMinSize {

    @SerializedName("minSize")
    @Expose
    private String minSize;

    @SerializedName("pid")
    @Expose
    private String pid;

    public String getMinSize() {
        return minSize;
    }

    public String getPid() {
        return pid;
    }
}
