package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("add_on")
    private List<AddOn> addOn;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("currency")
    private  String currency;

    @SerializedName("id")
    private String id;

    @SerializedName("img_url")
    private String img_url;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private Long price;


    @SerializedName("status")
    private String status;

    @SerializedName("type")
    private String type;

    @SerializedName("updated_at")
    private String updated_at;

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public Product(String created_at, String currency, String id, String img_url, String name, Long price, String status, String type, String updated_at) {
        this.created_at = created_at;
        this.currency = currency;
        this.id = id;
        this.img_url = img_url;
        this.name = name;
        this.price = price;
        this.status = status;
        this.type = type;
        this.updated_at = updated_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getCurrency() {
        return currency;
    }

    public String getId() {
        return id;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setAddOn(List<AddOn> addOn) {
        this.addOn = addOn;
    }

    public List<AddOn> getAddOn() {
        return addOn;
    }
}
