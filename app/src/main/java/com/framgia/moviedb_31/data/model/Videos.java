package com.framgia.moviedb_31.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos implements Parcelable {
    @SerializedName("id")
    @Expose
    private String mID;
    @SerializedName("key")
    @Expose
    private String mKey;

    public Videos(String ID, String key) {
        mID = ID;
        mKey = key;
    }

    public Videos() {
    }

    protected Videos(Parcel in) {
        mID = in.readString();
        mKey = in.readString();
    }

    public static final Creator<Videos> CREATOR = new Creator<Videos>() {
        @Override
        public Videos createFromParcel(Parcel in) {
            return new Videos(in);
        }

        @Override
        public Videos[] newArray(int size) {
            return new Videos[size];
        }
    };

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mID);
        dest.writeString(mKey);
    }
}
