package com.framgia.moviedb_31.screen.home;

import android.databinding.ObservableField;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel implements HomeScreenAdapter.OnItemRecyclerViewClick {
    public ObservableField<HomeScreenAdapter> mFieldTopRating;
    public ObservableField<HomeScreenAdapter> mFieldPopular;
    public ObservableField<HomeScreenAdapter> mFieldUpComing;
    public ObservableField<HomeScreenAdapter> mFieldNowPlaying;

    public MainViewModel() {
        mFieldTopRating = new ObservableField<>();
        mFieldPopular = new ObservableField<>();
        mFieldUpComing = new ObservableField<>();
        mFieldNowPlaying = new ObservableField<>();
    }

    @Override
    public void onClick(int movieId) {

    }

    public List<String> getImagePoster() {
        List<String> imageList = new ArrayList();
        return imageList;
    }
}
