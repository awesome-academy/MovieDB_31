package com.framgia.moviedb_31.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.framgia.moviedb_31.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie extends BaseObservable implements Parcelable {
    @SerializedName("id")
    @Expose
    private String mID;
    @SerializedName("original_title")
    @Expose
    private String mNameMovie;
    @SerializedName("vote_average")
    @Expose
    private String mRating;
    @SerializedName("poster_path")
    @Expose
    private String mPoster;
    @SerializedName("release_date")
    @Expose
    private String mDate;
    @SerializedName("overview")
    @Expose
    private String mContent;

    public Movie() {
    }

    public Movie(String ID, String nameMovie, String rating, String poster, String date,
            String content) {
        mID = ID;
        mNameMovie = nameMovie;
        mRating = rating;
        mPoster = poster;
        mDate = date;
        mContent = content;
    }

    protected Movie(Parcel in) {
        mID = in.readString();
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

    @Bindable
    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    @Bindable
    public String getNameMovie() {
        return mNameMovie;
    }

    public void setNameMovie(String nameMovie) {
        mNameMovie = nameMovie;
    }

    @Bindable
    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mID);
        dest.writeString(mNameMovie);
        dest.writeString(mRating);
        dest.writeString(mPoster);
        dest.writeString(mDate);
        dest.writeString(mContent);
    }
}
