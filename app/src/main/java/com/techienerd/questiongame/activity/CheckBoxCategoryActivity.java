package com.techienerd.questiongame.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.utils.DatabaseHelper;
import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.CheckBoxCategoryAdapter;
import com.techienerd.questiongame.model.MCategory;
import com.techienerd.questiongame.model.MQuestion;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

public class CheckBoxCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    ArrayList<MOption> optionArrayList;
    ArrayList<MQuestion> questionArrayList;
    ArrayList<MCategory> categoryArrayList;
    MCategory mCategory;
    MQuestion mQuestion;
    MOption mOption;
    private Button btnStatistics;
    CheckBoxCategoryAdapter adapter;
    DatabaseHelper db;
    private static CheckBoxCategoryActivity instance;

    public static CheckBoxCategoryActivity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        init();
        generateToMulti();
        prepareView();
    }

    private void init() {
        btnStatistics = (Button) findViewById(R.id.btnStatistics);
        btnStatistics.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        mOption = new MOption();
        mQuestion = new MQuestion();
        optionArrayList = new ArrayList<>();
        questionArrayList = new ArrayList<>();
        adapter = new CheckBoxCategoryAdapter(this);
        db=new DatabaseHelper(this);
    }
    public void prepareView() {
        adapter.setQues(categoryArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void generateToMulti() {
        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
        categoryArrayList = new ArrayList<>();

        mCategory = new MCategory();

        mCategory.setType("ইংরেজি প্রশ্ন ");
        mCategory.setId(1);

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


        mCategory.setQuestionArrayList(questionArrayList);
        categoryArrayList.add(mCategory);

        //bangla question

        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();

        mCategory = new MCategory();
        mCategory.setType("বাংলা প্রশ্ন");
        mCategory.setId(2);

        mQuestion.setQues("BTRC-এর ইংরেজি পূর্নরুপ কোনটি?");

        mOption = new MOption();
        mOption.setOption("Bangladesh Telephone Regulatory Commission");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("Bangladesh Telecom Regulatory Commission");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("Bangladesh Telephone and Telegraph Regulatory Commission");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("Bangladesh Telecommunication Regulatory Commission");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        // 2

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("বাংলাদেশ রেলওয়ের সর্ববৃহৎ কারখানা কোথায় ?");

        mOption = new MOption();
        mOption.setOption("সৈয়দপুর ");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("পাকশি ");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("আখাউড়া ");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("চট্টগ্রাম");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        //3
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues(" বাংলাদেশের জাতিয় পতাকার দৈর্ঘ - প্রস্থের অনুপাত কোনটি ?");
        mOption = new MOption();
        mOption.setOption("৮ ঃ ৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১০ ঃ ৬");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১১ ঃ ৮");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১১ ঃ ৭ ");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);

        //4
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("আটলান্টিক ও প্রশান্ত মহাসাগরকে যুক্ত করেছে কোনটি ?");
        mOption = new MOption();
        mOption.setOption("সুয়েজ খাল");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("মিসিসিপি");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("পানামা খাল");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("ভলগা");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);
//5
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("পূর্বে কোন দেশটি শ্যামদেশ পরিচিত ছিল ?");
        mOption = new MOption();
        mOption.setOption("মালয়েশিয়া");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("ইন্দোনেশিয়া");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("মায়ানমার");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("থাইল্যান্ড");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion); optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("হাজার হ্রদের দেশ কোনটি ?");
        mOption = new MOption();
        mOption.setOption("নরওয়ে");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("ফিনল্যান্ড");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("জাপান");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("কোরিয়া");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("রেলপথে ঢাকা থেকে খুলনার দুরুত্ব কত ?");
        mOption = new MOption();
        mOption.setOption("৩৬০ কিমি");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৪৮০ কিমি");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৫২৯ কিমি");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৬২৭ কিমি");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);


        mCategory.setQuestionArrayList(questionArrayList);
        categoryArrayList.add(mCategory);


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
