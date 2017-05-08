package com.example.android.dsn;

import android.content.Intent;
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
    private int countQuestion=0,count=100+countQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);
        Intent intent=getIntent();
        String chNo=intent.getStringExtra("titleOfCh");
        TextView title= (TextView) findViewById(R.id.titleOfAnswer);
        title.setText("Answer of "+chNo);
        /*Button answer =(Button) findViewById(R.id.answerQuetions);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countQuestion++;
                count++;
                RelativeLayout questionWithAnswer= new RelativeLayout(this);
                TextView question= new TextView(this);
                TextView answer=new TextView(this);
                CheckBox important= new CheckBox(this);
                RelativeLayout.LayoutParams relativeAttribute=new
                        RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //to set attribute for relative layout
                question.setId(countQuestion);//set id for question
                answer.setId(count);//set id for answer
                questionWithAnswer.setLayoutParams(relativeAttribute);//set height and width for relative layout
                question.setLayoutParams(relativeAttribute);//set height and width as relative layout
                RelativeLayout.LayoutParams answerAttribute=new
                        RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //to set attribute for answer
                answerAttribute.addRule(RelativeLayout.BELOW,countQuestion);//add answer below the question
                answer.setText("jjjjj");
                question.setText("ggggg");
                answer.setLayoutParams(answerAttribute);//add attribute to textView of answer
                RelativeLayout.LayoutParams checkAttribute=new
                        RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //to set attribute for check box
                important.setText("Important");
                checkAttribute.addRule(RelativeLayout.BELOW,count);//check under answer
                checkAttribute.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);// check at right of page
                important.setLayoutParams(checkAttribute);//add attribute to check box
                questionWithAnswer.addView(question,0);
                questionWithAnswer.addView(answer,1);
                questionWithAnswer.addView(important,2);

            }
        });*/
    }

   /* public void publishAnswer(View view) {
        countQuestion++;
        count++;
        LinearLayout page=(LinearLayout) findViewById(R.id.answerTheQuestionforChapter) ;
       /* RelativeLayout questionWithAnswer= new RelativeLayout(this);
        TextView question= new TextView(this);
        TextView answer=new TextView(this);
        CheckBox important= new CheckBox(this);
        RelativeLayout.LayoutParams relativeAttribute=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //to set attribute for relative layout
        question.setId(countQuestion);//set id for question
        answer.setId(count);//set id for answer
        questionWithAnswer.setLayoutParams(relativeAttribute);//set height and width for relative layout
        question.setLayoutParams(relativeAttribute);//set height and width as relative layout
        page.addView(questionWithAnswer);
        RelativeLayout.LayoutParams answerAttribute=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //to set attribute for answer
        answerAttribute.addRule(RelativeLayout.BELOW,countQuestion);//add answer below the question
        answer.setText("jjjjj");
        question.setText("ggggg");
        answer.setLayoutParams(answerAttribute);//add attribute to textView of answer
        RelativeLayout.LayoutParams checkAttribute=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //to set attribute for check box
        important.setText("Important");
        checkAttribute.addRule(RelativeLayout.BELOW,count);//check under answer
        checkAttribute.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);// check at right of page
        important.setLayoutParams(checkAttribute);//add attribute to check box
        questionWithAnswer.addView(question,0);
        questionWithAnswer.addView(answer,1);
        questionWithAnswer.addView(important,2);
       Button hi=new Button(this);
        hi.setText("hu");
        page.addView(hi);

    }*/
}
