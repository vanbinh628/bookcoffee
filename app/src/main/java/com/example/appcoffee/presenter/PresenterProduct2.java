package com.example.appcoffee.presenter;

import android.content.Context;

import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.APIServiceIml;

public class PresenterProduct2 extends BasePresenter {
    FetchDataCallback dataCallback;
    APIServiceIml apiServiceIml;
    public PresenterProduct2(Context context, FetchDataCallback dataCallback) {
        super(context);
        this.dataCallback = dataCallback;
        apiServiceIml = new APIServiceIml();
    }
    public void FetchData(){
        apiServiceIml.getProductsCoffee(dataCallback);
    }

}
