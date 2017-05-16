package com.example.android.dsn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class ImpotantQuestion extends AppCompatActivity {

    DatabaseReference databaseImportant;
    ListView listViewImportant;
    List<AddAnswerAndQuestionToDatabase> answerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impotant_question);
        databaseImportant= FirebaseDatabase.getInstance().getReference("ImportantQuestion");
        listViewImportant=(ListView) findViewById(R.id.LVQuestionAndAnswer);
        answerList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseImportant.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                answerList.clear();
                for(DataSnapshot AnswerSnopSthot:dataSnapshot.getChildren()){
                    AddAnswerAndQuestionToDatabase addAnswerAndQuestionToDatabase=
                            AnswerSnopSthot.getValue(AddAnswerAndQuestionToDatabase.class);;
                    answerList.add(addAnswerAndQuestionToDatabase);

                }
                GetAnswerAndQuestionForDatabaseForImportantForStudent getAnswerAndQuestionForDatabaseForImportant=
                new GetAnswerAndQuestionForDatabaseForImportantForStudent(ImpotantQuestion.this,answerList) ;
                listViewImportant.setAdapter(getAnswerAndQuestionForDatabaseForImportant);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
