package com.framgia.moviedb_31.screen.movieDetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityMovieDetailBinding;

public class MovieDetailActivity extends AppCompatActivity {
    private ActivityMovieDetailBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        MovieDetailViewModel viewModel = new MovieDetailViewModel();
        mBinding.setViewModel(viewModel);
    }

    @Override
    protected void onStop() {
        mBinding.getViewModel().onStop();
        super.onStop();
    }
}
