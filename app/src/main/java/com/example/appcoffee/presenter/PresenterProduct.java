package com.example.appcoffee.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.adapter.AdapterProductDetail;
import com.example.appcoffee.base.BasePresenter;
import com.example.appcoffee.model.APIServiceIml;
import com.example.appcoffee.model.AddOn;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.other.RecyclerViewMargin;
import com.example.appcoffee.view.MvpView;

import java.util.ArrayList;
import java.util.List;

public class PresenterProduct extends BasePresenter {
    private MvpView mvpView;
    private AdapterProductDetail productAdapter;
    private List<Product> productsList;
    APIServiceIml apiServiceIml;//khai báo lớp API để thằng này chứa dữ liệu đưa lên view

    public AdapterProductDetail getProductAdapter() {
        return productAdapter;
    }

    public void setProductAdapter(AdapterProductDetail productAdapter) {
        this.productAdapter = productAdapter;
    }

    public PresenterProduct(Context context, MvpView mvpView) {
        super(context);
        apiServiceIml = new APIServiceIml();

        this.mvpView = mvpView;
        productsList = new ArrayList<>();
        productAdapter = new AdapterProductDetail(context,productsList);
    }
    public void deleteData(){
        productsList.clear();
        productAdapter.notifyDataSetChanged();
    }

    /**
     * parse data
     * Noti adapter
     * */
    public void fetchDataProductsCoffee() {
        mvpView.showLoading();
        //Call method getAllProduct in API
        apiServiceIml.getProductsCoffee(new FetchDataCallback() {//nhận dư liệu từ model
            @Override
            public void OnFetchSuccess(List<Product> list) {
                Log.d("Hehe", list.toString());

                Log.d("InRaMultiple",list.get(0).getAddOn().get(3).getName().toString());
                Log.d("InRaMultiple",list.get(0).getAddOn().get(3).getMultiple().toString());
                productsList.addAll(list);
                productAdapter.notifyDataSetChanged();

                mvpView.hideLoading();
            }

            @Override
            public void OnFetchFault(Exception e) {
                Log.d("Error",e.toString());
                Toast.makeText(context, R.string.errorNetwork,Toast.LENGTH_LONG).show();
                mvpView.hideLoading();
            }
        });
    }

    public void fetchDataProductsBreakfast() {
        mvpView.showLoading();
        //Call method getAllProduct in API
        apiServiceIml.getProductsBreakfast(new FetchDataCallback() {//nhận dư liệu từ model
            @Override
            public void OnFetchSuccess(List<Product> list) {
                Log.d("Hehe", list.toString());

                productsList.addAll(list);
                productAdapter.notifyDataSetChanged();
                mvpView.hideLoading();
            }

            @Override
            public void OnFetchFault(Exception e) {
                Log.d("Error",e.toString());
                Toast.makeText(context, R.string.errorNetwork,Toast.LENGTH_LONG).show();
                mvpView.hideLoading();
            }
        });
    }

    public void fetchDataProductsDessert() {
        mvpView.showLoading();
        //Call method getAllProduct in API
        apiServiceIml.getProductsDessert(new FetchDataCallback() {//nhận dư liệu từ model
            @Override
            public void OnFetchSuccess(List<Product> list) {
                Log.d("Hehe", list.toString());

                productsList.addAll(list);
                productAdapter.notifyDataSetChanged();
                mvpView.hideLoading();
            }

            @Override
            public void OnFetchFault(Exception e) {
                Log.d("Error",e.toString());
                Toast.makeText(context, R.string.errorNetwork,Toast.LENGTH_LONG).show();
                mvpView.hideLoading();
            }
        });
    }



}