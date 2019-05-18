package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityAreaSubareaSectorDetailsResponse {
    @SerializedName("termId")
    @Expose
    private String termId;

    @SerializedName("name")
    @Expose
    private String name;


    public CityAreaSubareaSectorDetailsResponse(String termId, String name) {
        this.termId = termId;
        this.name = name;
    }

    public String getTermId() {
        return termId;
    }

    public String getName() {
        return name;
    }
}
