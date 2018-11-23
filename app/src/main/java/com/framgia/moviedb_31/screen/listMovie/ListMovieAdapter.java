package com.framgia.moviedb_31.screen.listMovie;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.data.model.Movie;
import com.framgia.moviedb_31.databinding.ItemListMovieBinding;
import java.util.ArrayList;
import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {

    private List<Movie> mMovieList;

    public ListMovieAdapter() {
        mMovieList = new ArrayList<>();
    }

    public void updateAdapter(List<Movie> movies) {
        if (mMovieList != null) {
            mMovieList.clear();
        }
        mMovieList.addAll(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemListMovieBinding itemListMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_list_movie, viewGroup, false);
        return new ViewHolder(itemListMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mMovieList.get(i));
    }

    @Override
    public int getItemCount() {
        return mMovieList != null ? mMovieList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemListMovieBinding mItemListMovieBinding;
        private ItemListMovieViewModel mItemListMovieViewModel;

        ViewHolder(@NonNull ItemListMovieBinding itemListMovieBinding) {
            super(itemListMovieBinding.getRoot());
            mItemListMovieBinding = itemListMovieBinding;
            mItemListMovieViewModel = new ItemListMovieViewModel();
            mItemListMovieBinding.setItemListViewModel(mItemListMovieViewModel);
        }

        void bind(Movie movie) {
            mItemListMovieViewModel.setItemListMovieBinding(movie);
            mItemListMovieBinding.executePendingBindings();
        }
    }
}
