package com.framgia.moviedb_31.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Production implements Parcelable {
    @SerializedName("credit_id")
    @Expose
    private String mID;

    @SerializedName("profile_path")
    @Expose
    private String mPoster;

    @SerializedName("name")
    @Expose
    private String mNameProduction;

    public Production() {
    }

    public Production(String ID, String poster, String nameProduction) {
        mID = ID;
        mPoster = poster;
        mNameProduction = nameProduction;
    }

    protected Production(Parcel in) {
        mID = in.readString();
        mPoster = in.readString();
        mNameProduction = in.readString();
    }

    public static final Creator<Production> CREATOR = new Creator<Production>() {
        @Override
        public Production createFromParcel(Parcel in) {
            return new Production(in);
        }

        @Override
        public Production[] newArray(int size) {
            return new Production[size];
        }
    };

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }

    public String getNameProduction() {
        return mNameProduction;
    }

    public void setNameProduction(String nameProduction) {
        mNameProduction = nameProduction;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mID);
        dest.writeString(mPoster);
        dest.writeString(mNameProduction);
    }
}
