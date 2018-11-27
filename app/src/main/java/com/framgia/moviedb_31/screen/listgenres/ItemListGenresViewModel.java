package com.framgia.moviedb_31.screen.listgenres;

import android.databinding.ObservableField;
import android.view.View;
import com.framgia.moviedb_31.data.model.Genres;
import com.framgia.moviedb_31.utils.ItemClickListener;

public class ItemListGenresViewModel implements View.OnClickListener {
    private ObservableField<Genres> mGenresObservableField;
    private ItemClickListener mListener;
    private Genres mGenres;

    ItemListGenresViewModel(ItemClickListener listener) {
        mGenresObservableField = new ObservableField<>();
        mListener = listener;
    }

    void setItemListMovieBinding(Genres genres) {
        mGenres = genres;
        mGenresObservableField.set(genres);
    }

    public Genres getGenres() {
        return mGenresObservableField.get();
    }

    void onItemClicked(View v) {
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onItemClicked(mGenres.getGenresId());
        }
    }
}
