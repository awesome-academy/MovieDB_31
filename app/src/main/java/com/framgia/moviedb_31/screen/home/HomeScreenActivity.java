package com.framgia.moviedb_31.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityHomeScreenBinding;
import com.framgia.moviedb_31.utils.ItemClickListener;

public class HomeScreenActivity extends AppCompatActivity
        implements View.OnClickListener, ItemClickListener {
    private ActivityHomeScreenBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);
        MainViewModel mainViewModel = new MainViewModel(this);
        mBinding.setMainviewmodel(mainViewModel);
        mainViewModel.initData();
        mainViewModel.getImagePoster();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }
        SlideAdapter slideAdapter =
                new SlideAdapter(this, mBinding.getMainviewmodel().getImagePoster());
        mBinding.viewSlide.setAdapter(slideAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                mBinding.drawerLayout.openDrawer(Gravity.START);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClicked(String id) {

    }
}
