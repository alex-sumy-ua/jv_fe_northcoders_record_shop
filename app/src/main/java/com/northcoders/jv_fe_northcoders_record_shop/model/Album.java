package com.northcoders.jv_fe_northcoders_record_shop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("released")
    private int released;
    @SerializedName("artist")
    private Artist artist;
    @SerializedName("genre")
    private Genre genre;
    @SerializedName("price")
    private float price;
    @SerializedName("inStock")
    private int inStock;

    public Album() {
    }

    public Album(String title, String description, int released, Artist artist, Genre genre, float price, int inStock) {
        this.title = title;
        this.description = description;
        this.released = released;
        this.artist = artist;
        this.genre = genre;
        this.price = price;
        this.inStock = inStock;
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
//        notifyPropertyChanged(BR.id); // notify data binding of the change
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
//        notifyPropertyChanged(BR.title); // notify data binding of the change
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
//        notifyPropertyChanged(BR.description); // notify data binding of the change
    }

    @Bindable
    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
//        notifyPropertyChanged(BR.released); // notify data binding of the change
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
//        notifyPropertyChanged(BR.artist); // notify data binding of the change
    }

    @Bindable
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
//        notifyPropertyChanged(BR.genre); // notify data binding of the change
    }

    @Bindable
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
//        notifyPropertyChanged(BR.price); // notify data binding of the change
    }

    @Bindable
    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
//        notifyPropertyChanged(BR.inStock); // notify data binding of the change
    }

}

