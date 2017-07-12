package com.techienerd.questiongame.model;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/12/2017.
 */
public class MQuestion {
    private int id;
    private String ques;
    private ArrayList<MOption>list;

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

    public ArrayList<MOption> getList() {
        return list;
    }

    public void setList(ArrayList<MOption> list) {
        this.list = list;
    }
}
