package com.framgia.moviedb_31.screen.listgenres;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.data.model.Genres;
import com.framgia.moviedb_31.databinding.ItemListGenresBinding;
import com.framgia.moviedb_31.utils.ItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class ListGenresAdapter extends RecyclerView.Adapter<ListGenresAdapter.ViewHolder> {

    private List<Genres> mGenresList;
    private ItemClickListener mListener;

    public ListGenresAdapter(ItemClickListener listener) {
        mListener = listener;
        mGenresList = new ArrayList<>();
    }

    void setGenresList(List<Genres> genresList) {
        mGenresList.addAll(genresList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemListGenresBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_list_genres, viewGroup, false);
        return new ViewHolder(binding, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mGenresList.get(i));
    }

    @Override
    public int getItemCount() {
        return mGenresList != null ? mGenresList.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private Genres mGenres;
        private ItemListGenresBinding mBinding;
        private ItemListGenresViewModel mItemListGenresViewModel;
        private ItemClickListener mListener;

        public ViewHolder(@NonNull ItemListGenresBinding itemView, ItemClickListener listener) {
            super(itemView.getRoot());
            mBinding = itemView;
            mListener = listener;
            mItemListGenresViewModel = new ItemListGenresViewModel(mListener);
            mBinding.setItemListGenresViewModel(mItemListGenresViewModel);
            mItemListGenresViewModel.onItemClicked(mBinding.getRoot());
        }

        void bindData(Genres genres) {
            mGenres = genres;
            mItemListGenresViewModel.setItemListMovieBinding(mGenres);
            mBinding.executePendingBindings();
        }
    }
}
