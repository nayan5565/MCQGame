package com.techienerd.questiongame.model;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/12/2017.
 */
public class MQuestion {
    private int id;
    private String ques;
    private ArrayList<Model>list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public ArrayList<Model> getList() {
        return list;
    }

    public void setList(ArrayList<Model> list) {
        this.list = list;
    }
}
