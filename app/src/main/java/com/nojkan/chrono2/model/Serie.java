package com.nojkan.chrono2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nojkan on 11/07/2017.
 */

public class Serie implements  Parcelable {
    protected Serie(Parcel in) {
        id = in.readInt();
    }


    private int id;
    private Score score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getTitle(){
        //on ajoute 1 pour avoir le nom de la serie entre 1 et N et non 0 et N
        return (this.getId()+1)+"";
    }




    public Serie(int input){
         id = input;
         score = new Score();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
    }
}
