package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RemainingMoneyResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("value")
    @Expose
    private int value;

    public String getError() {
        return error;
    }

    public int getValue() {
        return value;
    }
}
