package com.example.appcoffee.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductOrder implements Serializable {
    private List<AddOn> addOn;

    private String id;

    private String name;

    private Long price;

    private Integer quantity;

    private Long total;

    public ProductOrder() {
        this.addOn = new ArrayList<>();
        this.id = "";
        this.name = "";
        this.price = (long)0;
        this.quantity = 0;
        this.total = (long)0;
    }

    public ProductOrder(List<AddOn> addOn, String id, String name, Long price, Integer quantity, Long total) {
        this.addOn = addOn;
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }
    public ProductOrder(Product product, int quantity){
        this.addOn = product.getAddOn();
        this.id = product.getId();
        this.name = product.toString();
        this.price = product.getPrice();
        this.quantity = quantity;
    }
    public void handleCalculateTotal(){
        long total = 0;
        List<AddOn> listAddOn = getAddOn();
        for(int i =0; i < getAddOn().size(); i++){
            for(int j = 0; j < listAddOn.get(i).getConfigs().size(); j++ ){
                Config config = listAddOn.get(i).getConfigs().get(j);
                if(config.getCheck() != null && config.getCheck() == true && config.getPrice() != null && config.getPrice() > (long)0)
                    total += (long)config.getPrice();
            }
        }
        if(quantity == null || quantity <=0){
            Log.d("Error","Error quantity " + getName());
            return;
        }
        setTotal((long)total*quantity);
    }

    public void setAddOn(List<AddOn> addOn) {
        this.addOn = addOn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<AddOn> getAddOn() {
        return addOn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getTotal() {
        return total;
    }
}
