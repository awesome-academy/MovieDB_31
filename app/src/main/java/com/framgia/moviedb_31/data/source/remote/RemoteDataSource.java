package com.framgia.moviedb_31.data.source.remote;

import com.framgia.moviedb_31.data.model.BaseModel;
import com.framgia.moviedb_31.data.source.MovieDataSource;
import com.framgia.moviedb_31.data.source.remote.service.ServiceAPI;
import com.framgia.moviedb_31.data.source.remote.service.ServiceClient;
import io.reactivex.Flowable;

public class RemoteDataSource implements MovieDataSource.Remote {

    private static RemoteDataSource sInstance;
    private ServiceAPI mServiceAPI;

    private RemoteDataSource(ServiceAPI serviceAPI) {
        mServiceAPI = serviceAPI;
    }

    public static RemoteDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new RemoteDataSource(ServiceClient.createServiceClient());
        }
        return sInstance;
    }

    @Override
    public Flowable<BaseModel> getMovieByCategory(String category, int page) {
        return mServiceAPI.getListMovieByCategory(category, page);
    }
}
