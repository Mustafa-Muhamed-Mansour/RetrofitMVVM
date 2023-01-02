package com.retro.network.remote;

import com.retro.response.BannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("banners")
    Call<BannerResponse> getPosts();
}
