package com.framgia.moviedb_31.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityHomeScreenBinding;
import com.framgia.moviedb_31.utils.ItemClickListener;

public class HomeScreenActivity extends AppCompatActivity
        implements View.OnClickListener, ItemClickListener,
        NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {
    private ActivityHomeScreenBinding mBinding;
    private ActionBar mActionBar;

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
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }
        SlideAdapter slideAdapter =
                new SlideAdapter(this, mBinding.getMainviewmodel().getImagePoster());
        mBinding.viewSlide.setAdapter(slideAdapter);
        mBinding.navView.setNavigationItemSelectedListener(this);
        mBinding.drawerLayout.addDrawerListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (mBinding.drawerLayout.isDrawerOpen(Gravity.START)) {
                    mBinding.drawerLayout.closeDrawer(Gravity.START);
                } else {
                    mBinding.drawerLayout.openDrawer(Gravity.START);
                }
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClicked(String id) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {

    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public void onDrawerStateChanged(int i) {

    }
}
