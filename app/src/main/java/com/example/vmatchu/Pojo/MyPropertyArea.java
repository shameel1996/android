package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyArea  implements Serializable {
    @SerializedName("area")
    @Expose
    private String area;

    @SerializedName("id")
    @Expose
    private String id;

    public String getArea() {
        return area;
    }

    public String getId() {
        return id;
    }
}
