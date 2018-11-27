package com.framgia.moviedb_31.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BaseVideos {
    @SerializedName("results")
    @Expose
    private List<Videos> mResults;

    public List<Videos> getResults() {
        return mResults;
    }
}
