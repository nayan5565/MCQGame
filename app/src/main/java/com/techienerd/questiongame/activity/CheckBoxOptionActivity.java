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
    private TextView txtCount;
    private Button btnNext;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_system_activity);
        init();
        changeButtonColor();
        prepareDisplay();
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
        txtType.setText(CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getType());
        db = new DatabaseHelper(this);
        layOption = (LinearLayout) findViewById(R.id.layOption);
        handler = new Handler();

    }

    public void changeButtonColor() {
        if (!isTrue)
            btnNext.setBackgroundColor(0xffff0000);
    }

    public void prepareDisplay() {

        if (pos >= CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size()) {
            Log.e("step", "one");
            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(false);
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dia_game_over);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Button btnOk = (Button) dialog.findViewById(R.id.btnOK);
            final TextView txtMark = (TextView) dialog.findViewById(R.id.txtScore);
            TextView txtBestScore = (TextView) dialog.findViewById(R.id.txtBestScore);
            bestScore = db.getBestScores(parentId);
            int score = correct * (100 / CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size());
            if (score > bestScore) {
                bestScore = score;
                mScore.setParentId(Global.parentId);
                mScore.setBestScore(bestScore);

                db.addBestScore(mScore);
            }


            Log.e("score", "best " + bestScore);
            Log.e("score", "present " + score);

            txtMark.setText("Congratulation!Your score is " + score + " out of 100");
            txtBestScore.setText("Best score " + bestScore + "");
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finish();

                }
            });
            dialog.show();

            return;
        } else {
            Log.e("step", "two");
            txtQues.setText(CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getQues());
            layOption.removeAllViews();
            for (int i = 0; i < CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().size(); i++) {
                addCheckbox(CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(i).getOption(), i);
            }

        }
    }

    public void addCheckbox(String text, final int id) {

        final CheckBox checkBox = new CheckBox(this);
        checkBox.setText(text);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTrue = true;
                btnNext.setBackgroundColor(0xff00ff00);
                if (CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(id).getTag() == 1) {
                    correct++;
                    Toast.makeText(CheckBoxOptionActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(CheckBoxOptionActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i < layOption.getChildCount(); i++) {
                    layOption.getChildAt(i).setClickable(false);
                }
                txtCount.setText(correct + " : ");
                txtWrong.setText(wrong + "");
                if (checkBox.isChecked() && CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(id).getTag() == 1) {
                    checkBox.setTextColor(Color.GREEN);
                } else {

                    for (int i = 0; i < CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().size(); i++) {
                        if (CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(i).getTag() == 1) {
                            ((CheckBox) layOption.getChildAt(i)).setTextColor(Color.GREEN);
                        }
                    }
                    checkBox.setTextColor(Color.RED);
                }

            }
        });

        layOption.addView(checkBox);
    }

    public void change() {

        count--;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (count == -1) {
                    pos++;

                    Log.e("position"," is "+pos);
                    prepareDisplay();
                    for (int i = 0; i < layOption.getChildCount(); i++) {
                        layOption.getChildAt(i).setClickable(true);
                    }
                    if (!isTrue){
                        wrong++;
                    }
                    isTrue=false;
                    count = 10;
                    txtWrong.setText(wrong + "");

                }
                txtOptionChanged.setText(count + "");
                if (pos >= CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size()) {
                    Log.e("position"," if"+pos);
                    Log.e("position"," size"+ CheckBoxCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size());
                    return;
                } else {
                    change();
                }




            }
        }, 500);

    }


    @Override
    public void onClick(View v) {
        if (!isTrue)
            return;

        if (v.getId() == R.id.btnNext) {
            pos++;
            isTrue = false;
            prepareDisplay();
            for (int i = 0; i < layOption.getChildCount(); i++) {
                layOption.getChildAt(i).setClickable(true);
            }
            if (!isTrue)
                changeButtonColor();

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler=null;
        Log.e("destroy"," des");
    }
}
