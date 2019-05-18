package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SectorResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("sectors")
    @Expose
    private List<CityAreaSubareaSectorDetailsResponse> sectors;

    public String getError() {
        return error;
    }

    public List<CityAreaSubareaSectorDetailsResponse> getSectors() {
        return sectors;
    }
}
