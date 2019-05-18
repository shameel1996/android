package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPropertyGarages {
    @SerializedName("garages")
    @Expose
    private String garages;

    public String getGarages() {
        return garages;
    }
}
