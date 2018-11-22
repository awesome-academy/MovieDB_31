package com.framgia.moviedb_31.screen.listMovie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityListMovieBinding;

public class ListMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListMovieBinding activityListMovieBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_list_movie);
        ListMovieViewModel viewModel = new ListMovieViewModel();
        activityListMovieBinding.setListMovieViewModel(viewModel);
    }
}
