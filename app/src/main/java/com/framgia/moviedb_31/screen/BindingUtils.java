package com.framgia.moviedb_31.screen;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.framgia.moviedb_31.R;

public class BindingUtils {

    @BindingAdapter("setAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("setImagePoster")
    public static void setImagePoster(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(Integer.parseInt(url))
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(view);
    }
}
