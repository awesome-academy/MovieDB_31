package com.framgia.moviedb_31.screen.listMovie;

import android.content.Context;
import android.databinding.ObservableField;
import android.widget.Toast;
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

public class ListMovieViewModel implements ItemClickListener {

    public ObservableField<ListMovieAdapter> mAdapterObservableField;
    private ListMovieAdapter mListMovieAdapter;
    private CompositeDisposable mCompositeDisposable;
    private MovieRepository mMovieRepository;
    private Context mContext;

    public ListMovieViewModel(Context context, String key, String value) {
        mContext = context;
        mAdapterObservableField = new ObservableField<>();
        mListMovieAdapter = new ListMovieAdapter();
        mCompositeDisposable = new CompositeDisposable();
        mMovieRepository = MovieRepository.getInstance(RemoteDataSource.getsInstance());
        mListMovieAdapter.setItemClickListener(this);
        setQueryData(key, value);
    }

    private void setQueryData(String key, String value) {
        switch (key) {
            case Constant.TYPE_SEARCH:
                getMovieBySearch(value);
                break;
            case Constant.TYPE_CATEGORY:
                getListMovieByCategory(value);
                break;
        }
    }

    private void getListMovieByCategory(String category) {
        Disposable disposable = mMovieRepository.getMovieByCategory(category, Constant.PAGE_DEFAULT)
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
                        Toast.makeText(mContext, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void getMovieBySearch(String query) {
        Disposable disposable = mMovieRepository.getMovieBySearch(query, Constant.PAGE_DEFAULT)
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
                        Toast.makeText(mContext, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onItemClicked(String id) {
        if (id == null) {
            return;
        }
    }
}
