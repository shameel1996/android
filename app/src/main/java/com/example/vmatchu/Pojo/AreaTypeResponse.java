package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaTypeResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("area_type")
    @Expose
    private List<CityAreaSubareaSectorDetailsResponse> areaType;

    public String getError() {
        return error;
    }

    public List<CityAreaSubareaSectorDetailsResponse> getAreaType() {
        return areaType;
    }
}

