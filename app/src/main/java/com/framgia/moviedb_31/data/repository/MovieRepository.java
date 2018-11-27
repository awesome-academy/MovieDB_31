package com.framgia.moviedb_31.data.repository;

import com.framgia.moviedb_31.data.model.BaseModel;
import com.framgia.moviedb_31.data.source.remote.RemoteDataSource;
import io.reactivex.Flowable;

public class MovieRepository {
    private static MovieRepository sInstance;
    private RemoteDataSource mRemoteDataSource;

    private MovieRepository(RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static MovieRepository getInstance(RemoteDataSource remoteDataSource) {
        if (sInstance == null) {
            sInstance = new MovieRepository(remoteDataSource);
        }
        return sInstance;
    }

    public Flowable<BaseModel> getMovieByCategory(String category, int page) {
        return mRemoteDataSource.getMovieByCategory(category, page);
    }

    public Flowable<BaseModel> getListGenres() {
        return mRemoteDataSource.getListGenres();
    }
}
