package com.techienerd.questiongame.model;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/15/2017.
 */
public class MAllQuestion {
    private int id;
    private ArrayList<MQuestion>questionArrayList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<MQuestion> getQuestionArrayList() {
        return questionArrayList;
    }

    public void setQuestionArrayList(ArrayList<MQuestion> questionArrayList) {
        this.questionArrayList = questionArrayList;
    }
}
