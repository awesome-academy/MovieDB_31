package com.framgia.moviedb_31.screen.listMovie;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;
import com.framgia.moviedb_31.data.model.Movie;
import com.framgia.moviedb_31.utils.ItemClickListener;

public class ItemListMovieViewModel extends BaseObservable {

    private ObservableField<Movie> mMovie = new ObservableField<>();
    private ItemClickListener mItemClickListener;

    public ItemListMovieViewModel(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    void setItemListMovieBinding(Movie movie) {
        mMovie.set(movie);
    }

    public Movie getMovie() {
        return mMovie.get();
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null || mMovie.get() == null) {
            return;
        }
        mItemClickListener.onItemClicked(mMovie.get().getID());
    }
}
