package com.example.appcoffee.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.adapter.AdapterStoreDetail;
import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.APIServiceIml;
import com.example.appcoffee.model.Store;
import com.example.appcoffee.other.RecyclerViewMargin;
import com.example.appcoffee.view.MvpView;

import java.util.ArrayList;
import java.util.List;

public class PresenterStoreItem extends BasePresenter {
    MvpView mvpView;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    AdapterStoreDetail adapter;
    List<Store> storeList;
    APIServiceIml apiServiceIml;


    @SuppressLint("WrongConstant")
    public PresenterStoreItem(Context context, RecyclerView recyclerView , MvpView mvpView) {
        super(context);
        this.recyclerView = recyclerView;
        this.mvpView = mvpView;
        apiServiceIml = new APIServiceIml();

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewMargin margin = new RecyclerViewMargin(30,1);
        recyclerView.addItemDecoration(margin);

        storeList = new ArrayList<>();
        adapter = new AdapterStoreDetail(context, storeList);
        recyclerView.setAdapter(adapter);
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
