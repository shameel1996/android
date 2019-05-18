package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("areas")
    @Expose
    private List<CityAreaSubareaSectorDetailsResponse> areas;

    public String getError() {
        return error;
    }

    public List<CityAreaSubareaSectorDetailsResponse> getAreas() {
        return areas;
    }
}
