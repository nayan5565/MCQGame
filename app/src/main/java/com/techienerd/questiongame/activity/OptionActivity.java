package com.techienerd.questiongame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.techienerd.questiongame.R;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEasy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btnEasy = findViewById(R.id.btnEasy);
        btnEasy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEasy) {
            startActivity(new Intent(this, ListViewCategoryActivity.class));
            finish();
        }
    }
}
