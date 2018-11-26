package com.framgia.moviedb_31.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actor implements Parcelable {
    @SerializedName("cast_id")
    @Expose
    private String mID;
    @SerializedName("character")
    @Expose
    private String mCharacter;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("profile_path")
    @Expose
    private String mPoster;

    public Actor(String ID, String character, String name, String poster) {
        mID = ID;
        mCharacter = character;
        mName = name;
        mPoster = poster;
    }

    public Actor() {
    }

    protected Actor(Parcel in) {
        mID = in.readString();
        mCharacter = in.readString();
        mName = in.readString();
        mPoster = in.readString();
    }

    public static final Creator<Actor> CREATOR = new Creator<Actor>() {
        @Override
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        @Override
        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public void setCharacter(String character) {
        mCharacter = character;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mID);
        dest.writeString(mCharacter);
        dest.writeString(mName);
        dest.writeString(mPoster);
    }
}
