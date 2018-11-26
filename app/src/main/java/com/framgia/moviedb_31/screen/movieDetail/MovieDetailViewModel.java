package com.framgia.moviedb_31.screen.movieDetail;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import com.framgia.moviedb_31.data.model.Actor;
import com.framgia.moviedb_31.data.model.Movie;
import com.framgia.moviedb_31.data.model.Production;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailViewModel extends BaseObservable {
    public ObservableField<Movie> mMovie;
    public ObservableField<MovieDetailProductionAdapter> mAdapterObservableField;
    public ObservableField<MovieDetailActorAdapter> mActorAdapterObservableField;
    private MovieDetailProductionAdapter mMovieDetailProductionAdapter;
    private MovieDetailActorAdapter mMovieDetailActorAdapter;

    MovieDetailViewModel() {
        mMovie = new ObservableField<>();
        mAdapterObservableField = new ObservableField<>();
        mMovieDetailProductionAdapter = new MovieDetailProductionAdapter();
        mActorAdapterObservableField = new ObservableField<>();
        mMovieDetailActorAdapter = new MovieDetailActorAdapter();
        initData();
        setDataItemProduction();
        setDataItemActor();
    }

    private void initData() {
        Movie movie = new Movie();
        mMovie.set(movie);
    }

    private void setDataItemProduction() {
        List<Production> productionList = new ArrayList<>();
        mMovieDetailProductionAdapter.updateAdapter(productionList);
        mAdapterObservableField.set(mMovieDetailProductionAdapter);
    }

    private void setDataItemActor() {
        List<Actor> actorList = new ArrayList<>();
        mMovieDetailActorAdapter.updateAdapter(actorList);
        mActorAdapterObservableField.set(mMovieDetailActorAdapter);
    }

    public Movie getMovie() {
        return mMovie.get();
    }
}
