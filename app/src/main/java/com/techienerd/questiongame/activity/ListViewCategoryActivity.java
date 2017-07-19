package com.techienerd.questiongame.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.ListViewCategoryAdapter;
import com.techienerd.questiongame.model.MAllQuestion;
import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.model.MQuestion;
import com.techienerd.questiongame.utils.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ListViewCategoryActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    ArrayList<MOption> optionArrayList;
    ArrayList<MQuestion> questionArrayList;
    public ArrayList<MAllQuestion> allQuestionArrayList;
    MAllQuestion mAllQuestion;
    MQuestion mQuestion;
    MOption mOption;
    private TextView txtCount;
    private Button btnNext,btnStatistics;
    public int pos,correct,wrong;
    private TextView txtQues;
    ListViewCategoryAdapter adapter;
    DatabaseHelper db;
    private static ListViewCategoryActivity instance;

    public static ListViewCategoryActivity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_option);
        instance = this;
        init();
        generateToMulti();
        prepareView();
    }

    private void init() {
        btnStatistics = (Button) findViewById(R.id.btnStatisticsList);
        btnStatistics.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recList);
        mOption = new MOption();
        mQuestion = new MQuestion();
        optionArrayList = new ArrayList<>();
        questionArrayList = new ArrayList<>();
        adapter = new ListViewCategoryAdapter(this);
        db=new DatabaseHelper(this);
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
////        txtCount.setText(CheckBoxCategoryAdapter.ca + " : " + CheckBoxCategoryAdapter.wa);
//        adapter.notifyDataSetChanged();
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setAdapter(adapter);
//    }

    public void prepareView() {
        adapter.setQues(allQuestionArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
        mAllQuestion.setType("বাংলা প্রশ্ন");
        mAllQuestion.setId(2);

        mQuestion.setQues("২+২ =?");

        mOption = new MOption();
        mOption.setOption("২");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৭");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৮");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৪");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        // 2

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("৫+৫=?");

        mOption = new MOption();
        mOption.setOption("১০");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৯");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১১");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        //3
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("২+৫=?");
        mOption = new MOption();
        mOption.setOption("৯");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৭");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১২");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);

        //4
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("৭+২=?");
        mOption = new MOption();
        mOption.setOption("৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৬");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৯");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১০");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);
//5
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("৮+২=?");
        mOption = new MOption();
        mOption.setOption("১৬");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১২");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১১");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১০");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);


        mAllQuestion.setQuestionArrayList(questionArrayList);
        allQuestionArrayList.add(mAllQuestion);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnStatistics){
            Dialog dialog=new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dia_statistics);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            TextView txtEp=(TextView)dialog.findViewById(R.id.txtEP);
            txtEp.setText(db.getBestScores(1)+"");
            TextView txtBp = (TextView) dialog.findViewById(R.id.txtBP);
            txtBp.setText(db.getBestScores(2)+"");
            dialog.show();

        }
    }
}
