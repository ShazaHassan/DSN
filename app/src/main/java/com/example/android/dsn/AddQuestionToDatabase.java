package com.example.android.dsn;

/**
 * Created by ShazaHassan on 14-May-17.
 */

public class AddQuestionToDatabase {
    private String IDQuestion, Question;

    public AddQuestionToDatabase(String IDQuestion, String question) {
        this.IDQuestion = IDQuestion;
        Question = question;
    }

    public void setIDQuestion(String IDQuestion) {
        this.IDQuestion = IDQuestion;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public AddQuestionToDatabase() {
    }

    public String getIDQuestion() {
        return IDQuestion;
    }

    public String getQuestion() {
        return Question;
    }
}
