package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mariam on 9-May-17.
 *
 */

public class QuestionForChStudent extends AppCompatActivity {
    private static boolean pushQuestion;
    private static String Question;
   private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        Intent intent = getIntent();
        String chNo = intent.getStringExtra("no");//take the number  of ch
        TextView title = (TextView) findViewById(R.id.TvchapterNo);
        title.setText(chNo);//set the title of the page by the number of the ch
    }

    public void answeredQuestions(View view) {
        Intent answersPage = new Intent(this, AnswerPage.class);
        TextView title = (TextView) findViewById(R.id.TvchapterNo);
        String ti = title.getText().toString();
        answersPage.putExtra("titleOfCh", ti);
        startActivity(answersPage);
    }

    public void askQuestion(View view) {

        EditText writeQuestion= (EditText) findViewById(R.id.ETwriteQuestion);
        Question= writeQuestion.getText().toString();//get Question from edit text
        TextView question= new TextView(this);
        View view1 =new View(this);
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the size of line which separate between posts
        view1.setBackgroundColor(Color.GRAY);

        LinearLayout askedQuestion= (LinearLayout) findViewById(R.id.LaskedQuestion);
        LinearLayout.LayoutParams attributeForQuestion=
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //add attribute for text view
        question.setLayoutParams(attributeForQuestion);
        if(Question.equals(""));
        else
        {
            count++;
            writeQuestion.setText("");
            question.setTextSize(20);
            question.setTextColor(Color.BLACK);
            question.setText("Question"+count+": "+Question);
            pushQuestion=true;
            askedQuestion.addView(question);
            askedQuestion.addView(view1);//add line to separate between Questions

        }
    }

    public boolean isPushQuestion() {
        return pushQuestion;
    }

    public String getQuestion() {
        return Question;
    }

    public void ImportantQuestion(View view) {
        Intent important=new Intent(this,ImpotantQuestion.class);
        startActivity(important);
    }
}
