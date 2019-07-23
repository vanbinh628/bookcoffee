package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

public class Config {
    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private Integer price;

    @SerializedName("currency")
    private String currency;

    @SerializedName("percent")
    private Float  percent;

    private Boolean isCheck;



    public Config() {
        this.percent = Float.valueOf(0);
        this.currency = "";
        this.name = "";
        this.price = 0;
    }

    public Config(String name, Integer price, String currency) {
        this.percent = Float.valueOf(0);
        this.currency = currency;
        this.name = name;
        this.price = price;
    }
    public Config(Float percent) {
        this.percent = percent;
        this.currency = "";
        this.name = "";
        this.price = 0;
    }

    public Float getPercent() {
        return percent;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public Boolean getCheck() {
        return isCheck;
    }

}
