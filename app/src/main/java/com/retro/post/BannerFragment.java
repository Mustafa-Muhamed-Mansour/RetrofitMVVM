package com.retro.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.retro.adapter.BannerAdapter;
import com.retro.databinding.FragmentBannerBinding;


public class BannerFragment extends Fragment {


    private FragmentBannerBinding binding;
    private BannerViewModel bannerViewModel;
    private BannerAdapter bannerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentBannerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewModel();
        retrieveViewModel();
    }

    private void initViewModel() {
        bannerViewModel = new ViewModelProvider(requireActivity()).get(BannerViewModel.class);
    }

    private void retrieveViewModel() {
        binding.loading.setVisibility(View.VISIBLE);
        bannerViewModel.getBannersFromRetrofit().observe(requireActivity(), postModels -> {
            binding.loading.setVisibility(View.GONE);
            bannerAdapter = new BannerAdapter(postModels.getProductModels());
            binding.rV.setAdapter(bannerAdapter);
            binding.rV.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
            binding.rV.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        });
    }
}