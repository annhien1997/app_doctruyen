package com.diemthithu.doctruyen.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_truyen {
    @SerializedName("status")
    private boolean status;
    @SerializedName("msg")
    private String message;
    @SerializedName("data")
    private List<Truyen> truyenList;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Truyen> getTruyenList() {
        return truyenList;
    }

    public void setTruyenList(List<Truyen> truyenList) {
        this.truyenList = truyenList;
    }
}
