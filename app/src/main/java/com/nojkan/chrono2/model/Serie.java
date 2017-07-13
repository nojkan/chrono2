package com.nojkan.chrono2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nojkan on 11/07/2017.
 */

public class Serie implements  Parcelable {
    protected Serie(Parcel in) {
        id = in.readString();
    }

    public static final Creator<Serie> CREATOR = new Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel in) {
            return new Serie(in);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    private String id;
    private Score score;

    public Serie (String input){
        id = input;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
    }
}
