package com.framgia.moviedb_31.screen.home;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;
import com.framgia.moviedb_31.data.model.Movie;

public class ItemHomeScreenViewModel extends BaseObservable implements View.OnClickListener {

    private ObservableField<Movie> mMovieObservableField = new ObservableField<>();
    private HomeScreenAdapter.OnItemRecyclerViewClick mlistener;

    ItemHomeScreenViewModel(HomeScreenAdapter.OnItemRecyclerViewClick listener) {
        mlistener = listener;
    }

    void setMovie(Movie movie) {
        mMovieObservableField.set(movie);
    }

    void onItemClicked(View v) {
        v.setOnClickListener(this);
    }

    public Movie getMovie() {
        return mMovieObservableField.get();
    }

    @Override
    public void onClick(View v) {
        mlistener.onClick(0);
    }
}
