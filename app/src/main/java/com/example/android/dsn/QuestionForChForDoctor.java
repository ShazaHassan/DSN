package com.example.android.dsn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.widget.RelativeLayout.BELOW;

/**
 * Created by Shaza Hassan on 09-May-17.
 */

public class QuestionForChForDoctor extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        //set the title of the page by the number of the ch
        AnswerAndQuestion();

    }
    private void AnswerAndQuestion(){
         int IDQuestion=0,IDButtonAnswer=100+IDQuestion,IDImportant=200+IDQuestion,IDWriteAnswer=300+IDQuestion
                ,IDCancel=400+IDQuestion,IDPublishAnswer=500+IDQuestion,IDMainPage=600+IDQuestion;
         TextView writeQuestion= new TextView(this);
         Button Answer =new Button(this);
         CheckBox important= new CheckBox(this);
         EditText writeAnswer= new EditText(this);
         Button publishAnswer=new Button(this);
         Button cancel=new Button(this);
         final RelativeLayout questionWithAnswer= new RelativeLayout(this);
        //
        IDQuestion++;
        IDButtonAnswer++;
        IDImportant++;
        IDWriteAnswer++;
        IDCancel++;
        IDPublishAnswer++;
        IDMainPage++;
        //
        writeQuestion.setId(IDQuestion);
        Answer.setId(IDButtonAnswer);
        important.setId(IDImportant);
        writeAnswer.setId(IDWriteAnswer);
        publishAnswer.setId(IDPublishAnswer);
        cancel.setId(IDCancel);
        questionWithAnswer.setId(IDMainPage);
        int count=1;
        LinearLayout page = (LinearLayout) findViewById(R.id.LaskedQuestion);
        RelativeLayout.LayoutParams attributeForRelative=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        questionWithAnswer.setLayoutParams(attributeForRelative);
        page.addView(questionWithAnswer);
        writeQuestion.setText("Question "+count+": ");
        writeQuestion.setTextColor(Color.BLACK);
        writeQuestion.setTextSize(20);
        writeQuestion.setLayoutParams(attributeForRelative);

        //button answer
        RelativeLayout.LayoutParams attributeForButtonAnswer=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForButtonAnswer.addRule(RelativeLayout.BELOW,IDQuestion);
        attributeForButtonAnswer.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        Answer.setLayoutParams(attributeForButtonAnswer);
        Answer.setText("B1");
        // check box
        RelativeLayout.LayoutParams attributeForImportant=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForImportant.addRule(BELOW,IDQuestion);
        attributeForImportant.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        important.setText("important");
        important.setLayoutParams(attributeForImportant);
        //write answer
        RelativeLayout.LayoutParams attributeForEditText=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForEditText.addRule(BELOW,IDImportant);
        //writeAnswer.setVisibility(View.GONE);
        writeAnswer.setLayoutParams(attributeForEditText);
        //button for publish answer
        RelativeLayout.LayoutParams attributeForButtonPublishAnswer=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForButtonPublishAnswer.addRule(RelativeLayout.BELOW,IDWriteAnswer);
        attributeForButtonPublishAnswer.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        publishAnswer.setLayoutParams(attributeForButtonPublishAnswer);
        //button for cancel
        RelativeLayout.LayoutParams attributeForButtonCancel=new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForButtonCancel.addRule(BELOW,IDWriteAnswer);
        attributeForButtonCancel.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        cancel.setLayoutParams(attributeForButtonCancel);
        ///add elements to relative layout
        Answer.setText("Answer");
        publishAnswer.setText("Answer");
        cancel.setText("Canel");
        questionWithAnswer.addView(writeQuestion,0);
        questionWithAnswer.addView(Answer,1);
        questionWithAnswer.addView(important,2);
        questionWithAnswer.addView(writeAnswer,3);
        questionWithAnswer.addView(publishAnswer,4);
        questionWithAnswer.addView(cancel,5);
        writeAnswer.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);


        setActionOfAnswerButton(Answer,writeAnswer,publishAnswer,cancel);
        publishAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
    private void setActionOfAnswerButton(final View AnswerButton, final View writeAnswer, final View publishAnswer, final View cancel ){
        AnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeAnswer.setVisibility(View.VISIBLE);
                publishAnswer.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.VISIBLE);
                AnswerButton.setVisibility(View.GONE);
            }
        });
    }


   /* private void updateId(){
        IDQuestion++;
        IDButtonAnswer++;
        IDImportant++;
        IDWriteAnswer++;
        IDCancel++;
        IDPublishAnswer++;
        IDMainPage++;
    }
    private void setID(){
        writeQuestion.setId(IDQuestion);
        Answer.setId(IDButtonAnswer);
        important.setId(IDImportant);
        writeAnswer.setId(IDWriteAnswer);
        publishAnswer.setId(IDPublishAnswer);
        cancel.setId(IDCancel);
        questionWithAnswer.setId(IDMainPage);
    }*/

}
