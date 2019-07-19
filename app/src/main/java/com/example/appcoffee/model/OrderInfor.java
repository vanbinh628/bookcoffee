package com.example.appcoffee.model;

public class OrderInfor {
    private String name;
    private String address;
    private String date;
    private String price;

    public OrderInfor(String name, String address, String date, String price) {
        this.name = name;
        this.address = address;
        this.date = date;
        this.price = price;
    }

    public OrderInfor() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
