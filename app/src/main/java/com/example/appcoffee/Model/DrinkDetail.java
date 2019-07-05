package com.example.appcoffee.Model;

public class DrinkDetail {
    int image;
    String name;
    String type;
    String price;

    public DrinkDetail(int image, String name, String type, String price) {
        this.image = image;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public DrinkDetail() {
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }
}
