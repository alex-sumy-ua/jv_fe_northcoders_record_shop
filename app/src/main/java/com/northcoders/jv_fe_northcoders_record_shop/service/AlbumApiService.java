package com.northcoders.jv_fe_northcoders_record_shop.service;

import com.northcoders.jv_fe_northcoders_record_shop.model.Album;
import com.northcoders.jv_fe_northcoders_record_shop.model.Artist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {

    @GET("")
    Call<List<Album>> getAllAlbums();

    @GET("artists/")
    Call<List<Artist>> getAllArtists();

}
