package com.example.appcoffee.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AddOn implements Serializable {
    @SerializedName("config")
    private List<Config> configs;

    @SerializedName("name")
    private String name;
    @SerializedName("is_multiple ")
    private Boolean isMultiple;

    public AddOn() {

    }

    public AddOn(List<Config> configs, String name) {
        this.configs = configs;
        this.name = name;
    }

    public void setConfigs(List<Config> configs) {
        this.configs = configs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Config> getConfigs() {
        return configs;
    }

    public String getName() {
        return name;
    }

    public void setMultiple(Boolean multiple) {
        isMultiple = multiple;
    }

    public Boolean getMultiple() {
        return isMultiple;
    }

    @Override
    public String toString() {
        String string = "";
        for(int i=0; i< configs.size(); i++){
            if(configs.get(i).getCheck() != null && configs.get(i).getCheck()==true){
                if(configs.get(i).getName() != null && configs.get(i).getName() != "" ){
                    string += configs.get(i).getName() + " " + getName() + ", ";
                } else if(configs.get(i).getPercent() != null){
                    int percent = (int)(configs.get(i).getPercent()*100);
                    string +=String.valueOf(percent)+"%" + " " + getName() + ", ";
                }
            }
        }
        if(string.length() > 3){
            string = string.substring(0, string.length()-2);
        }
        return string;
    }
}
