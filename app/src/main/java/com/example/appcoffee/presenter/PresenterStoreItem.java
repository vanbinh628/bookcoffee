package com.example.appcoffee.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.adapter.AdapterStoreBase;
import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.APIServiceIml;
import com.example.appcoffee.model.Store;
import com.example.appcoffee.view.HandleStore;
import com.example.appcoffee.view.MvpView;

import java.util.ArrayList;
import java.util.List;

public class PresenterStoreItem extends BasePresenter {
    MvpView mvpView;
    HandleStore handleStore;
    RecyclerView.LayoutManager layoutManager;
    AdapterStoreBase adapter;
    List<Store> storeList;
    APIServiceIml apiServiceIml;

    public AdapterStoreBase getAdapter() {
        return adapter;
    }

    @SuppressLint("WrongConstant")
    public PresenterStoreItem(Context context, MvpView mvpView, HandleStore handleStore) {
        super(context);
        this.mvpView = mvpView;
        this.handleStore = handleStore;

        apiServiceIml = new APIServiceIml();
        storeList = new ArrayList<>();
        adapter = new AdapterStoreBase(context, storeList, handleStore);
    }


    public void DeleteData(){
        storeList.clear();
        adapter.notifyDataSetChanged();
    }

    public void FetchData(){
        mvpView.showLoading();
       apiServiceIml.getAllStore(new FetchDataListStore() {
           @Override
           public void OnFetchSuccess(List<Store> storeList1) {
               storeList.addAll(storeList1);
               adapter.notifyDataSetChanged();
               handleStore.chooseStore(storeList.get(1));
               mvpView.hideLoading();
           }

           @Override
           public void getStore(Store store) {

           }

           @Override
           public void OnFetchFailure(Exception e) {
               Toast.makeText(context, R.string.errorNetwork, Toast.LENGTH_LONG).show();
               mvpView.hideLoading();
           }
       });
    }
}
