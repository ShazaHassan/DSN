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

import static android.widget.RelativeLayout.BELOW;

/**
 * Created by Shaza Hassan on 09-May-17.
 */

public class QuestionForChForDoctor extends AppCompatActivity {
    DatabaseReference databaseQuestion;
    ListView listViewPost;
    List<AddQuestionToDatabase> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_ch);
        databaseQuestion=FirebaseDatabase.getInstance().getReference("QuestionOfCh");
        listViewPost=(ListView)  findViewById(R.id.LVQuestion);
        questionList=new ArrayList<>();
        //set the title of the page by the number of the ch
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseQuestion.addValueEventListener(new ValueEventListener() {
            //valueEventListener use to auto update when new data inserted in database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                questionList.clear();//clear arrayList at every print to prevent repeated data when will show to user
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    AddQuestionToDatabase putPost= postSnapShot.getValue(AddQuestionToDatabase.class);
                    questionList.add(putPost);//store the data that come from database in arrayList
                }
                GetQuestionFromDatabaseForDr getQuestionFromDatabaseForDr= new
                        GetQuestionFromDatabaseForDr(QuestionForChForDoctor.this,questionList);
                listViewPost.setAdapter(getQuestionFromDatabaseForDr);//show the data in arrayList
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void ImportantQuestion(View view) {
        Intent important=new Intent(this,ImpotantQuestion.class);
        startActivity(important);
    }

    public void answeredQuestions(View view) {
        Intent answersPage = new Intent(this, AnswerPage.class);
        /*TextView title = (TextView) findViewById(R.id.TvchapterNo);
        String ti = title.getText().toString();
        answersPage.putExtra("titleOfCh", ti);*/
        startActivity(answersPage);
    }
}
