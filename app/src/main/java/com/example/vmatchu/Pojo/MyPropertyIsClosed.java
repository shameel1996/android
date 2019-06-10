package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyIsClosed {
    @SerializedName("pid")
    @Expose
    private String pid;

    @SerializedName("isClosed")
    @Expose
    private String isClosed;

    public String getPid() {
        return pid;
    }

    public String getIsClosed() {
        return isClosed;
    }
}
