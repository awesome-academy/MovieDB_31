package com.framgia.moviedb_31.screen.home;

import android.databinding.ObservableField;
import com.framgia.moviedb_31.data.model.BaseModel;
import com.framgia.moviedb_31.data.repository.MovieRepository;
import com.framgia.moviedb_31.data.source.remote.RemoteDataSource;
import com.framgia.moviedb_31.utils.Constant;
import com.framgia.moviedb_31.utils.ItemClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel {
    public ObservableField<HomeScreenAdapter> mFieldTopRating;
    public ObservableField<HomeScreenAdapter> mFieldPopular;
    public ObservableField<HomeScreenAdapter> mFieldUpComing;
    public ObservableField<HomeScreenAdapter> mFieldNowPlaying;
    private CompositeDisposable mCompositeDisposable;
    private MovieRepository mMovieRepository;
    private ItemClickListener mListener;

    MainViewModel(ItemClickListener listener) {
        mListener = listener;
        mFieldTopRating = new ObservableField<>();
        mFieldPopular = new ObservableField<>();
        mFieldUpComing = new ObservableField<>();
        mFieldNowPlaying = new ObservableField<>();
        mCompositeDisposable = new CompositeDisposable();
        mMovieRepository = MovieRepository.getInstance(RemoteDataSource.getsInstance());
    }

    public void initData() {
        setDataToAdapter(Constant.UP_COMING, mFieldUpComing);
        setDataToAdapter(Constant.POPULAR, mFieldPopular);
        setDataToAdapter(Constant.NOW_PLAYING, mFieldNowPlaying);
        setDataToAdapter(Constant.TOP_RATED, mFieldTopRating);
    }

    private void setDataToAdapter(String category, final ObservableField<HomeScreenAdapter> field) {
        int page = 1;
        Disposable disposable = mMovieRepository.getMovieByCategory(category, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseModel>() {
                    @Override
                    public void accept(BaseModel baseModel) throws Exception {
                        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(mListener);
                        field.set(homeScreenAdapter);
                        homeScreenAdapter.setMovieList(baseModel.getResults());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public List<String> getImagePoster() {
        List<String> imageList = new ArrayList();
        return imageList;
    }
}
