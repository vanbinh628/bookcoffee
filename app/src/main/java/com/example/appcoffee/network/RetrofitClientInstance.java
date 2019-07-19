package com.example.appcoffee.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private  static Retrofit retrofit;
    public static  String BASE_URL = "http://13.229.65.56:5000";
    public static Retrofit getRetrofitClientInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
