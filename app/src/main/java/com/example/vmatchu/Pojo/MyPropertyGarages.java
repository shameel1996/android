package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPropertyGarages implements Serializable {
    @SerializedName("garages")
    @Expose
    private String garages;

    public String getGarages() {
        return garages;
    }
}
