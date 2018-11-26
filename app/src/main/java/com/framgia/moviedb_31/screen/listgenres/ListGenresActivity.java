package com.framgia.moviedb_31.screen.listgenres;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityListGenresBinding;
import com.framgia.moviedb_31.utils.ItemClickListener;

public class ListGenresActivity extends AppCompatActivity implements ItemClickListener {

    private static final String TITLE_GENRES = "GENRES";

    public static Intent getListGenresIntent(Context context) {
        return new Intent(context, ListGenresActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ActivityListGenresBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_list_genres);
        ListGenresViewModel listGenresViewModel = new ListGenresViewModel(this);
        binding.setViewModel(listGenresViewModel);
        listGenresViewModel.initData();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
            actionBar.setTitle(TITLE_GENRES);
        }
    }

    @Override
    public void onItemClicked(String id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
