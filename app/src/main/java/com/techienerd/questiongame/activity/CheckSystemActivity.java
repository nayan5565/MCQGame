package com.techienerd.questiongame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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
    private CheckBox ch1, ch2, ch3, ch4;
    private boolean isTrue;
    LinearLayout layOption;

    private static CheckSystemActivity instance;

    public static CheckSystemActivity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_system_activity);
        instance = this;
        init();
        generate();
        prepareDisplay();
//        setOptionWithCheckBox();
        prepareOptionView();
    }

    private void init() {
        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);
        ch4 = (CheckBox) findViewById(R.id.checkBox4);
        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        ch4.setOnClickListener(this);
        txtCount = (TextView) findViewById(R.id.txtCount);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        txtQues = (TextView) findViewById(R.id.tct);
        mOption = new MOption();
        mQuestion = new MQuestion();
//        optionArrayList = new ArrayList<>();
        questionArrayList = new ArrayList<>();

        layOption= (LinearLayout) findViewById(R.id.layOption);

    }

    public void prepareDisplay() {
        if (pos >= questionArrayList.size()) {
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            pos = 0;
            return;
        } else {
            txtQues.setText(questionArrayList.get(pos).getQues());

        }
//        txtCount.setText(QuestionAdapter.ca + " : " + QuestionAdapter.wa);
    }

    void prepareOptionView(){
        layOption.removeAllViews();
        for (int i=0;i<questionArrayList.get(pos).getList().size();i++){
            addCheckbox(questionArrayList.get(pos).getList().get(i).getItem()+"",i);
        }

    }
    public void setOptionWithCheckBox() {
        ch1.setText(questionArrayList.get(pos).getList().get(0).getItem() + "");
        ch2.setText(questionArrayList.get(pos).getList().get(1).getItem() + "");
        ch3.setText(questionArrayList.get(pos).getList().get(2).getItem() + "");
        ch4.setText(questionArrayList.get(pos).getList().get(3).getItem() + "");
//            ch1.setText(optionArrayList.get(0).getTag() + "");
//            ch2.setText(optionArrayList.get(1).getTag() + "");
//            ch3.setText(optionArrayList.get(2).getTag() + "");
//            ch4.setText(optionArrayList.get(3).getTag() + "");

    }

    private void generate() {
        questionArrayList = new ArrayList<>();
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

        // 2

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

        //3
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

        //4
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

    void addCheckbox(String text, final int id){

        CheckBox checkBox=new CheckBox(this);
        checkBox.setText(text);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionArrayList.get(pos).getList().get(id).getTag() == 1) {
                    Toast.makeText(CheckSystemActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CheckSystemActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i < layOption.getChildCount(); i++) {
                    layOption.getChildAt(i).setClickable(false);
                }


            }
        });


        layOption.addView(checkBox);
    }

    @Override
    public void onClick(View v) {
        int cId=v.getId();
        if (v.getId() == R.id.btnNext) {
            pos++;

            prepareDisplay();
            prepareOptionView();
            for (int i = 0; i < layOption.getChildCount(); i++) {
                layOption.getChildAt(i).setClickable(true);
            }
//            findViewById(100).setClickable(true);
//            ch1.setClickable(true);
//            ch2.setClickable(true);
//            ch3.setClickable(true);
//            ch4.setClickable(true);
//            ch1.setChecked(false);
//            ch2.setChecked(false);
//            ch3.setChecked(false);
//            ch4.setChecked(false);
//            prepareDisplay();
//            setOptionWithCheckBox();
//            isTrue=false;

        }
        Log.e("TEST",cId+"");
//        if (cId == 100) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getList().get(0).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (cId==101) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getList().get(1).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (cId==102) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getList().get(2).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (cId==103) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getList().get(3).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }


//            findViewById(100).setClickable(false);
//             findViewById(101).setClickable(false);
//             findViewById(102).setClickable(false);
//             findViewById(103).setClickable(false);




    }
}
