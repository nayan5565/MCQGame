package com.techienerd.questiongame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.R;
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
    private int correct, wrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_system_activity);
        init();
        changeButtonColor();
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

        layOption = (LinearLayout) findViewById(R.id.layOption);

    }

    public void changeButtonColor(){
        if (!isTrue)
            btnNext.setBackgroundColor(0xffff0000);
    }

    public void prepareDisplay() {
        if (pos >= questionArrayList.size()) {
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            pos = 0;
            return;
        } else {
            txtQues.setText(questionArrayList.get(pos).getQues());

        }
//
    }

    void prepareOptionView() {
        layOption.removeAllViews();
        for (int i = 0; i < questionArrayList.get(pos).getList().size(); i++) {
            addCheckbox(questionArrayList.get(pos).getList().get(i).getOption(), i);
        }

    }

    public void setOptionWithCheckBox() {
        ch1.setText(questionArrayList.get(pos).getList().get(0).getOption() + "");
        ch2.setText(questionArrayList.get(pos).getList().get(1).getOption() + "");
        ch3.setText(questionArrayList.get(pos).getList().get(2).getOption() + "");
        ch4.setText(questionArrayList.get(pos).getList().get(3).getOption() + "");
//            ch1.setText(optionArrayList.get(0).getTag() + "");
//            ch2.setText(optionArrayList.get(1).getTag() + "");
//            ch3.setText(optionArrayList.get(2).getTag() + "");
//            ch4.setText(optionArrayList.get(3).getTag() + "");

    }

    private void generate() {
        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
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

        mQuestion.setList(optionArrayList);

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

        mQuestion.setList(optionArrayList);

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

        mQuestion.setList(optionArrayList);


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

        mQuestion.setList(optionArrayList);


        questionArrayList.add(mQuestion);

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

        mQuestion.setList(optionArrayList);

        questionArrayList.add(mQuestion);


    }

    public void addCheckbox(String text, final int id) {

        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(text);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTrue = true;
                btnNext.setBackgroundColor(0xff00ff00);
                if (questionArrayList.get(pos).getList().get(id).getTag() == 1) {
                    correct++;
                    Toast.makeText(CheckSystemActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(CheckSystemActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i < layOption.getChildCount(); i++) {
                    layOption.getChildAt(i).setClickable(false);
                }
                txtCount.setText(correct + " : " + wrong);

            }
        });


        layOption.addView(checkBox);
    }

    @Override
    public void onClick(View v) {
//        int cId = v.getId();
        if (!isTrue)
            return;

        if (v.getId() == R.id.btnNext) {
            pos++;
            isTrue = false;
            prepareDisplay();
            prepareOptionView();
            for (int i = 0; i < layOption.getChildCount(); i++) {
                layOption.getChildAt(i).setClickable(true);
            }
            if (!isTrue)
                changeButtonColor();
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
//        Log.e("TEST", cId + "");
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
