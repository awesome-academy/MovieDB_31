package com.framgia.moviedb_31.screen.listMovie;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityListMovieBinding;

public class ListMovieActivity extends AppCompatActivity {
    private static final String EXTRA_KEY = "EXTRA_KEY";
    private static final String EXTRA_VALUE = "EXTRA_VALUE";

    public static Intent getListMovieIntent(Context context, String key, String value) {
        Intent intent = new Intent(context, ListMovieActivity.class);
        intent.putExtra(EXTRA_KEY, key);
        intent.putExtra(EXTRA_VALUE, value);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ActivityListMovieBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_list_movie);
        ListMovieViewModel viewModel =
                new ListMovieViewModel(this, getIntent().getStringExtra(EXTRA_KEY),
                        getIntent().getStringExtra(EXTRA_VALUE));
        binding.setListMovieViewModel(viewModel);
    }
}
