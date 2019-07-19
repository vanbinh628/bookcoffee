package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

public class Store {
    @SerializedName("address")
    private String address;

    @SerializedName("close_time")
    private String closeTime;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private String id;

    @SerializedName("img_url")
    private String img_url;


    @SerializedName("name")
    private String name;

    @SerializedName("open_time")
    private String openTime;

    @SerializedName("query")
    private String query;

    @SerializedName("updated_at")
    private String updatedAt;

    public Store() {
    }

    public Store(String address, String closeTime, String createdAt, String id, String name, String openTime, String query, String updatedAt) {
        this.address = address;
        this.closeTime = closeTime;
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.openTime = openTime;
        this.query = query;
        this.updatedAt = updatedAt;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAddress() {
        return address;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getQuery() {
        return query;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url() {
        return img_url;
    }
}
