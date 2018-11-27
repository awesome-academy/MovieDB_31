package com.framgia.moviedb_31.data.model;

import com.google.gson.annotations.SerializedName;

public class Genres {
    @SerializedName("id")
    private String mGenresId;
    @SerializedName("name")
    private String mGenresName;

    public Genres(String genresId, String genresName) {
        mGenresId = genresId;
        mGenresName = genresName;
    }

    public String getGenresId() {
        return mGenresId;
    }

    public void setGenresId(String genresId) {
        mGenresId = genresId;
    }

    public String getGenresName() {
        return mGenresName;
    }

    public void setGenresName(String genresName) {
        mGenresName = genresName;
    }
}
