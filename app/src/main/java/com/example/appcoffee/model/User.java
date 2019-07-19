package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("email")
    private String email;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("id")
    private String id;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("query")
    private String query;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("verify_number")
    private String verify_number;

    public User() {
    }

    public User(String createdAt, String email, String fullName, String id, String phoneNumber, String query, String updatedAt, String verify_number) {
        this.createdAt = createdAt;
        this.email = email;
        this.fullName = fullName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.query = query;
        this.updatedAt = updatedAt;
        this.verify_number = verify_number;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setVerify_number(String verify_number) {
        this.verify_number = verify_number;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getQuery() {
        return query;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getVerify_number() {
        return verify_number;
    }
}
