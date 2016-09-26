package com.app.hack.toppr.services;

import com.app.hack.toppr.ultis.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ajay Kumar on 9/24/2016.
 */


public class ApiClient {

    //initialising retrofit with null
    public static Retrofit mRetrofit = null;

    public static Retrofit getRetrofitInstance(){

        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}