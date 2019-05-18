package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyTypeData {
    @SerializedName("termId")
    @Expose
    private String termId;
    @SerializedName("name")
    @Expose
    private String propertyName;


    public PropertyTypeData(String termId, String propertyName) {
        this.termId = termId;
        this.propertyName = propertyName;
    }

    public String getTermId() {
        return termId;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
