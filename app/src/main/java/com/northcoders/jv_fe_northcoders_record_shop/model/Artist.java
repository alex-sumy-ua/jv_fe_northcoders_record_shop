package com.northcoders.jv_fe_northcoders_record_shop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.google.gson.annotations.SerializedName;
import com.northcoders.jv_fe_northcoders_record_shop.BR;

public class Artist extends BaseObservable {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    // "drummer", "singer", "guitarist", "band", "orchestra", etc.
    private String role;

    public Artist() {
    }

    public Artist(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Artist(long id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id); // notify data binding of the change
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name); // notify data binding of the change
    }

    @Bindable
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        notifyPropertyChanged(BR.role); // notify data binding of the change
    }

}