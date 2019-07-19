package com.example.appcoffee.presenter;

import com.example.appcoffee.model.Product;
import com.example.appcoffee.model.User;

import java.util.List;

public interface FetchDataUserCallback {
    void OnFetchSuccess(User user);
    void OnFetchFault(Exception e);
}
