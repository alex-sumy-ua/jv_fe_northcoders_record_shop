package com.northcoders.jv_fe_northcoders_record_shop.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.jv_fe_northcoders_record_shop.service.AlbumApiService;
import com.northcoders.jv_fe_northcoders_record_shop.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private final MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private final AlbumApiService apiService;

    public AlbumRepository(Application application) {
        // Initialize the API service
        apiService = RetrofitInstance.getService();
        // Fetch data initially
        fetchAlbums();
    }

    public LiveData<List<Album>> getAllAlbums() {
        return mutableLiveData;
    }

    private void fetchAlbums() {
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
    }
}