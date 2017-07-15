package com.techienerd.questiongame.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.QuestionAdapter;
import com.techienerd.questiongame.model.MAllQuestion;
import com.techienerd.questiongame.model.MQuestion;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    ArrayList<MOption> optionArrayList;
    ArrayList<MQuestion> questionArrayList;
    ArrayList<MAllQuestion> allQuestionArrayList;
    MAllQuestion mAllQuestion;
    MQuestion mQuestion;
    MOption mOption;
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
//        generate();
//        prepareDisplay();
        generateToMulti();
        prepareView();
    }

    private void init() {
        txtCount = (TextView) findViewById(R.id.txtCount);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        txtQues = (TextView) findViewById(R.id.tct);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        mOption = new MOption();
        mQuestion = new MQuestion();
        optionArrayList = new ArrayList<>();
        questionArrayList = new ArrayList<>();
        adapter = new QuestionAdapter(this);
    }

//    public void prepareDisplay() {
//        if (pos >= questionArrayList.size()) {
//            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
//            pos = 0;
//            return;
//        } else {
//            txtQues.setText(questionArrayList.get(pos).getQues());
//            adapter.setData(questionArrayList.get(pos).getOptionArrayList());
//            pos++;
//        }
////        txtCount.setText(QuestionAdapter.ca + " : " + QuestionAdapter.wa);
//        adapter.notifyDataSetChanged();
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setAdapter(adapter);
//    }

    public void prepareView() {
        adapter.setQues(allQuestionArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void setCount(CharSequence text) {
        txtCount.setText(text);
    }

    private void generateToMulti() {
        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
        allQuestionArrayList = new ArrayList<>();

        mAllQuestion = new MAllQuestion();

        mAllQuestion.setType("ইংরেজি প্রশ্ন ");
        mAllQuestion.setId(1);

        mQuestion = new MQuestion();

        mQuestion.setQues("2+2=?");

        mOption = new MOption();
        mOption.setOption("2");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("8");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("4");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        // 2

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("5+5=?");

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("11");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        //3
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+5=?");
        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("12");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);

        //4
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("7+2=?");
        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("6");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);
//5
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("8+2=?");
        mOption = new MOption();
        mOption.setOption("16");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("12");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("11");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);


        mAllQuestion.setQuestionArrayList(questionArrayList);
        allQuestionArrayList.add(mAllQuestion);

        //bangla question

        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();

        mAllQuestion = new MAllQuestion();
        mAllQuestion.setType("বাংলা  প্রশ্ন ");
        mAllQuestion.setId(2);

        mQuestion.setQues("2+2=?");

        mOption = new MOption();
        mOption.setOption("2");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("8");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("4");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        // 2

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("5+5=?");

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("11");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        //3
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+5=?");
        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("12");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);

        //4
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("7+2=?");
        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("6");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);
//5
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("8+2=?");
        mOption = new MOption();
        mOption.setOption("16");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("12");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("11");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);


        mAllQuestion.setQuestionArrayList(questionArrayList);
        allQuestionArrayList.add(mAllQuestion);


    }

//    private void generate() {
//        questionArrayList = new ArrayList<>();
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//
//        mQuestion.setQues("2+2=?");
//
//        mOption = new MOption();
//        mOption.setOption("2");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("7");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("8");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("4");
//        mOption.setTag(1);
//
//        optionArrayList.add(mOption);
//
//        mQuestion.setOptionArrayList(optionArrayList);
//
//        questionArrayList.add(mQuestion);
//
//        // 2
//
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//        mQuestion.setQues("5+5=?");
//
//        mOption = new MOption();
//        mOption.setOption("10");
//        mOption.setTag(1);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("9");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("5");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("11");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mQuestion.setOptionArrayList(optionArrayList);
//
//        questionArrayList.add(mQuestion);
//
//        //3
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//        mQuestion.setQues("2+5");
//        mOption = new MOption();
//        mOption.setOption("9");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("7");
//        mOption.setTag(1);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("5");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("12");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mQuestion.setOptionArrayList(optionArrayList);
//
//
//        questionArrayList.add(mQuestion);
//
//        //4
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//        mQuestion.setQues("7+2");
//        mOption = new MOption();
//        mOption.setOption("5");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("6");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("9");
//        mOption.setTag(1);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("10");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mQuestion.setOptionArrayList(optionArrayList);
//
//
//        questionArrayList.add(mQuestion);
//
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//        mQuestion.setQues("8+2");
//        mOption = new MOption();
//        mOption.setOption("16");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("12");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("11");
//        mOption.setTag(0);
//
//        optionArrayList.add(mOption);
//
//        mOption = new MOption();
//        mOption.setOption("10");
//        mOption.setTag(1);
//
//        optionArrayList.add(mOption);
//
//        mQuestion.setOptionArrayList(optionArrayList);
//
//        questionArrayList.add(mQuestion);
//
//
//    }

    @Override
    public void onClick(View v) {
//        prepareDisplay();
    }
}
