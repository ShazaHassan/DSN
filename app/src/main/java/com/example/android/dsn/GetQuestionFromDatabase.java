package com.example.android.dsn;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static android.R.string.cancel;

/**
 * Created by ShazaHassan on 15-May-17.
 */

//show theQuestion in page of student
public class GetQuestionFromDatabase extends ArrayAdapter<AddQuestionToDatabase> {
    private Activity context;
    private List<AddQuestionToDatabase> questionList;
    public GetQuestionFromDatabase (Activity context,List<AddQuestionToDatabase> questionList){
        super(context,R.layout.question_for_database,questionList);
        this.context=context;
        this.questionList=questionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.question_for_database,null,true); //take the layout of post for database as template for each element will show

        TextView Question= (TextView) listViewItem.findViewById(R.id.TVQuestionFromDatabase);
        CheckBox important=(CheckBox) listViewItem.findViewById(R.id.CBImportant);
        Button publishAnswer=(Button) listViewItem.findViewById(R.id.BAnswerDataBase);
        EditText writeAnswer=(EditText) listViewItem.findViewById(R.id.ETWriteAnswerDatabase) ;
        important.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
        writeAnswer.setVisibility(View.GONE);
        //set text in textView in which in template layout
        AddQuestionToDatabase addQuestionToDatabase=questionList.get(position);
        Question.setText(addQuestionToDatabase.getQuestion());
        return listViewItem;
    }
}








//show the question on the page of dr
class GetQuestionFromDatabaseForDr extends ArrayAdapter<AddQuestionToDatabase> {
    private Activity context;
    private List<AddQuestionToDatabase> questionList;

    public GetQuestionFromDatabaseForDr (Activity context,List<AddQuestionToDatabase> questionList){
        super(context,R.layout.question_for_database,questionList);
        this.context=context;
        this.questionList=questionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.question_for_database,null,true); //take the layout of post for database as template for each element will show
        final AddQuestionToDatabase addQuestionToDatabase=questionList.get(position);
        TextView Question= (TextView) listViewItem.findViewById(R.id.TVQuestionFromDatabase);
        final CheckBox important=(CheckBox) listViewItem.findViewById(R.id.CBImportant);
        final Button publishAnswer=(Button) listViewItem.findViewById(R.id.BAnswerDataBase);
        final EditText writeAnswer=(EditText) listViewItem.findViewById(R.id.ETWriteAnswerDatabase) ;
        publishAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get answer that has been written
                String Answer=writeAnswer.getText().toString();
                //check if answer is empty or null
                if(Answer.equals(""));
                else{
                    //get id of Question that will be answer
                    String ID=addQuestionToDatabase.getIDQuestion();
                    //get question
                    String Question=addQuestionToDatabase.getQuestion();
                    //select table that will connect with it
                    DatabaseReference questionDatabase=
                            FirebaseDatabase.getInstance().getReference("QuestionOfCh").child(ID);

                    //delete selected value
                    questionDatabase.setValue(null);
                    //store impotant question in important database
                    important.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    if(important.isChecked()){

                        DatabaseReference importantQuestion=FirebaseDatabase.getInstance().getReference("ImportantQuestion");
                        String IDImportant=importantQuestion.push().getKey();
                        AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=new
                                AddAnswerAndQuestionToDatabase();
                        addAnswerAndQuestionToDatabase.setIDQuestion(IDImportant);
                        addAnswerAndQuestionToDatabase.setQuestion(Question);
                        addAnswerAndQuestionToDatabase.setAnswer(Answer);
                        importantQuestion.child(IDImportant).setValue(addAnswerAndQuestionToDatabase);
                    }else {
                        //store general answer in answer database
                        DatabaseReference answerDatabase=FirebaseDatabase.getInstance().getReference("QuestionAndAnswer");
                        String IDQuestion=answerDatabase.push().getKey();
                        AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=new
                                AddAnswerAndQuestionToDatabase();
                        addAnswerAndQuestionToDatabase.setIDQuestion(IDQuestion);
                        addAnswerAndQuestionToDatabase.setQuestion("Question: "+Question);
                        addAnswerAndQuestionToDatabase.setAnswer("Answer: "+Answer);

                        answerDatabase.child(IDQuestion).setValue(addAnswerAndQuestionToDatabase);
                    }
                }


            }
        });

        //set text in textView in which in template layout
        Question.setText(addQuestionToDatabase.getQuestion());
        return listViewItem;
    }
}