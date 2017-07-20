package com.techienerd.questiongame.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.ListViewOptionAdapter;
import com.techienerd.questiongame.model.MScore;
import com.techienerd.questiongame.utils.DatabaseHelper;
import com.techienerd.questiongame.utils.Global;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ListViewOptionActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    ListViewOptionAdapter adapter;
    Button btnNext;
    public TextView txtQues, txtResult;
    MScore mScore;
    DatabaseHelper db;
    public int parentId,stop;
    public int bestScore, pos, index, correct=0, wrong=0;
    private static ListViewOptionActivity instance;

    public static ListViewOptionActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_option);
        init();
        prepareDisplay();

    }

    public void init() {
        instance=this;
        Global.index=getIntent().getIntExtra("index",0);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
        adapter = new ListViewOptionAdapter(this);
        btnNext = (Button) findViewById(R.id.btnNx);
        btnNext.setBackgroundColor(Color.RED);
        btnNext.setOnClickListener(this);
        txtQues = (TextView) findViewById(R.id.txtQuestion);
        txtResult = (TextView) findViewById(R.id.txtResult);
        index = getIntent().getIntExtra("index", 0);
        Global.parentId = getIntent().getIntExtra("parentId", 0);
        parentId = Global.parentId;
        Log.e("id", " is " + parentId);
        mScore = new MScore();
        db = new DatabaseHelper(this);
    }

    public void colorChange(){
        if (stop==1){
            btnNext.setBackgroundColor(Color.GREEN);
        }
    }

    public void prepareDisplay() {
        if (pos >= ListViewCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size()) {
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
            int score =correct * (100 / ListViewCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size());
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
                    finish();
                }
            });
            dialog.show();

            return;
        } else {
            Log.e("step", "two");
            txtQues.setText(ListViewCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getQues());
            adapter.setData(ListViewCategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList());
            pos++;
        }

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        txtResult.setText(correct + " : " + wrong);

    }

    @Override
    public void onClick(View v) {

        if (stop==0)
            return;



        if (v.getId()==R.id.btnNx){
            Global.color=0;
            stop=0;
            btnNext.setBackgroundColor(Color.RED);
            prepareDisplay();
        }

    }
}
