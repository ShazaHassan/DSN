package com.example.android.dsn;

/**
 * Created by ShazaHassan on 15-May-17.
 */

public class AddAnswerAndQuestionToDatabase {
    private  String IDQuestion,Question,Answer;

    public AddAnswerAndQuestionToDatabase(String IDQuestion, String question, String answer) {
        this.IDQuestion = IDQuestion;
        Question = question;
        Answer = answer;

    }

    public AddAnswerAndQuestionToDatabase() {
    }

    public String getIDQuestion() {
        return IDQuestion;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setIDQuestion(String IDQuestion) {
        this.IDQuestion = IDQuestion;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
