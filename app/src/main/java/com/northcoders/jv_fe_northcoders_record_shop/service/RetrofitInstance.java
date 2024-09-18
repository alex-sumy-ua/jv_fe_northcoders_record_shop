package com.northcoders.jv_fe_northcoders_record_shop.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://NorthcodersRecordShop-env.eba-ncyb4yiy.eu-west-2.elasticbeanstalk.com/api/v1/albums/";

    public static AlbumApiService getService() {


        // Create HttpLoggingInterceptor
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Create OkHttpClient and add interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // Create Retrofit instance if it's null
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())  // Add GsonConverterFactory
                    .build();
        }

        // Return ApiService instance
        return retrofit.create(AlbumApiService.class);

    }


}
