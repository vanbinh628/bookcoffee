package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoreList {
    @SerializedName("data")
    private List<Store> storeList;

    public StoreList() {
    }

    public StoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public List<Store> getStoreList() {
        return storeList;
    }
}
