package com.techienerd.questiongame.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.QuestionAdapter;
import com.techienerd.questiongame.model.MQuestion;
import com.techienerd.questiongame.model.Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    ArrayList<Model> models;
    ArrayList<MQuestion> questionArrayList;
    MQuestion mQuestion;
    Model model;
    private TextView txtCount;
    private Button btnNext;
    private int pos;
    private TextView txtQues;
    QuestionAdapter adapter;
    private static MainActivity instance;

    public static MainActivity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        init();
        generate();
        prepareDisplay();
    }

    private void init() {
        txtCount = (TextView) findViewById(R.id.txtCount);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        txtQues = (TextView) findViewById(R.id.tct);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        model = new Model();
        mQuestion = new MQuestion();
        models = new ArrayList<>();
        questionArrayList = new ArrayList<>();
        adapter = new QuestionAdapter(this);
    }

    public void prepareDisplay() {
        if (pos >= questionArrayList.size()) {
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            pos = 0;
            return;
        } else {
            txtQues.setText(questionArrayList.get(pos).getQues());
            adapter.setData(questionArrayList.get(pos).getList());
            pos++;
        }
//        txtCount.setText(QuestionAdapter.ca + " : " + QuestionAdapter.wa);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    public void setCount(CharSequence text) {
        txtCount.setText(text);
    }

    private void generate() {
        models = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+2");
        model = new Model();
        model.setItem(2);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(7);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(6);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(4);
        model.setTag(1);

        models.add(model);

        mQuestion.setList(models);

        questionArrayList.add(mQuestion);

        models = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("5+5=?");

        model = new Model();
        model.setItem(10);
        model.setTag(1);

        models.add(model);

        model = new Model();
        model.setItem(4);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(6);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(8);
        model.setTag(0);

        models.add(model);

        mQuestion.setList(models);

        questionArrayList.add(mQuestion);

        models = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+5");
        model = new Model();
        model.setItem(2);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(7);
        model.setTag(1);

        models.add(model);

        model = new Model();
        model.setItem(6);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(8);
        model.setTag(0);

        models.add(model);

        mQuestion.setList(models);


        questionArrayList.add(mQuestion);

        models = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("7+2");
        model = new Model();
        model.setItem(2);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(4);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(9);
        model.setTag(1);

        models.add(model);

        model = new Model();
        model.setItem(8);
        model.setTag(0);

        models.add(model);

        mQuestion.setList(models);


        questionArrayList.add(mQuestion);

        models = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("8+2");
        model = new Model();
        model.setItem(2);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(4);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(6);
        model.setTag(0);

        models.add(model);

        model = new Model();
        model.setItem(10);
        model.setTag(1);

        models.add(model);

        mQuestion.setList(models);

        questionArrayList.add(mQuestion);


    }

    @Override
    public void onClick(View v) {

    }
}
