package com.framgia.moviedb_31.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BaseModel {

    @SerializedName("results")
    private List<Movie> mResults;

    public List<Movie> getResults() {
        return mResults;
    }

    public void setResults(List<Movie> results) {
        mResults = results;
    }
}
