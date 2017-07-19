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

        mOption.setOption("Nayan");


        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("Jewel");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Sohel");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Jarif");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Miraz");


        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Monir");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Musa");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Kafi");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Arafat");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Tanjil");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Sajib");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Rubel");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Miran");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Maruf");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Sumon");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Rauf");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Jahid");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Sariful");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Mamun");

        optionArrayList.add(mOption);

        mOption = new MOption();

        mOption.setOption("Milon");

        optionArrayList.add(mOption);
        Log.e("favlist", " size " + optionArrayList.size());
        favAdapter.setData(optionArrayList);
        recyclerView.setAdapter(favAdapter);
    }
}
