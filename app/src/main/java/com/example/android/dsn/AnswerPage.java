package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnswerPage extends AppCompatActivity {
    private int countQuestion = 0, countAnswer = 100 + countQuestion;
    private static boolean Important;
    LinearLayout page ;
    RelativeLayout questionWithAnswer ;
    TextView question ;
    TextView answer ;
    CheckBox important ;
    String Question ;
    String Answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);
        Intent intent = getIntent();
        String chNo = intent.getStringExtra("titleOfCh");
        TextView title = (TextView) findViewById(R.id.titleOfAnswer);
        title.setText("Answer of " + chNo);
        page = (LinearLayout) findViewById(R.id.answerTheQuestionforChapter);
        questionWithAnswer = new RelativeLayout(this);
        question = new TextView(this);//create textView to put Question in it
        answer = new TextView(this);//create textView to put Answer in it
        important = new CheckBox(this);//create check box to see if Question is important or not
       QuestionForChForDoctor questionForCh = new QuestionForChForDoctor();

      /*  if (questionForCh.isPush())
        {
            Question = questionForCh.getQuestion();//get string that pass from activity QuestionForChStudent (Question)
            Answer = questionForCh.getAnswer();//get string that pass from activity QuestionForChStudent (Answer)
            write( Question,Answer);

        }
        checkBox();*/

    }

    public void write( String Question,String Answer) {
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

    private void checkBox(){
        important.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(important.isChecked())
                {
                    Important=true;
                    important.setVisibility(View.GONE);
                }
            }
        });
    }

    public boolean isImportant() {
        return Important;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }
}
