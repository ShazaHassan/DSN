package com.example.android.dsn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ImpotantQuestion extends AppCompatActivity {

    private int countQuestion = 0, countAnswer = 100 + countQuestion;
    LinearLayout page ;
    RelativeLayout questionWithAnswer ;
    TextView question ;
    TextView answer ;
    private  String Answer,Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impotant_question);
        questionWithAnswer = new RelativeLayout(this);
        page = (LinearLayout) findViewById(R.id.LImportantQuestion);
        question = new TextView(this);//create textView to put Question in it
        answer = new TextView(this);//create textView to put Answer in it
        QuestionForChForDoctor questionForChForDoctor=new QuestionForChForDoctor();
        AnswerPage answerPage= new AnswerPage();
        if(answerPage.isImportant()){
            Answer=answerPage.getAnswer();
            Question=answerPage.getQuestion();
            write();
        }
        if (questionForChForDoctor.isImportant()){
            Answer=questionForChForDoctor.getAnswer();
            Question=questionForChForDoctor.getQuestion();
            write();
        }
    }
    public void write( ) {
        countQuestion++;
        countAnswer++;
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
        question.setText(Question);
        answer.setText(Answer);
        answer.setLayoutParams(answerAttribute);//add attribute to textView of answer
        RelativeLayout.LayoutParams checkAttribute = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //to set attribute for check box
        checkAttribute.addRule(RelativeLayout.BELOW, countAnswer);//check under answer
        checkAttribute.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);// check at right of page
        questionWithAnswer.addView(question, 0);
        questionWithAnswer.addView(answer, 1);
    }
}
