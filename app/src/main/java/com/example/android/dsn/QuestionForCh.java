package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.id;

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

    public void answeredQuestions(View view) {
        Intent answersPage=new Intent(this,AnswerPage.class);
        TextView title=(TextView) findViewById(R.id.chapterNo);
        String ti=  title.getText().toString();
        answersPage.putExtra("titleOfCh",ti);
        startActivity(answersPage);
    }

    public void publishAnswer(View view) {
        TextView question=(TextView) findViewById(R.id.question);
        EditText writeAnswer= (EditText) findViewById(R.id.WriteAnswer);
        String Question=question.getText().toString();
        String answer=writeAnswer.getText().toString();
        Intent answerPage= new Intent(this,AnswerPage.class);
        answerPage.putExtra("question",Question);
        answerPage.putExtra("answer",answer);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.question1);
        ((LinearLayout) relativeLayout.getParent()).removeView(relativeLayout);
    }

    public void cancel(View view) {
        Button answerButton= (Button) findViewById(R.id.answerQuetions);
        EditText writeAnswer= (EditText) findViewById(R.id.WriteAnswer);
        Button publishAnswer= (Button) findViewById(R.id.publishAnsewr);
        Button cancel= (Button) findViewById(R.id.Cancel);
        answerButton.setVisibility(View.VISIBLE);
        writeAnswer.setText("");
        writeAnswer.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);
    }

    public void writeAnswer(View view) {
        Button answerButton= (Button) findViewById(R.id.answerQuetions);
        EditText writeAnswer= (EditText) findViewById(R.id.WriteAnswer);
        Button publishAnswer= (Button) findViewById(R.id.publishAnsewr);
        Button cancel= (Button) findViewById(R.id.Cancel);
        answerButton.setVisibility(View.GONE);
        writeAnswer.setVisibility(View.VISIBLE);
        publishAnswer.setVisibility(View.VISIBLE);
        cancel.setVisibility(View.VISIBLE);
    }
}
