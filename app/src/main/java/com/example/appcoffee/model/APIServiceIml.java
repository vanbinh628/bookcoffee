package com.example.appcoffee.model;

import android.provider.ContactsContract;
import android.util.Log;

import com.example.appcoffee.network.GetDataService;
import com.example.appcoffee.network.RetrofitClientInstance;
import com.example.appcoffee.presenter.FetchDataCallback;
import com.example.appcoffee.presenter.FetchDataListStore;
import com.example.appcoffee.presenter.FetchDataUserCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIServiceIml {//lớp model lấy dữ liệu từ sever
    String TAG = APIServiceIml.class.getSimpleName();
    GetDataService apiService;

    public void getProductsCoffee(final FetchDataCallback dataCallback) {//khai báo lớp interface để giao tiếp với lớp trung gian
        apiService = RetrofitClientInstance.getRetrofitClientInstance().create(GetDataService.class);
        Call<ProductList> getProduct = apiService.getProductsCoffee();
        getProduct.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {//nhận dữ liệu serve thanh công
                try {
                    dataCallback.OnFetchSuccess(response.body().getProducts());//gọi hàm interface để đưa dữ liệu cho presenter
                } catch (Exception e) {
                    dataCallback.OnFetchFault(e);
                }

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.e(TAG, t.toString());
                dataCallback.OnFetchFault(new Exception(t));
            }
        });
    }

    public void getProductsBreakfast(final FetchDataCallback dataCallback) {//khai báo lớp interface để giao tiếp với lớp trung gian
        apiService = RetrofitClientInstance.getRetrofitClientInstance().create(GetDataService.class);
        Call<ProductList> getProduct = apiService.getProductsBreakfast();
        getProduct.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {//nhận dữ liệu serve thanh công
                try {
                    dataCallback.OnFetchSuccess(response.body().getProducts());//gọi hàm interface để đưa dữ liệu cho presenter
                    Log.d("InRa", response.body().getProducts().get(0).getAddOn().get(0).getConfigs().get(1).getName().toString());
                } catch (Exception e) {
                    dataCallback.OnFetchFault(e);
                }

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.e(TAG, t.toString());
                dataCallback.OnFetchFault(new Exception(t));
            }
        });
    }

    public void getProductsDessert(final FetchDataCallback dataCallback) {//khai báo lớp interface để giao tiếp với lớp trung gian
        apiService = RetrofitClientInstance.getRetrofitClientInstance().create(GetDataService.class);
        Call<ProductList> getProduct = apiService.getProductsDessert();
        getProduct.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {//nhận dữ liệu serve thanh công
                try {
                    dataCallback.OnFetchSuccess(response.body().getProducts());//gọi hàm interface để đưa dữ liệu cho presenter
                } catch (Exception e) {
                    dataCallback.OnFetchFault(e);
                }

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.e(TAG, t.toString());
                dataCallback.OnFetchFault(new Exception(t));
            }
        });
    }

    public void getProfileUser(final FetchDataUserCallback dataCallback){
        apiService = RetrofitClientInstance.getRetrofitClientInstance().create(GetDataService.class);
        Call<ClientResponse> getData = apiService.getProfileUser();
        getData.enqueue(new Callback<ClientResponse>() {
            @Override
            public void onResponse(Call<ClientResponse> call, Response<ClientResponse> response) {
                dataCallback.OnFetchSuccess(response.body().getUser());
            }

            @Override
            public void onFailure(Call<ClientResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                dataCallback.OnFetchFault(new Exception(t));
            }
        });

    }
    public void getAllStore(final FetchDataListStore fetchDataListStore){
        apiService = RetrofitClientInstance.getRetrofitClientInstance().create(GetDataService.class);
        Call<StoreList> getData = apiService.getAllStore();
        getData.enqueue(new Callback<StoreList>() {
            @Override
            public void onResponse(Call<StoreList> call, Response<StoreList> response) {
                fetchDataListStore.OnFetchSuccess(response.body().getStoreList());
            }

            @Override
            public void onFailure(Call<StoreList> call, Throwable t) {
                Log.e(TAG, t.toString());
                fetchDataListStore.OnFetchFailure(new Exception(t));
            }
        });
    }

}
