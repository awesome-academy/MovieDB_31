package com.framgia.moviedb_31.screen.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.data.model.Movie;
import com.framgia.moviedb_31.databinding.ActivityHomeScreenAdapterBinding;
import java.util.ArrayList;
import java.util.List;

public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.ViewHolder> {

    private List<Movie> mMovieList;
    private OnItemRecyclerViewClick mListener;

    public HomeScreenAdapter(OnItemRecyclerViewClick listener) {
        mMovieList = new ArrayList<>();
        mListener = listener;
    }

    public void setMovieList(List<Movie> movieList) {
        mMovieList.addAll(movieList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityHomeScreenAdapterBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.activity_home_screen_adapter, viewGroup, false);
        return new ViewHolder(binding, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.BindData(mMovieList.get(i));
    }

    @Override
    public int getItemCount() {
        return mMovieList != null ? mMovieList.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemHomeScreenViewModel mItemHomeScreenViewModel;
        private ActivityHomeScreenAdapterBinding mBinding;

        ViewHolder(@NonNull ActivityHomeScreenAdapterBinding itemView,
                OnItemRecyclerViewClick listener) {
            super(itemView.getRoot());
            mBinding = itemView;
            mItemHomeScreenViewModel = new ItemHomeScreenViewModel(listener);
            mBinding.setViewModel(mItemHomeScreenViewModel);
            mItemHomeScreenViewModel.onItemClicked(itemView.getRoot());
        }

        void BindData(Movie movie) {
            mItemHomeScreenViewModel.setMovie(movie);
            mBinding.executePendingBindings();
        }
    }

    interface OnItemRecyclerViewClick {
        void onClick(int movieId);
    }
}
