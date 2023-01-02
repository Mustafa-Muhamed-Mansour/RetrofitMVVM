package com.retro.response;

import com.google.gson.annotations.SerializedName;
import com.retro.model.BannerModel;

import java.util.List;

public class BannerResponse {


    @SerializedName("data")
    private List<BannerModel> bannerModels;


    public BannerResponse() {
    }

    public BannerResponse(List<BannerModel> bannerModels) {
        this.bannerModels = bannerModels;
    }

    public List<BannerModel> getProductModels() {
        return bannerModels;
    }
}
