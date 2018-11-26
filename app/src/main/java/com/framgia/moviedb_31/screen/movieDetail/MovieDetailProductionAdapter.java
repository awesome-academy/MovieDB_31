package com.framgia.moviedb_31.screen.movieDetail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.data.model.Production;
import com.framgia.moviedb_31.databinding.ActivityMovieDetailProductionAdapterBinding;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailProductionAdapter
        extends RecyclerView.Adapter<MovieDetailProductionAdapter.ViewHolder> {

    private List<Production> mProductionList;

    public MovieDetailProductionAdapter() {
        mProductionList = new ArrayList<>();
    }

    public void updateAdapter(List<Production> productionList) {
        mProductionList.addAll(productionList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityMovieDetailProductionAdapterBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.activity_movie_detail_production_adapter, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mProductionList.get(i));
    }

    @Override
    public int getItemCount() {
        return mProductionList != null ? mProductionList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ActivityMovieDetailProductionAdapterBinding mActivityMovieDetailAdapterBinding;
        private ItemMovieDetailViewModel mItemMovieDetailViewModel;

        ViewHolder(@NonNull ActivityMovieDetailProductionAdapterBinding binding) {
            super(binding.getRoot());
            mActivityMovieDetailAdapterBinding = binding;
            mItemMovieDetailViewModel = new ItemMovieDetailViewModel();
            mActivityMovieDetailAdapterBinding.setViewModel(mItemMovieDetailViewModel);
        }

        void bind(Production production) {
            mItemMovieDetailViewModel.setActivityMovieDetailBinding(production);
            mActivityMovieDetailAdapterBinding.executePendingBindings();
        }
    }
}
