package com.techienerd.questiongame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.utils.DatabaseHelper;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCheck, btnList, btnFavList, btnGet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        btnCheck = (Button) findViewById(R.id.btnTimeCheck);
        btnList = (Button) findViewById(R.id.btnListOption);
        btnFavList = (Button) findViewById(R.id.btnFavList);
        btnGet = (Button) findViewById(R.id.btnGET);
        btnGet.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnFavList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTimeCheck) {
            Intent intent = new Intent(this, CheckBoxCategoryActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnListOption) {
            Intent intent = new Intent(this, ListViewCategoryActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnFavList) {
            Intent intent = new Intent(this, FavListActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnGET) {
            Intent intent = new Intent(this, DataGetFavAcitivity.class);
            startActivity(intent);
        }
    }
}
