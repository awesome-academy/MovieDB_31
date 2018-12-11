package com.framgia.moviedb_31.screen.playMovie;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;
import com.framgia.moviedb_31.BuildConfig;
import com.framgia.moviedb_31.R;
import com.framgia.moviedb_31.databinding.ActivityPlayMovieBinding;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class PlayMovieActivity extends YouTubeBaseActivity {
    private static final String EXTRA_KEY = "EXTRA_KEY";
    private ActivityPlayMovieBinding mBinding;

    public static Intent getIntent(Context context, String value) {
        Intent intent = new Intent(context, PlayMovieActivity.class);
        intent.putExtra(EXTRA_KEY, value);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_play_movie);
        initYouTubeView();
    }

    void initYouTubeView() {
        mBinding.youtubeView.initialize(BuildConfig.YOUTUBE_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.loadVideo(getIntent().getStringExtra(EXTRA_KEY));
                        youTubePlayer.setFullscreen(true);
                        youTubePlayer.setShowFullscreenButton(false);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                            YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(PlayMovieActivity.this,
                                youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
