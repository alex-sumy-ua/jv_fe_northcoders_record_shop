package com.northcoders.jv_fe_northcoders_record_shop.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

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
    private final Application application;

    public AlbumRepository(Application application) {
        // Initialize the API service
        apiService = RetrofitInstance.getService();
        // Fetch data initially
        fetchAlbums();
        this.application = application;
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

    public void addAlbum (Album album) {

        Call<Album> call = apiService.addAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(application.getApplicationContext(), "Album added successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(application.getApplicationContext(), "Failed to add album. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}