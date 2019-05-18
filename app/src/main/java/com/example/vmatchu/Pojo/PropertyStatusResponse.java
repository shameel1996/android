package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyStatusResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("property_status")
    @Expose
    private List<CityAreaSubareaSectorDetailsResponse> propertyStatus;

    public String getError() {
        return error;
    }

    public List<CityAreaSubareaSectorDetailsResponse> getPropertyStatus() {
        return propertyStatus;
    }
}
