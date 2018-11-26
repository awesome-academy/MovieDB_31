package com.framgia.moviedb_31.screen.listMovie;

import android.databinding.ObservableField;
import com.framgia.moviedb_31.data.model.BaseModel;
import com.framgia.moviedb_31.data.source.remote.RemoteDataSource;
import com.framgia.moviedb_31.data.source.repository.MovieRepository;
import com.framgia.moviedb_31.utils.ItemClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ListMovieViewModel implements ItemClickListener {

    public ObservableField<ListMovieAdapter> mAdapterObservableField = new ObservableField<>();
    private ListMovieAdapter mListMovieAdapter;
    private CompositeDisposable mCompositeDisposable;
    private MovieRepository mMovieRepository;

    public ListMovieViewModel(String category) {
        mListMovieAdapter = new ListMovieAdapter();
        mCompositeDisposable = new CompositeDisposable();
        mMovieRepository = MovieRepository.getInstance(RemoteDataSource.getsInstance());
        initData(category);
        mListMovieAdapter.setItemClickListener(this);
    }

    private void initData(String category) {
        int page = 1;
        Disposable disposable = mMovieRepository.getMovieByCategory(category, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseModel>() {
                    @Override
                    public void accept(BaseModel baseModel) throws Exception {
                        mAdapterObservableField.set(mListMovieAdapter);
                        mListMovieAdapter.updateAdapter(baseModel.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);
        mAdapterObservableField.set(mListMovieAdapter);
    }

    @Override
    public void onItemClicked(String id) {
        if (id == null) {
            return;
        }
    }
}
