package com.techienerd.questiongame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.techienerd.questiongame.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btnStartPlay = findViewById(R.id.btnStartPlay);
        btnStartPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStartPlay) {
            startActivity(new Intent(this, OptionActivity.class));

        }
    }
}
