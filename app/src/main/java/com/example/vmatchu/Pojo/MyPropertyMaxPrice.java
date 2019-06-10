package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyMaxPrice {
    @SerializedName("maxPrice")
    @Expose
    private String maxPrice;

    @SerializedName("pid")
    @Expose
    private String pid;

    public String getMaxPrice() {
        return maxPrice;
    }

    public String getPid() {
        return pid;
    }
}
