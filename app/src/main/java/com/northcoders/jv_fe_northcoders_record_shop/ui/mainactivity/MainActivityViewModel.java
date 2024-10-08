package com.northcoders.jv_fe_northcoders_record_shop.ui.mainactivity;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.northcoders.jv_fe_northcoders_record_shop.model.Album;
import com.northcoders.jv_fe_northcoders_record_shop.model.AlbumRepository;
import java.util.List;


//import androidx.lifecycle.MutableLiveData;
//import com.northcoders.jv_fe_northcoders_record_shop.service.AlbumApiService;
//import com.northcoders.jv_fe_northcoders_record_shop.service.RetrofitInstance;

public class MainActivityViewModel extends AndroidViewModel {

    private final AlbumRepository albumRepository;
    private final LiveData<List<Album>> allAlbums;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
        this.allAlbums = albumRepository.getAllAlbums(); // Initialize LiveData from the repository
    }

    public LiveData<List<Album>> getAllAlbums() {
        return allAlbums;
    }

//    public LiveData<String> getToastMessage() {
//        return toastMessage;
//    }

    public void addAlbum(Album album) {
        albumRepository.addAlbum(album);
    }

}