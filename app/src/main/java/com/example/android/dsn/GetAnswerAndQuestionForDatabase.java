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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static android.os.Build.ID;
import static com.example.android.dsn.R.id.delete;

/**
 * Created by Mariam on 15-May-17.
 */

public class GetAnswerAndQuestionForDatabase extends ArrayAdapter<AddAnswerAndQuestionToDatabase> {
    private Activity context;
    private List<AddAnswerAndQuestionToDatabase> answerAndQuestionList;

    public GetAnswerAndQuestionForDatabase(Activity context, List<AddAnswerAndQuestionToDatabase> answerAndQuestionList) {
        super(context, R.layout.answer_and_important_for_database, answerAndQuestionList);
        this.context = context;
        this.answerAndQuestionList = answerAndQuestionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        //make the elements that put in list view like the elements in layout that called
        View listViewItem = inflater.inflate(R.layout.answer_and_important_for_database, null, true);

        AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=answerAndQuestionList.get(position);
        //get textView in layout to set text
        TextView Question=(TextView) listViewItem.findViewById(R.id.TVQuestionWasAnsweredDatabase);
        TextView Answer=(TextView) listViewItem.findViewById(R.id.TVAnsweredOfQuestionForDatabase);

        //set Text in TextView as that stored in database
        Question.setText(addAnswerAndQuestionToDatabase.getQuestion());
        Answer.setText(addAnswerAndQuestionToDatabase.getAnswer());

        //get checkBox from layout
        final CheckBox important=(CheckBox) listViewItem.findViewById(R.id.CBImportantDatabase);

        if(important.isChecked()){
            //get id of Question that will be answer
            String ID=addAnswerAndQuestionToDatabase.getIDQuestion();
            //get question
            String question=addAnswerAndQuestionToDatabase.getQuestion();
            //get answer
            String answer=addAnswerAndQuestionToDatabase.getAnswer();
            //select the database that will connect with it
            DatabaseReference answerDatabase=
                    FirebaseDatabase.getInstance().getReference("QuestionAndAnswer").child(ID);
            //when question mark remove them from general answer database
            answerDatabase.setValue(null);

            DatabaseReference ImportantDatabase=FirebaseDatabase.getInstance().getReference("ImportantQuestion");
            String IDImportant=ImportantDatabase.push().getKey();

            AddAnswerAndQuestionToDatabase addAnswerAndQuestionTo=new
                    AddAnswerAndQuestionToDatabase(IDImportant,question,answer);
            ImportantDatabase.child(IDImportant).setValue(addAnswerAndQuestionTo);
        }
        return  listViewItem;

        //take the layout of post for database as template for each element will show

    }
}




class GetAnswerAndQuestionForDatabaseForImportant extends ArrayAdapter<AddAnswerAndQuestionToDatabase> {
    private Activity context;
    private List<AddAnswerAndQuestionToDatabase> answerAndQuestionList;

    public GetAnswerAndQuestionForDatabaseForImportant(Activity context, List<AddAnswerAndQuestionToDatabase> answerAndQuestionList) {
        super(context, R.layout.answer_and_important_for_database, answerAndQuestionList);
        this.context = context;
        this.answerAndQuestionList = answerAndQuestionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.answer_and_important_for_database, null, true);
        AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=answerAndQuestionList.get(position);
        TextView Question=(TextView) listViewItem.findViewById(R.id.TVQuestionWasAnsweredDatabase);
        TextView Answer=(TextView) listViewItem.findViewById(R.id.TVAnsweredOfQuestionForDatabase);
        Question.setText(addAnswerAndQuestionToDatabase.getQuestion());
        Answer.setText(addAnswerAndQuestionToDatabase.getAnswer());
        CheckBox important=(CheckBox) listViewItem.findViewById(R.id.CBImportantDatabase);
        important.setChecked(true);
        //take the layout of post for database as template for each element will show
        return  listViewItem;

    }
}


class GetAnswerAndQuestionForDatabaseForImportantForStudent extends ArrayAdapter<AddAnswerAndQuestionToDatabase> {
    private Activity context;
    private List<AddAnswerAndQuestionToDatabase> answerAndQuestionList;

    public GetAnswerAndQuestionForDatabaseForImportantForStudent(Activity context, List<AddAnswerAndQuestionToDatabase> answerAndQuestionList) {
        super(context, R.layout.answer_and_important_for_database, answerAndQuestionList);
        this.context = context;
        this.answerAndQuestionList = answerAndQuestionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.answer_and_important_for_database, null, true);
        AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=answerAndQuestionList.get(position);
        TextView Question=(TextView) listViewItem.findViewById(R.id.TVQuestionWasAnsweredDatabase);
        TextView Answer=(TextView) listViewItem.findViewById(R.id.TVAnsweredOfQuestionForDatabase);
        Question.setText(addAnswerAndQuestionToDatabase.getQuestion());
        Answer.setText(addAnswerAndQuestionToDatabase.getAnswer());
        CheckBox important=(CheckBox) listViewItem.findViewById(R.id.CBImportantDatabase);
        important.setChecked(true);
        important.setVisibility(View.GONE);
        //take the layout of post for database as template for each element will show
        return  listViewItem;

    }
}


class GetAnswerAndQuestionForDatabaseForStudent extends ArrayAdapter<AddAnswerAndQuestionToDatabase> {
    private Activity context;
    private List<AddAnswerAndQuestionToDatabase> answerAndQuestionList;

    public GetAnswerAndQuestionForDatabaseForStudent(Activity context, List<AddAnswerAndQuestionToDatabase> answerAndQuestionList) {
        super(context, R.layout.answer_and_important_for_database, answerAndQuestionList);
        this.context = context;
        this.answerAndQuestionList = answerAndQuestionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        //make the elements that put in list view like the elements in layout that called
        View listViewItem = inflater.inflate(R.layout.answer_and_important_for_database, null, true);

        AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=answerAndQuestionList.get(position);
        //get textView in layout to set text
        TextView Question=(TextView) listViewItem.findViewById(R.id.TVQuestionWasAnsweredDatabase);
        TextView Answer=(TextView) listViewItem.findViewById(R.id.TVAnsweredOfQuestionForDatabase);

        //set Text in TextView as that stored in database
        Question.setText(addAnswerAndQuestionToDatabase.getQuestion());
        Answer.setText(addAnswerAndQuestionToDatabase.getAnswer());

        //get checkBox from layout
        CheckBox important=(CheckBox) listViewItem.findViewById(R.id.CBImportantDatabase);
        important.setVisibility(View.GONE);
        return  listViewItem;

        //take the layout of post for database as template for each element will show

    }
}