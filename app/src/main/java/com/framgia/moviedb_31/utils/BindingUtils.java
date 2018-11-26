package com.framgia.moviedb_31.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.screen.home.HomeScreenAdapter;

public class BindingUtils {
    @BindingAdapter({ "imageUrl" })
    public static void loadImageUrl(ImageView view, String imageUrl) {
        String fullImageUrl = Constant.BASE_IMAGE_URL + imageUrl;
        Glide.with(view.getContext())
                .load(fullImageUrl)
                .into(view);
    }

    @BindingAdapter({ "Adapter" })
    public static void setAdapter(RecyclerView view, HomeScreenAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("setAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("setImagePoster")
    public static void setImagePoster(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(Constant.BASE_IMAGE_URL + url)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(view);
    }
}
