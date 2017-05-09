package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
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
import static com.example.android.dsn.R.id.writeQuestion;

public class QuestionForCh extends AppCompatActivity {
    private static boolean pushQuestion;
    private static String Question, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        Intent intent = getIntent();
        String chNo = intent.getStringExtra("no");//take the number  of ch
        TextView title = (TextView) findViewById(R.id.chapterNo);
        title.setText(chNo);//set the title of the page by the number of the ch
    }

    public void answeredQuestions(View view) {
        Intent answersPage = new Intent(this, AnswerPage.class);
        TextView title = (TextView) findViewById(R.id.chapterNo);
        String ti = title.getText().toString();
        answersPage.putExtra("titleOfCh", ti);
        startActivity(answersPage);
    }

   /* public void publishAnswer(View view) {
        TextView question = (TextView) findViewById(R.id.question);
        EditText writeAnswer = (EditText) findViewById(R.id.WriteAnswer);
        Question = question.getText().toString();
        answer = writeAnswer.getText().toString();
        if(answer.equals(""))
            cancel(view);
        else {
            push = true;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.question1);
            ((LinearLayout) relativeLayout.getParent()).removeView(relativeLayout);
        }

    }*/

   public static boolean isPush() {
        return pushQuestion;
    }

   public static String getQuestion() {
        return Question;
    }

    /*public static String getAnswer() {
        return answer;
    }*/

   /* public void cancel(View view) {
        Button answerButton = (Button) findViewById(R.id.answerQuetions);
        EditText writeAnswer = (EditText) findViewById(R.id.WriteAnswer);
        Button publishAnswer = (Button) findViewById(R.id.publishAnsewr);
        Button cancel = (Button) findViewById(R.id.Cancel);
        answerButton.setVisibility(View.VISIBLE);
        writeAnswer.setText("");
        writeAnswer.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);
    }*/

    /*public void writeAnswer(View view) {
        Button answerButton = (Button) findViewById(R.id.answerQuetions);
        EditText writeAnswer = (EditText) findViewById(R.id.WriteAnswer);
        Button publishAnswer = (Button) findViewById(R.id.publishAnsewr);
        Button cancel = (Button) findViewById(R.id.Cancel);
        answerButton.setVisibility(View.GONE);
        writeAnswer.setVisibility(View.VISIBLE);
        publishAnswer.setVisibility(View.VISIBLE);
        cancel.setVisibility(View.VISIBLE);
    }*/

    public void askQuestion(View view) {
        int count=0;
        EditText writeQuestion= (EditText) findViewById(R.id.writeQuestion);
        Question= writeQuestion.getText().toString();//get Question from edit text
        TextView question= new TextView(this);
        LinearLayout askedQuestion= (LinearLayout) findViewById(R.id.askedQuestion);
        LinearLayout.LayoutParams attributeForQuestion=
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //add attribute for text view
        question.setLayoutParams(attributeForQuestion);
        if(question.equals(""));
        else
        {
            count++;
            writeQuestion.setText("");
            pushQuestion=true;
            question.setTextSize(20);
            question.setTextColor(Color.BLACK);
            question.setText("Question"+count+": "+question);
            askedQuestion.addView(question);
        }
    }
}
