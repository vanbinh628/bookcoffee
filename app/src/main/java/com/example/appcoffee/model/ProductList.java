package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {
    @SerializedName("data")
    private List<Product> products;

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
