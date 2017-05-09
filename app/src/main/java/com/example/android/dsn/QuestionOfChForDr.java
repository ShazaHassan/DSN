package com.example.android.dsn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Shaza Hassan on 09-May-17.
 */

public class QuestionOfChForDr extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        /*Intent intent = getIntent();
        String chNo = intent.getStringExtra("no");//take the number  of ch
        TextView title = (TextView) findViewById(R.id.chapterNo);
        title.setText(chNo);//set the title of the page by the number of the ch*/
    }

}
