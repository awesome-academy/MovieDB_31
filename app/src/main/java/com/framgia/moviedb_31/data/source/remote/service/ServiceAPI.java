package com.framgia.moviedb_31.data.source.remote.service;

import com.framgia.moviedb_31.BuildConfig;
import com.framgia.moviedb_31.data.model.BaseModel;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceAPI {
    @GET("movie/{category}?api_key=" + BuildConfig.API_KEY)
    Flowable<BaseModel> getListMovieByCategory(@Path("category") String category, @Query("page") int page);
}
