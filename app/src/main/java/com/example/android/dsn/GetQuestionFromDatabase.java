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
        Button answer=(Button) listViewItem.findViewById(R.id.BAnswerDatabase);
        Button cancel=(Button) listViewItem.findViewById(R.id.BCancelDatabase);
        Button publishAnswer=(Button) listViewItem.findViewById(R.id.BAnswerDataBase);
        //EditText writeAnswer=(EditText) listViewItem.findViewById(R.id.ETWriteAnswerDatabase) ;
        important.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
       // writeAnswer.setVisibility(View.GONE);
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
        final Button answer=(Button) listViewItem.findViewById(R.id.BAnswerDatabase);
        final Button cancel=(Button) listViewItem.findViewById(R.id.BCancelDatabase);
        final Button publishAnswer=(Button) listViewItem.findViewById(R.id.BAnswerDataBase);
      /*  important.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);
        publishAnswer.setVisibility(View.GONE);
        writeAnswer.setVisibility(View.VISIBLE);
        final AddQuestionToDatabase addQuestionToDatabase=questionList.get(position);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                important.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.VISIBLE);
                publishAnswer.setVisibility(View.VISIBLE);
                writeAnswer.setVisibility(View.VISIBLE);
                answer.setVisibility(View.GONE);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setVisibility(View.VISIBLE);
                important.setVisibility(View.GONE);
                cancel.setVisibility(View.GONE);
                publishAnswer.setVisibility(View.GONE);
            }
        });

        publishAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Answer=writeAnswer.getText().toString();
                if(Answer.equals(""));
                else{
                    String ID=addQuestionToDatabase.getIDQuestion();
                    String Question=addQuestionToDatabase.getQuestion();
                    DatabaseReference questionDatabase=
                            FirebaseDatabase.getInstance().getReference("QuestionOfCh").child(ID);
                    DatabaseReference answerDatabase=FirebaseDatabase.getInstance().getReference("QuestionAndAnswer");
                    questionDatabase.setValue(null);
                    String IDQuestion=answerDatabase.push().getKey();
                    AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=new
                            AddAnswerAndQuestionToDatabase(IDQuestion,Question,Answer);
                    answerDatabase.child(IDQuestion).setValue(addAnswerAndQuestionToDatabase);
                    if(important.isChecked()){
                        DatabaseReference importantQuestion=FirebaseDatabase.getInstance().getReference("ImportantQuestion");
                        String IDImportant=importantQuestion.push().getKey();
                        importantQuestion.child(IDImportant).setValue(addAnswerAndQuestionToDatabase);
                    }
                }


            }
        });*/

        //set text in textView in which in template layout
        Question.setText(addQuestionToDatabase.getQuestion());
        return listViewItem;
    }
}
