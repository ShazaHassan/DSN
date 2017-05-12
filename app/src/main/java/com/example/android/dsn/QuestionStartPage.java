package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionStartPage extends AppCompatActivity {

    private  int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_start_page);
        Intent intent=getIntent();
        TextView quTitle= (TextView) findViewById(R.id.TvquestionTitle);
        String ti=intent.getStringExtra("sub");
        quTitle.setText(ti);
    }

    public void addChapter(View view) {
       count++;
        LinearLayout button=(LinearLayout) findViewById(R.id.buttons);
        LinearLayout.LayoutParams params= new
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);
        button.setBaselineAligned(true);
        final Button chapterNo= new Button(this);
        chapterNo.setLayoutParams(new WindowManager.LayoutParams());
        chapterNo.setText("chapter "+count+"");
        button.addView(chapterNo,params);
        chapterNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent page=new Intent(QuestionStartPage.this,QuestionForChStudent.class);
                String ch=chapterNo.getText().toString();
                page.putExtra("no",ch);
                startActivity(page);
            }
        });
    }
}
