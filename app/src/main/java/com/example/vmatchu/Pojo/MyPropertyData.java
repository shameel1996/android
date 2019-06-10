package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MyPropertyData implements Serializable {
    @SerializedName("pid")
    @Expose
    private String pid;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("postDate")
    @Expose
    private String postDate;

    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getPostDate() {
        return postDate;
    }
}
