package com.example.apimedal.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelMedal {
        @SerializedName("status")
        String status;
        @SerializedName("result")
        Medal mMedal;
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
        public Medal getKontak() {
            return mMedal;
        }
        public void setmMedal(Medal Medal) {
            mMedal = Medal;
        }
    }
