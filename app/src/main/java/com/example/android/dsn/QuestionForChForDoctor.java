package com.example.android.dsn;

import android.content.Intent;
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
    private static String Answer, Question;
    private static boolean push = false, Important = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        //set the title of the page by the number of the ch
        RelativeLayout r = (RelativeLayout) findViewById(R.id.R1);
        r.setVisibility(View.GONE);
        QuestionForCh questionForCh = new QuestionForCh();
        if (questionForCh.isPushQuestion()) {
            String question = questionForCh.getQuestion();
            AnswerAndQuestion(question);

        }

    }

    private void AnswerAndQuestion(String question) {
        //definition id for elements
        int IDQuestion = 0, IDButtonAnswer = 100 + IDQuestion, IDImportant = 200 + IDQuestion, IDWriteAnswer = 300 + IDQuestion, IDCancel = 400 + IDQuestion, IDPublishAnswer = 500 + IDQuestion, IDMainPage = 600 + IDQuestion, IDAnswerText = 700 + IDQuestion;

        TextView writeQuestion = new TextView(this);
        Button Answer = new Button(this);
        CheckBox important = new CheckBox(this);
        EditText writeAnswer = new EditText(this);
        Button publishAnswer = new Button(this);
        Button cancel = new Button(this);
        TextView answer = new TextView(this);
        final RelativeLayout questionWithAnswer = new RelativeLayout(this);

        // change id
        IDQuestion++;
        IDButtonAnswer++;
        IDImportant++;
        IDWriteAnswer++;
        IDCancel++;
        IDPublishAnswer++;
        IDMainPage++;

        //set id for element
        writeQuestion.setId(IDQuestion);
        Answer.setId(IDButtonAnswer);
        important.setId(IDImportant);
        writeAnswer.setId(IDWriteAnswer);
        publishAnswer.setId(IDPublishAnswer);
        cancel.setId(IDCancel);
        questionWithAnswer.setId(IDMainPage);

        //put element in page
        int count = 1;
        LinearLayout page = (LinearLayout) findViewById(R.id.LaskedQuestion);
        RelativeLayout.LayoutParams attributeForRelative = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        questionWithAnswer.setLayoutParams(attributeForRelative);
        page.addView(questionWithAnswer);
        writeQuestion.setText("Question " + count + ": " + question);
        writeQuestion.setTextColor(Color.BLACK);
        writeQuestion.setTextSize(20);
        writeQuestion.setLayoutParams(attributeForRelative);
        Question = writeQuestion.getText().toString();
        //button answer
        EditAnswerButton(Answer, IDQuestion);
        // check box
        EditCheckBox(important, IDQuestion);

        //write answer
        EditWriteAnswer(writeAnswer, IDImportant);

        //button for publish answer
        EditPublishAnswer(publishAnswer, IDWriteAnswer);

        //button for cancel
        EditCancelButton(cancel, IDWriteAnswer);

        //answer textView
        EditTextViewOfAnswer(answer, IDImportant);
        ///add elements to relative layout
        questionWithAnswer.addView(writeQuestion);
        questionWithAnswer.addView(Answer);
        questionWithAnswer.addView(important);
        questionWithAnswer.addView(writeAnswer);
        questionWithAnswer.addView(publishAnswer);
        questionWithAnswer.addView(cancel);
        questionWithAnswer.addView(answer);

        //hiden not used element
        writeAnswer.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);

        //action for buttons
        setActionOfAnswerButton(Answer, writeAnswer, publishAnswer, cancel);
        setActionOfpublishAnswer(publishAnswer, writeAnswer, answer, cancel, Answer, questionWithAnswer,important);
        setActionofCancel(cancel, publishAnswer, writeAnswer, Answer);
    }

    private void setActionOfAnswerButton(final View AnswerButton, final View writeAnswer, final View publishAnswer, final View cancel) {
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

    private void setActionOfpublishAnswer(final Button publishAnswer, final EditText writeAnswer, final TextView answer,
                                          final Button cancel, final Button AnswerButton, final RelativeLayout questionAndAnswer,
                                          final CheckBox important) {
        publishAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer = writeAnswer.getText().toString();

                if (Answer.equals("")) {
                    cancel.setVisibility(View.GONE);
                    publishAnswer.setVisibility(View.GONE);
                    writeAnswer.setVisibility(View.GONE);
                    AnswerButton.setVisibility(View.VISIBLE);
                } else {
                    answer.setText(Answer);
                    answer.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.GONE);
                    publishAnswer.setVisibility(View.GONE);
                    writeAnswer.setVisibility(View.GONE);
                    push = true;
                    ((LinearLayout) questionAndAnswer.getParent()).removeView(questionAndAnswer);
                    if(important.isChecked()){
                        Important=true;
                    }
                }
            }
        });
    }

    private void setActionofCancel(final Button cancel, final Button publishAnswer, final EditText writeAnswer, final Button Answer) {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel.setVisibility(View.GONE);
                publishAnswer.setVisibility(View.GONE);
                writeAnswer.setVisibility(View.GONE);
                Answer.setVisibility(View.VISIBLE);
            }
        });
    }

    private void EditAnswerButton(Button Answer, int ID) {
        RelativeLayout.LayoutParams attributeForButtonAnswer = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForButtonAnswer.addRule(RelativeLayout.BELOW, ID);
        attributeForButtonAnswer.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        Answer.setLayoutParams(attributeForButtonAnswer);
        Answer.setText("Answer");
    }

    private void EditPublishAnswer(Button publishAnswer, int ID) {
        RelativeLayout.LayoutParams attributeForButtonPublishAnswer = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForButtonPublishAnswer.addRule(RelativeLayout.BELOW, ID);
        attributeForButtonPublishAnswer.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        publishAnswer.setLayoutParams(attributeForButtonPublishAnswer);
        publishAnswer.setText("Answer");

    }

    private void EditCancelButton(Button cancel, int ID) {
        RelativeLayout.LayoutParams attributeForButtonCancel = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForButtonCancel.addRule(BELOW, ID);
        attributeForButtonCancel.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        cancel.setLayoutParams(attributeForButtonCancel);
        cancel.setText("Cancel");

    }

    private void EditWriteAnswer(EditText writeAnswer, int ID) {
        RelativeLayout.LayoutParams attributeForEditText = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForEditText.addRule(BELOW, ID);
        writeAnswer.setLayoutParams(attributeForEditText);
    }

    private void EditTextViewOfAnswer(TextView answer, int ID) {
        RelativeLayout.LayoutParams attributeForAnswerTextView = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForAnswerTextView.addRule(BELOW, ID);
        answer.setTextColor(Color.BLUE);
        answer.setTextSize(20);
        answer.setLayoutParams(attributeForAnswerTextView);
    }

    private void EditCheckBox(CheckBox important, int ID) {
        RelativeLayout.LayoutParams attributeForImportant = new
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        attributeForImportant.addRule(BELOW, ID);
        attributeForImportant.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        important.setText("important");
        important.setLayoutParams(attributeForImportant);
    }

    public void answeredQuestions(View view) {
        Intent answerPage = new Intent(this, AnswerPage.class);
        startActivity(answerPage);
    }

    public String getAnswer() {
        return Answer;
    }

    public String getQuestion() {
        return Question;
    }

    public boolean isPush() {
        return push;
    }

    public boolean isImportant() {
        return Important;
    }

    public void ImportantQuestion(View view) {
        Intent important=new Intent(this,ImpotantQuestion.class);
        startActivity(important);
    }
}
