package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.dsn.QuestionForCh;

public class AnswerPage extends AppCompatActivity {
    private int countQuestion = 0, countAnswer = 100 + countQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);
        Intent intent = getIntent();
        String chNo = intent.getStringExtra("titleOfCh");
        TextView title = (TextView) findViewById(R.id.titleOfAnswer);
        title.setText("Answer of " + chNo);
        QuestionForCh questionForCh = new QuestionForCh();

        if (questionForCh.isPush())
        {
            String Question = questionForCh.getQuestion();//get string that pass from activity QuestionForCh (Question)
            String Answer = questionForCh.getAnswer();//get string that pass from activity QuestionForCh (Answer)
            write( Question,Answer);

        }

    }

    public void write( String Question,String Answer) {
        countQuestion++;
        countAnswer++;

        LinearLayout page = (LinearLayout) findViewById(R.id.answerTheQuestionforChapter);
        RelativeLayout questionWithAnswer = new RelativeLayout(this);
        TextView question = new TextView(this);//create textView to put Question in it
        TextView answer = new TextView(this);//create textView to put Answer in it
        CheckBox important = new CheckBox(this);//create check box to see if Question is important or not
        RelativeLayout.LayoutParams relativeAttribute = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //to set attribute for relative layout
        question.setId(countQuestion);//set id for question
        answer.setId(countAnswer);//set id for answer
        questionWithAnswer.setLayoutParams(relativeAttribute);//set height and width for relative layout
        question.setLayoutParams(relativeAttribute);//set height and width as relative layout
        page.addView(questionWithAnswer);//add relative layout to page
        RelativeLayout.LayoutParams answerAttribute = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //to set attribute for answer
        answerAttribute.addRule(RelativeLayout.BELOW, countQuestion);//add answer below the question
        answer.setTextColor(Color.BLUE);
        answer.setTextSize(20);
        question.setTextColor(Color.BLACK);
        question.setTextSize(20);
        question.setText("Question "+countQuestion+": "+Question);
        answer.setText("Answer: "+Answer);
        answer.setLayoutParams(answerAttribute);//add attribute to textView of answer
        RelativeLayout.LayoutParams checkAttribute = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //to set attribute for check box
        important.setText("Important");
        checkAttribute.addRule(RelativeLayout.BELOW, countAnswer);//check under answer
        checkAttribute.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);// check at right of page
        important.setLayoutParams(checkAttribute);//add attribute to check box
        questionWithAnswer.addView(question, 0);
        questionWithAnswer.addView(answer, 1);
        questionWithAnswer.addView(important, 2);
    }
}
