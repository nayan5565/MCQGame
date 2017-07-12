package com.techienerd.questiongame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.QuestionAdapter;
import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.model.MQuestion;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/12/2017.
 */
public class CheckSystemActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<MOption> optionArrayList;
    ArrayList<MQuestion> questionArrayList;
    MQuestion mQuestion;
    MOption mOption;
    private TextView txtCount;
    private Button btnNext;
    private int pos;
    private TextView txtQues;

    private static CheckSystemActivity instance;

    public static CheckSystemActivity getInstance() {

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
        mOption = new MOption();
        mQuestion = new MQuestion();
        optionArrayList = new ArrayList<>();
        questionArrayList = new ArrayList<>();

    }

    public void prepareDisplay() {
        if (pos >= questionArrayList.size()) {
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            pos = 0;
            return;
        } else {
            txtQues.setText(questionArrayList.get(pos).getQues());
            pos++;
        }
//        txtCount.setText(QuestionAdapter.ca + " : " + QuestionAdapter.wa);
    }

    public void setCount(CharSequence text) {
        txtCount.setText(text);
    }

    private void generate() {
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+2");
        mOption = new MOption();
        mOption.setItem(2);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(7);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(6);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(4);
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setList(optionArrayList);

        questionArrayList.add(mQuestion);

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("5+5=?");

        mOption = new MOption();
        mOption.setItem(10);
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(4);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(6);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(8);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setList(optionArrayList);

        questionArrayList.add(mQuestion);

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+5");
        mOption = new MOption();
        mOption.setItem(2);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(7);
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(6);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(8);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setList(optionArrayList);


        questionArrayList.add(mQuestion);

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("7+2");
        mOption = new MOption();
        mOption.setItem(2);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(4);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(9);
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(8);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setList(optionArrayList);


        questionArrayList.add(mQuestion);

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("8+2");
        mOption = new MOption();
        mOption.setItem(2);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(4);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(6);
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setItem(10);
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setList(optionArrayList);

        questionArrayList.add(mQuestion);


    }

    @Override
    public void onClick(View v) {
        prepareDisplay();
    }
}
