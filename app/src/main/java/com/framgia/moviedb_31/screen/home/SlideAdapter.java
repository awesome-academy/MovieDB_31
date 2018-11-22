package com.framgia.moviedb_31.screen.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class SlideAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> mPosterUrl;

    SlideAdapter(Context context, List<String> posterUrl) {
        mContext = context;
        mPosterUrl = posterUrl;
    }

    @Override
    public int getCount() {
        return mPosterUrl != null ? mPosterUrl.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        Glide.with(mContext)
                .load(mPosterUrl.get(position))
                .apply(new RequestOptions().centerCrop())
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
