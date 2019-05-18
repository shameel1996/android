package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubAreaResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("sub_areas")
    @Expose
    private List<CityAreaSubareaSectorDetailsResponse> sub_areas;

    public String getError() {
        return error;
    }

    public List<CityAreaSubareaSectorDetailsResponse> getSubAreas() {
        return sub_areas;
    }
}
