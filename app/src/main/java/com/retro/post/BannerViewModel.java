package com.retro.post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.retro.repository.BannerRepository;
import com.retro.response.BannerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BannerViewModel extends ViewModel {

    private BannerRepository bannerRepository;
    private MutableLiveData<BannerResponse> postMutableLiveData;
    private MutableLiveData<String> stringMutableLiveData;


    public BannerViewModel() {
        bannerRepository = new BannerRepository();
        postMutableLiveData = new MutableLiveData<>();
        stringMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<BannerResponse> getBannersFromRetrofit() {

        Call<BannerResponse> response = bannerRepository.getPosts();

        response.enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.postValue(response.body());
                } else {
                    stringMutableLiveData.setValue(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {
                stringMutableLiveData.setValue(t.getMessage());
            }
        });

        return postMutableLiveData;
    }
}
