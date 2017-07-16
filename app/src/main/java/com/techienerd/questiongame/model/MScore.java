package com.techienerd.questiongame.model;

/**
 * Created by Nayan on 7/16/2017.
 */
public class MScore {
    private int presentScore;
    private int bestScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public int getPresentScore() {
        return presentScore;
    }

    public void setPresentScore(int presentScore) {
        this.presentScore = presentScore;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
