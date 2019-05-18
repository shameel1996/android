package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("city")
    @Expose
    private List<CityAreaSubareaSectorDetailsResponse> city;

    public String getError() {
        return error;
    }

    public List<CityAreaSubareaSectorDetailsResponse> getCity() {
        return city;
    }
}
