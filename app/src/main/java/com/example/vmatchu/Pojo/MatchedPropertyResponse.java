package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchedPropertyResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("postDate")
    @Expose
    private String postDate;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("area")
    @Expose
    private String area;

    @SerializedName("subArea")
    @Expose
    private String subArea;

    @SerializedName("sector")
    @Expose
    private String sector;

    public String getError() {
        return error;
    }

    public String getTitle() {
        return title;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getStatus() {
        return status;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getSubArea() {
        return subArea;
    }

    public String getSector() {
        return sector;
    }
}
