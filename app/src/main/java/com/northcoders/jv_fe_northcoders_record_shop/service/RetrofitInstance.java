package com.northcoders.jv_fe_northcoders_record_shop.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://northcodersrecordshop-env.eba-ncyb4yiy.eu-west-2.elasticbeanstalk.com/api/v1/";

    public static AlbumApiService getService() {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(AlbumApiService.class);

    }


}
