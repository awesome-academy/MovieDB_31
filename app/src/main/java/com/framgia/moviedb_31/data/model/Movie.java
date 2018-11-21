package com.framgia.moviedb_31.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    @SerializedName("original_title")
    private String mNameMovie;

    @SerializedName("vote_average")
    private String mRating;

    @SerializedName("poster_path")
    private String mPoster;

    @SerializedName("release_date")
    private String mDate;

    @SerializedName("overview")
    private String mContent;

    public Movie() {
    }

    public Movie(String nameMovie, String rating, String date, String poster, String content) {
        mNameMovie = nameMovie;
        mRating = rating;
        mDate = date;
        mPoster = poster;
        mContent = content;
    }

    protected Movie(Parcel in) {
        mNameMovie = in.readString();
        mRating = in.readString();
        mPoster = in.readString();
        mDate = in.readString();
        mContent = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getNameMovie() {
        return mNameMovie;
    }

    public void setNameMovie(String nameMovie) {
        mNameMovie = nameMovie;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mNameMovie);
        dest.writeString(mRating);
        dest.writeString(mPoster);
        dest.writeString(mDate);
        dest.writeString(mContent);
    }
}
