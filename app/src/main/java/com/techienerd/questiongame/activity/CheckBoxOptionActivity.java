package com.techienerd.questiongame.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.utils.DatabaseHelper;
import com.techienerd.questiongame.R;
import com.techienerd.questiongame.model.MScore;
import com.techienerd.questiongame.utils.Global;

/**
 * Created by Nayan on 7/12/2017.
 */
public class CheckBoxOptionActivity extends AppCompatActivity implements View.OnClickListener {
    //    ArrayList<MOption> optionArrayList;
//    ArrayList<MQuestion> questionArrayList;
//    ArrayList<MAllQuestion> allQuestionArrayList;
//    MAllQuestion mAllQuestion;
//    MQuestion mQuestion;
//    MOption mOption;
    private TextView txtCount;
    private Button btnNext, btnStatistics;
    private int pos;
    private TextView txtQues, txtType, txtWrong, txtOptionChanged;
    private CheckBox ch1, ch2, ch3, ch4;
    private boolean isTrue;
    private LinearLayout layOption;
    private int correct, wrong;
    private int index, count=10;
    private int parentId;
    private int bestScore;
    private Handler handler;
    private MScore mScore;
    private DatabaseHelper db;
//    SparseBooleanArray checked = listView.getCheckedItemPositions();
//    private CheckBoxCategoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_system_activity);
        init();
        changeButtonColor();
//        generate();
//        Collections.shuffle(questionArrayList);
        prepareDisplay();
//        setOptionWithCheckBox();
//        prepareOptionView();
        change();


    }

    private void init() {
        mScore = new MScore();
        index = getIntent().getIntExtra("index", 0);
        Global.parentId = getIntent().getIntExtra("parentId", 0);
        parentId = Global.parentId;
        Log.e("id", " is " + parentId);

        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);
        ch4 = (CheckBox) findViewById(R.id.checkBox4);
        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        ch4.setOnClickListener(this);
        txtCount = (TextView) findViewById(R.id.txtCount);
        txtType = (TextView) findViewById(R.id.txtType);
        txtWrong = (TextView) findViewById(R.id.txtWrong);
        txtOptionChanged = (TextView) findViewById(R.id.txtOptionChange);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        txtQues = (TextView) findViewById(R.id.tct);
//        mOption = new MOption();
//        mQuestion = new MQuestion();
//        adapter = new CheckBoxCategoryAdapter(this);
        txtType.setText(CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getType());
        db = new DatabaseHelper(this);
        layOption = (LinearLayout) findViewById(R.id.layOption);
        handler = new Handler();

    }

    public void changeButtonColor() {
        if (!isTrue)
            btnNext.setBackgroundColor(0xffff0000);
    }

    public void prepareDisplay() {
        if (pos >= CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().size()) {
            Log.e("step", "one");
            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(false);
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dia_game_over);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Button btnOk = (Button) dialog.findViewById(R.id.btnOK);
            final TextView txtMark = (TextView) dialog.findViewById(R.id.txtScore);
            TextView txtBestScore = (TextView) dialog.findViewById(R.id.txtBestScore);
//            int bp = db.getBestScores(parentId);
            bestScore = db.getBestScores(parentId);
            int score = correct * (100 / CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().size());
            if (score > bestScore) {
                bestScore = score;
                mScore.setParentId(Global.parentId);
                mScore.setBestScore(bestScore);

                db.addBestScore(mScore);
            }


//            txtBestScore.setText(db.getBestScores() + "");
            Log.e("score", "best " + bestScore);
            Log.e("score", "present " + score);

            txtMark.setText("Congratulation!Your score is " + score + " out of 100");
            txtBestScore.setText("Best score " + bestScore + "");
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    pos = 0;
//                    correct = 0;
//                    wrong = 0;
//                    txtCount.setText(correct + " : ");
//                    txtWrong.setText(wrong + "");
//                    Collections.shuffle(CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList());
//                    prepareDisplay();
//                    change();
                    finish();
//                    dialog.dismiss();
                }
            });
            dialog.show();
//            layOption.removeAllViews();

            return;
        } else {
            Log.e("step", "two");
            txtQues.setText(CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getQues());
            layOption.removeAllViews();
            for (int i = 0; i < CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().size(); i++) {
                addCheckbox(CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(i).getOption(), i);
            }

        }
//
    }

//    void prepareOptionView() {
//        layOption.removeAllViews();
//        for (int i = 0; i < questionArrayList.get(pos).getOptionArrayList().size(); i++) {
//            addCheckbox(questionArrayList.get(pos).getOptionArrayList().get(i).getOption(), i);
//        }
//
//    }

//    public void setOptionWithCheckBox() {
//        ch1.setText(questionArrayList.get(pos).getOptionArrayList().get(0).getOption() + "");
//        ch2.setText(questionArrayList.get(pos).getOptionArrayList().get(1).getOption() + "");
//        ch3.setText(questionArrayList.get(pos).getOptionArrayList().get(2).getOption() + "");
//        ch4.setText(questionArrayList.get(pos).getOptionArrayList().get(3).getOption() + "");
////            ch1.setText(optionArrayList.get(0).getTag() + "");
////            ch2.setText(optionArrayList.get(1).getTag() + "");
////            ch3.setText(optionArrayList.get(2).getTag() + "");
////            ch4.setText(optionArrayList.get(3).getTag() + "");
//
//    }

//    private void generate() {
//        questionArrayList = new ArrayList<>();
//        optionArrayList = new ArrayList<>();
//        allQuestionArrayList = new ArrayList<>();
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
//        mQuestion.setQues("2+5=?");
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
//        mQuestion.setQues("7+2=?");
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
////5
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//        mQuestion.setQues("8+2=?");
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
//        mAllQuestion = new MAllQuestion();
//        mAllQuestion.setType("ইংরেজি প্রশ্ন ");
//        mAllQuestion.setId(1);
//        mAllQuestion.setQuestionArrayList(questionArrayList);
//
//        //2
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
//        mQuestion.setQues("2+5=?");
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
//        mQuestion.setQues("7+2=?");
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
////5
//        optionArrayList = new ArrayList<>();
//        mQuestion = new MQuestion();
//        mQuestion.setQues("8+2=?");
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
//        mAllQuestion = new MAllQuestion();
//        mAllQuestion.setType("বাংলা  প্রশ্ন ");
//        mAllQuestion.setId(1);
//        mAllQuestion.setQuestionArrayList(questionArrayList);
//
//
//    }

    public void addCheckbox(String text, final int id) {

        final CheckBox checkBox = new CheckBox(this);
        checkBox.setText(text);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTrue = true;
                btnNext.setBackgroundColor(0xff00ff00);
                if (CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(id).getTag() == 1) {
//                    CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(0).getOption().
                    correct++;
//                    checkBox.setBackgroundColor(Color.GREEN);
//                    layOption.getChildAt(0).setBackgroundColor(Color.GREEN);
//                    txtCount.setTextColor(0xff00ff00);
                    Toast.makeText(CheckBoxOptionActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
//                    txtCount.setTextColor(0xffff0000);
                    Toast.makeText(CheckBoxOptionActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i < layOption.getChildCount(); i++) {
                    layOption.getChildAt(i).setClickable(false);
                }
                txtCount.setText(correct + " : ");
                txtWrong.setText(wrong + "");
                if (checkBox.isChecked() && CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(id).getTag() == 1) {
//                    checkBox.setBackgroundColor(Color.GREEN);
                    checkBox.setTextColor(Color.GREEN);
                } else {

                    for (int i = 0; i < CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().size(); i++) {
                        if (CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(i).getTag() == 1) {
                            ((CheckBox) layOption.getChildAt(i)).setTextColor(Color.GREEN);
                        }
                    }
                    checkBox.setTextColor(Color.RED);
                }

            }
        });

//        if (pos > questionArrayList.size()) {
//            return;
//        }
        layOption.addView(checkBox);
    }

    public void change() {

        count--;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (count == -1) {
                    pos++;
                    wrong++;
                    Log.e("position"," is "+pos);
                    prepareDisplay();
                    for (int i = 0; i < layOption.getChildCount(); i++) {
                        layOption.getChildAt(i).setClickable(true);
                    }
                    count = 10;
                    txtWrong.setText(wrong + "");

                }
                txtOptionChanged.setText(count + "");
                if (pos >= CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().size()) {
                    Log.e("position"," if"+pos);
                    Log.e("position"," size"+ CheckBoxCategoryActivity.getInstance().allQuestionArrayList.get(index).getQuestionArrayList().size());
                    return;
                } else {
                    change();
                }




            }
        }, 500);

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
//            prepareOptionView();
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
//            if (questionArrayList.get(pos).getOptionArrayList().get(0).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (cId==101) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getOptionArrayList().get(1).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (cId==102) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getOptionArrayList().get(2).getTag() == 1) {
//                Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (cId==103) {
//            isTrue = true;
//            if (questionArrayList.get(pos).getOptionArrayList().get(3).getTag() == 1) {
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
