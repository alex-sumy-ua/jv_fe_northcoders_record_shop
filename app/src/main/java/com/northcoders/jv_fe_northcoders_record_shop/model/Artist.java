package com.northcoders.jv_fe_northcoders_record_shop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Artist extends BaseObservable {

    private Long id;

    private String name;

    // "drummer", "singer", "guitarist", "band", "orchestra", etc.
    private String role;

    public Artist() {
    }

    public Artist(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Artist(Long id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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