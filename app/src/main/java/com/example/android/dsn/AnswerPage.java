package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class AnswerPage extends AppCompatActivity {
    DatabaseReference databaseQuestionAndAnswer;
    ListView listViewQuestionAndAnswer;
    List<AddAnswerAndQuestionToDatabase> questionAndAnswerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);
        databaseQuestionAndAnswer= FirebaseDatabase.getInstance().getReference("QuestionAndAnswer");
        listViewQuestionAndAnswer=(ListView)  findViewById(R.id.LVQuestionAndAnswer);
        questionAndAnswerList=new ArrayList<>();
        /*Intent intent = getIntent();
        String chNo = intent.getStringExtra("titleOfCh");
        TextView title = (TextView) findViewById(R.id.titleOfAnswer);
        title.setText("Answer of " + chNo);*/

    }

   @Override
    protected void onStart() {
        super.onStart();
        databaseQuestionAndAnswer.addValueEventListener(new ValueEventListener() {
            //valueEventListener use to auto update when new data inserted in database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                questionAndAnswerList.clear();//clear arrayList at every print to prevent repeated data when will show to user
                for (DataSnapshot questionAndAnswerSnapShot : dataSnapshot.getChildren()) {
                    AddAnswerAndQuestionToDatabase putPost= questionAndAnswerSnapShot.getValue(AddAnswerAndQuestionToDatabase.class);
                    questionAndAnswerList.add(putPost);//store the data that come from database in arrayList
                }
                GetAnswerAndQuestionForDatabase getPostFromDatabase=
                        new GetAnswerAndQuestionForDatabase(AnswerPage.this,questionAndAnswerList);
                listViewQuestionAndAnswer.setAdapter(getPostFromDatabase);//show the data in arrayList
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
