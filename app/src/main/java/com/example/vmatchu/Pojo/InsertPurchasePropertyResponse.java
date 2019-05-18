package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertPurchasePropertyResponse {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("userId")
    @Expose
    private String userId;

    public String getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getPid() {
        return pid;
    }

    public String getUserId() {
        return userId;
    }
}
