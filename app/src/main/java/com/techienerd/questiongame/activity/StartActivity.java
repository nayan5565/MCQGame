package com.techienerd.questiongame.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartPlay;
    private TextView tvMarq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btnStartPlay = findViewById(R.id.btnStartPlay);
        tvMarq = findViewById(R.id.tvMarq);
        btnStartPlay.setOnClickListener(this);
//        tvMarq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
//        tvMarq.setSingleLine(true);
        tvMarq.setSelected(true);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStartPlay) {
            startActivity(new Intent(this, OptionActivity.class));

        }
    }
}
