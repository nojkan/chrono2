package com.nojkan.chrono2.model;

import java.util.Date;

/**
 * Created by nojkan on 11/07/2017.
 */

public class Score {
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    private int score;
     private Date timestamp;


     public Score(int inscore) {
         score = inscore;
         timestamp = new Date();
     }
}
