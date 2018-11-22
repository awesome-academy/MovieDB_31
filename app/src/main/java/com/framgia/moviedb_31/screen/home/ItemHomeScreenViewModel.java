package com.framgia.moviedb_31.screen.home;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;
import com.framgia.moviedb_31.data.model.Movie;
import com.framgia.moviedb_31.utils.ItemClickListener;

public class ItemHomeScreenViewModel extends BaseObservable implements View.OnClickListener {

    private ObservableField<Movie> mMovieObservableField = new ObservableField<>();
    private ItemClickListener mListener;
    private Movie mMovie;

    ItemHomeScreenViewModel(ItemClickListener listener) {
        mListener = listener;
    }

    void setMovie(Movie movie) {
        mMovie = movie;
        mMovieObservableField.set(mMovie);
    }

    void onItemClicked(View v) {
        v.setOnClickListener(this);
    }

    public Movie getMovie() {
        return mMovieObservableField.get();
    }

    @Override
    public void onClick(View v) {
        mListener.onItemClicked(mMovie.getID());
    }
}
