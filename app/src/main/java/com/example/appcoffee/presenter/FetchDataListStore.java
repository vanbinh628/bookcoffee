package com.example.appcoffee.presenter;

import com.example.appcoffee.model.Store;
import com.example.appcoffee.model.StoreList;

import java.util.List;

public interface FetchDataListStore {
    void OnFetchSuccess(List<Store> storeList);
    void getStore(Store store);
    void OnFetchFailure(Exception e);
}
