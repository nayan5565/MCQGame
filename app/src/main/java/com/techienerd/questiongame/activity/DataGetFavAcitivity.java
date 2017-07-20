package com.techienerd.questiongame.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.FavAdapter;
import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.utils.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/20/2017.
 */
public class DataGetFavAcitivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MOption> optionArrayList;
    MOption mOption;
    DatabaseHelper db;
    FavAdapter favAdapter;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_option);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        optionArrayList = new ArrayList<>();
        mOption = new MOption();
        db = new DatabaseHelper(this);
        button = (Button) findViewById(R.id.btnStatisticsList);
        button.setVisibility(View.GONE);
        optionArrayList = db.getFavData();
        favAdapter = new FavAdapter(this);
        favAdapter.setData(optionArrayList);
        recyclerView.setAdapter(favAdapter);
    }
}
