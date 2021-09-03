package com.example.appcoffee.activity;

public class orderBasic {
    private int stt;
    private String name;
    private String price;

    public orderBasic(int stt, String name, String price) {
        this.stt = stt;
        this.name = name;
        this.price = price;
    }

    public int getStt() {
        return stt;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }



    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
