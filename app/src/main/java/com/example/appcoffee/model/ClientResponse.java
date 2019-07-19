package com.example.appcoffee.model;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

public class ClientResponse {
    @SerializedName("data")
    private User user;
    @SerializedName("status")
    private String status;

    public ClientResponse(User user, String status) {
        this.user = user;
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }
}
