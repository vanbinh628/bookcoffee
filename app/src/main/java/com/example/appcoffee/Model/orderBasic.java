package com.example.appcoffee.Model;

public class orderBasic {
    int number;
    String name;
    String price;

    public orderBasic(int number, String name, String price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public orderBasic() {
        this.number = 0;
        this.name = "";
        this.price = "";
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
