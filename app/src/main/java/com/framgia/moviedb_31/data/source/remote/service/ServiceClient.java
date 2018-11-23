package com.framgia.moviedb_31.data.source.remote.service;

import com.framgia.moviedb_31.utils.Constant;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceClient {
    public static ServiceAPI createServiceClient() {
        Retrofit build = new Retrofit.Builder().baseUrl(Constant.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return build.create(ServiceAPI.class);
    }
}
