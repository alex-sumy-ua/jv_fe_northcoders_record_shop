package com.northcoders.jv_fe_northcoders_record_shop.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.jv_fe_northcoders_record_shop.service.AlbumApiService;
import com.northcoders.jv_fe_northcoders_record_shop.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

//    private ArrayList<Artist> artists = new ArrayList<>();
    private ArrayList<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData  = new MutableLiveData<>();
    private Application application;


    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        // Get ApiService instance
        AlbumApiService apiService = RetrofitInstance.getService();
        // Make the API call to get all albums
        Call<List<Album>> call = apiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Set the fetched albums list into the MutableLiveData object
                    mutableLiveData.setValue(response.body());
                } else {
                    Log.e("API Error", "Failed to retrieve albums: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                // Log the error message in case of failure
                Log.e("HTTP Failure", t.getMessage());
            }
        });

        return mutableLiveData;
    }

}
