package com.retro.model;

import com.google.gson.annotations.SerializedName;

public class BannerModel {


    @SerializedName("image")
    private String image;

    public BannerModel() {
    }

    public BannerModel(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

}
