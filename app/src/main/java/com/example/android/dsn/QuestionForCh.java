package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuestionForCh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        Intent intent=getIntent();
        String chNo=intent.getStringExtra("no");
        TextView title=(TextView) findViewById(R.id.chapterNo);
        title.setText(chNo);
    }
}
