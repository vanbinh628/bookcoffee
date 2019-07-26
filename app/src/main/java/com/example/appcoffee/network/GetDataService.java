package com.example.appcoffee.network;

import android.content.SharedPreferences;

import com.example.appcoffee.model.ClientResponse;
import com.example.appcoffee.model.ProductList;
import com.example.appcoffee.model.StoreList;
import com.example.appcoffee.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetDataService {


    @Headers({
            "Authorization: JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImNhN2Y0OTU0LTk4ODgtNDgzMy05NTM1LTIzNmRkODJkYTE3ZCIsImlhdCI6MTU2MjcyNjI2Miwicm9sZSI6InVzZXIifQ.58Se-tZiarZAdVOfdKYJzMGMcPl_Q4LRFvoQygHrFHo",
            "Content-Type: application/json"
    })
    @GET("/products/coffee")
    Call<ProductList> getProductsCoffee();

    @Headers({
            "Authorization: JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImNhN2Y0OTU0LTk4ODgtNDgzMy05NTM1LTIzNmRkODJkYTE3ZCIsImlhdCI6MTU2MjcyNjI2Miwicm9sZSI6InVzZXIifQ.58Se-tZiarZAdVOfdKYJzMGMcPl_Q4LRFvoQygHrFHo",
            "Content-Type: application/json"
    })
    @GET("/products/breakfast")
    Call<ProductList> getProductsBreakfast();

    @Headers({
            "Authorization: JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImNhN2Y0OTU0LTk4ODgtNDgzMy05NTM1LTIzNmRkODJkYTE3ZCIsImlhdCI6MTU2MjcyNjI2Miwicm9sZSI6InVzZXIifQ.58Se-tZiarZAdVOfdKYJzMGMcPl_Q4LRFvoQygHrFHo",
            "Content-Type: application/json"
    })
    @GET("/products/dessert")
    Call<ProductList> getProductsDessert();

    @Headers({
            "Authorization: JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImNhN2Y0OTU0LTk4ODgtNDgzMy05NTM1LTIzNmRkODJkYTE3ZCIsImlhdCI6MTU2MjcyNjI2Miwicm9sZSI6InVzZXIifQ.58Se-tZiarZAdVOfdKYJzMGMcPl_Q4LRFvoQygHrFHo",
            "Content-Type: application/json"
    })
    @GET("/me")
    Call<ClientResponse> getProfileUser();

    @Headers({
            "Authorization: JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImNhN2Y0OTU0LTk4ODgtNDgzMy05NTM1LTIzNmRkODJkYTE3ZCIsImlhdCI6MTU2MjcyNjI2Miwicm9sZSI6InVzZXIifQ.58Se-tZiarZAdVOfdKYJzMGMcPl_Q4LRFvoQygHrFHo",
            "Content-Type: application/json"
    })
    @GET("/store/")
    Call<StoreList> getAllStore();
    // Nhậ dữ liệu của thằng serve gửi cái gì lên
}

