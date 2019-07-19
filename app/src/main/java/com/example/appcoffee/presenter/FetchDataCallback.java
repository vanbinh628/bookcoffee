package com.example.appcoffee.presenter;

import com.example.appcoffee.model.ClientResponse;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.model.User;

import java.util.List;

public interface FetchDataCallback {
    void OnFetchSuccess(List<Product> productList);
    void OnFetchFault(Exception e);
}

