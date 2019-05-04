package com.example.apimedal.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMedal {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Medal> listDataMedal;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Medal> getListDataMedal() {
        return listDataMedal;
    }
    public void setListDataMedal(List<Medal> listDataMedal) {
        this.listDataMedal = listDataMedal;
    }
}
