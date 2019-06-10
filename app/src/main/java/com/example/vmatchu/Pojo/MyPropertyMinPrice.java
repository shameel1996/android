package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyMinPrice {
    @SerializedName("minPrice")
    @Expose
    private String minPrice;

    @SerializedName("pid")
    @Expose
    private String pid;

    public String getMinPrice() {
        return minPrice;
    }

    public String getPid() {
        return pid;
    }
}
