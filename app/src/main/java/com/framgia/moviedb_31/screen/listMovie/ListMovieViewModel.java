package com.framgia.moviedb_31.screen.listMovie;

import android.databinding.ObservableField;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.data.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class ListMovieViewModel {

    public ObservableField<ListMovieAdapter> mAdapterObservableField = new ObservableField<>();
    private ListMovieAdapter mListMovieAdapter;

    public ListMovieViewModel() {
        mListMovieAdapter = new ListMovieAdapter();
        setData();
    }

    private void setData() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie();
            movie.setNameMovie("");
            movie.setDate("");
            movie.setRating("");
            movie.setPoster(String.valueOf(R.drawable.poster2));
            movie.setContent("");
            movies.add(movie);
        }
        mListMovieAdapter.updateAdapter(movies);
        mAdapterObservableField.set(mListMovieAdapter);
    }
}
