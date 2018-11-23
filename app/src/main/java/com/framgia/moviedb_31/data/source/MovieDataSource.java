package com.framgia.moviedb_31.data.source;

import com.framgia.moviedb_31.data.model.BaseModel;
import io.reactivex.Flowable;

public interface MovieDataSource {
    interface Remote {
        Flowable<BaseModel> getMovieByCategory(String category, int page);
    }
}
