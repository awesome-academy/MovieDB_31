package com.framgia.moviedb_31.screen.movieDetail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;
import com.framgia.moviedb_31.BR;
import com.framgia.moviedb_31.data.model.BaseCredit;
import com.framgia.moviedb_31.data.model.BaseVideos;
import com.framgia.moviedb_31.data.model.Movie;
import com.framgia.moviedb_31.data.model.Videos;
import com.framgia.moviedb_31.data.repository.MovieRepository;
import com.framgia.moviedb_31.data.source.remote.RemoteDataSource;
import com.framgia.moviedb_31.screen.playMovie.PlayMovieActivity;
import com.framgia.moviedb_31.utils.Constant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailViewModel extends BaseObservable {
    private ObservableField<Movie> mMovie;
    private MovieDetailProductionAdapter mMovieDetailProductionAdapter;
    private MovieDetailActorAdapter mMovieDetailActorAdapter;
    private MovieRepository mMovieRepository;
    private CompositeDisposable mCompositeDisposable;
    private List<Videos> mVideosList;
    private Context mContext;

    void onStop() {
        mCompositeDisposable.clear();
    }

    public MovieDetailProductionAdapter getMovieDetailProductionAdapter() {
        return mMovieDetailProductionAdapter;
    }

    public MovieDetailActorAdapter getMovieDetailActorAdapter() {
        return mMovieDetailActorAdapter;
    }

    MovieDetailViewModel(Context context, String id) {
        mMovie = new ObservableField<>();
        mMovieDetailProductionAdapter = new MovieDetailProductionAdapter();
        mMovieDetailActorAdapter = new MovieDetailActorAdapter();
        mMovieRepository = MovieRepository.getInstance(RemoteDataSource.getsInstance());
        mCompositeDisposable = new CompositeDisposable();
        mVideosList = new ArrayList<>();
        mContext = context;
        getDataMovieContent(id);
        getDataItemMovie(id);
        getDataMovieContent(id);
        getVideoMovie(id);
    }

    private void getDataMovieContent(String id) {
        Disposable disposable = mMovieRepository.getMovieDetail(id, Constant.TYPE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Movie>() {
                    @Override
                    public void accept(Movie movie) {
                        setMovie(movie);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void getDataItemMovie(String id) {
        Disposable disposable = mMovieRepository.getMovieCredit(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseCredit>() {
                    @Override
                    public void accept(BaseCredit baseCredit) {
                        setDataAdapter(baseCredit);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void setDataAdapter(BaseCredit baseCredit) {
        mMovieDetailActorAdapter.updateAdapter(baseCredit.getActorList());
        mMovieDetailProductionAdapter.updateAdapter(baseCredit.getProductionList());
    }

    private void getVideoMovie(String id) {
        Disposable disposable = mMovieRepository.getVideosMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseVideos>() {
                    @Override
                    public void accept(BaseVideos baseVideos) {
                        mVideosList.addAll(baseVideos.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Bindable
    public Movie getMovie() {
        return mMovie.get();
    }

    public void setMovie(Movie movie) {
        mMovie.set(movie);
        notifyPropertyChanged(BR.movie);
    }

    public void onItemClicked(View view) {
        mContext.startActivity(PlayMovieActivity.getIntent(mContext, mVideosList.get(Constant.VIDEOS_DEFAULT).getKey()));
    }
}
