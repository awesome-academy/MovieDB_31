package com.framgia.moviedb_31.screen.movieDetail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.data.model.Actor;
import com.framgia.moviedb_31.databinding.ActivityMovieDetailActorAdapterBinding;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailActorAdapter
        extends RecyclerView.Adapter<MovieDetailActorAdapter.ViewHolder> {
    private List<Actor> mActorList;

    public MovieDetailActorAdapter() {
        mActorList = new ArrayList<>();
    }

    public void updateAdapter(List<Actor> actorList) {
        mActorList.addAll(actorList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityMovieDetailActorAdapterBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.activity_movie_detail_actor_adapter, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mActorList.get(i));
    }

    @Override
    public int getItemCount() {
        return mActorList != null ? mActorList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ActivityMovieDetailActorAdapterBinding mBinding;
        private ItemMovieDetailViewModel mItemMovieDetailViewModel;

        public ViewHolder(@NonNull ActivityMovieDetailActorAdapterBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mItemMovieDetailViewModel = new ItemMovieDetailViewModel();
            mBinding.setViewModel(mItemMovieDetailViewModel);
        }

        public void bind(Actor actor) {
            mItemMovieDetailViewModel.setActorBinding(actor);
            mBinding.executePendingBindings();
        }
    }
}
