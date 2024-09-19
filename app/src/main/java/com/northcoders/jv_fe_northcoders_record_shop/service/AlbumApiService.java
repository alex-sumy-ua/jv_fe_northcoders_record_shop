package com.northcoders.jv_fe_northcoders_record_shop.service;

import com.northcoders.jv_fe_northcoders_record_shop.model.Album;
import com.northcoders.jv_fe_northcoders_record_shop.model.Artist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @GET("albums/artists")
    Call<List<Artist>> getAllArtists();

    @POST("album")
    Call<Album> addAlbum(@Body Album aLbum);

}
