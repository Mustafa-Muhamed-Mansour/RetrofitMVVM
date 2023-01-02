package com.retro.repository;


import com.retro.network.remote.ApiPost;
import com.retro.network.remote.ApiService;
import com.retro.response.BannerResponse;
import retrofit2.Call;


public class BannerRepository {

    private ApiService apiService;


    public BannerRepository() {
        apiService = new ApiPost().getRetrofit().create(ApiService.class);
    }


    public Call<BannerResponse> getPosts() {
        return apiService.getPosts();
    }
}
