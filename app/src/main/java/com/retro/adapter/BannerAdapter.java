package com.retro.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.retro.R;
import com.retro.databinding.ItemBannerBinding;
import com.retro.model.BannerModel;

import java.util.List;


public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {


    private List<BannerModel> bannerModels;

    public BannerAdapter(List<BannerModel> bannerModels) {
        this.bannerModels = bannerModels;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerViewHolder(ItemBannerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {

        BannerModel model = bannerModels.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.bind.imgItemProduct);
    }

    @Override
    public int getItemCount() {
        return bannerModels.size();
    }


    public static class BannerViewHolder extends RecyclerView.ViewHolder {

        private ItemBannerBinding bind;

        public BannerViewHolder(@NonNull ItemBannerBinding binding) {

            super(binding.getRoot());
            this.bind = binding;
        }
    }
}
