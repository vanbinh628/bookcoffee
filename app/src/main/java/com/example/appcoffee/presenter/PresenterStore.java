package com.example.appcoffee.presenter;

import android.content.Context;

import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.APIServiceIml;

public class PresenterStore extends BasePresenter {
    private FetchDataListStore fetchDataListStore;
    private APIServiceIml apiServiceIml;
    public PresenterStore(Context context, FetchDataListStore fetchData) {
        super(context);
        fetchDataListStore = fetchData;
        apiServiceIml = new APIServiceIml();
    }
    public void FetchData(){
        apiServiceIml.getAllStore(fetchDataListStore);
    }
}
