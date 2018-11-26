package com.framgia.moviedb_31.screen.listMovie;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityListMovieBinding;

public class ListMovieActivity extends AppCompatActivity {
    private static final String CATEGORY = "CATEGORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public static Intent getListMovieIntent(Context context, String category) {
        Intent intent = new Intent(context, ListMovieActivity.class);
        intent.putExtra(CATEGORY, category);
        return intent;
    }

    private void initView() {
        ActivityListMovieBinding activityListMovieBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_list_movie);
        ListMovieViewModel viewModel = new ListMovieViewModel(getIntent().getStringExtra(CATEGORY));
        activityListMovieBinding.setListMovieViewModel(viewModel);
    }
}
