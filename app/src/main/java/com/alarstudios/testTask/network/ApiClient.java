package com.alarstudios.testTask.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String API = "http://www.alarstudios.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logger);

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(API).addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build();

        return retrofit;
    }
}
