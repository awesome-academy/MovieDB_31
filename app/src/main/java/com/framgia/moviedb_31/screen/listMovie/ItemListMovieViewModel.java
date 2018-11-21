package com.framgia.moviedb_31.screen.listMovie;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import com.framgia.moviedb_31.data.model.Movie;

public class ItemListMovieViewModel extends BaseObservable {

    private ObservableField<Movie> mMovie = new ObservableField<>();

    void setItemListMovieBinding(Movie movie) {
        mMovie.set(movie);
    }
}
