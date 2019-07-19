package com.example.appcoffee.presenter;

import android.content.Context;

import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.APIServiceIml;

public class PresenterUserProfile extends BasePresenter {
    private FetchDataUserCallback  fetchDataUserCallback;
    APIServiceIml apiServiceIml;

    public PresenterUserProfile(Context context, FetchDataUserCallback fetchDataUserCallback) {
        super(context);
        this.fetchDataUserCallback = fetchDataUserCallback;
        apiServiceIml =  new APIServiceIml();
    }
    public void FetchData(){
        apiServiceIml.getProfileUser(fetchDataUserCallback);
    }

}
