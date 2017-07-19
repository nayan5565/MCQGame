package com.techienerd.questiongame.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.adapter.FavAdapter;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/20/2017.
 */
public class FavListActivity extends AppCompatActivity {
    private MOption mOption;
    private ArrayList<MOption> optionArrayList;
    RecyclerView recyclerView;
    FavAdapter favAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        init();
        generate();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recFav);
        favAdapter = new FavAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void generate() {

        optionArrayList = new ArrayList<>();
        mOption = new MOption();

        mOption.setOption("2");


        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("8");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("4");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("10");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("9");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("5");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("11");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("9");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("7");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("5");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("12");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("5");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("6");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("9");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("10");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("16");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("12");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("11");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("10");

        optionArrayList.add(mOption);
        Log.e("favlist", " size " + optionArrayList.size());
        favAdapter.setData(optionArrayList);
        recyclerView.setAdapter(favAdapter);
    }
}
