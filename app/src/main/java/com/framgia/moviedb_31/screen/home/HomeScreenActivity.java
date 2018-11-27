package com.framgia.moviedb_31.screen.home;

import android.app.SearchManager;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityHomeScreenBinding;
import com.framgia.moviedb_31.screen.listMovie.ListMovieActivity;
import com.framgia.moviedb_31.screen.listgenres.ListGenresActivity;
import com.framgia.moviedb_31.screen.movieDetail.MovieDetailActivity;
import com.framgia.moviedb_31.utils.Constant;
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

        mBinding.textShowMoreTopRate.setOnClickListener(this);
        mBinding.textShowMorePopular.setOnClickListener(this);
        mBinding.textShowMoreNowPlaying.setOnClickListener(this);
        mBinding.textShowMoreUpComing.setOnClickListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                startActivity(ListMovieActivity.getListMovieIntent(HomeScreenActivity.this,
                        Constant.TYPE_SEARCH, s));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_show_more_top_rate:
                startActivity(ListMovieActivity.getListMovieIntent(this, Constant.TYPE_CATEGORY,
                        Constant.TOP_RATED));
                break;
            case R.id.text_show_more_popular:
                startActivity(ListMovieActivity.getListMovieIntent(this, Constant.TYPE_CATEGORY,
                        Constant.POPULAR));
                break;
            case R.id.text_show_more_now_playing:
                startActivity(ListMovieActivity.getListMovieIntent(this, Constant.TYPE_CATEGORY,
                        Constant.NOW_PLAYING));
                break;
            case R.id.text_show_more_up_coming:
                startActivity(ListMovieActivity.getListMovieIntent(this, Constant.TYPE_CATEGORY,
                        Constant.UP_COMING));
                break;
        }
    }

    @Override
    public void onItemClicked(String id) {
        startActivity(MovieDetailActivity.newIntent(this, id));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_genres:
                startActivity(ListGenresActivity.getListGenresIntent(this));
                break;
        }
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
