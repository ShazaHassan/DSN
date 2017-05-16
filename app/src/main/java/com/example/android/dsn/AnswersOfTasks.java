package com.example.android.dsn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class AnswersOfTasks extends AppCompatActivity {
   DatabaseReference databaseAnswerTask;
    ListView listViewAnswerTask;
    List<AddTaskAnswerForDatabase> AnswerTaskList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers_of_tasks);
        databaseAnswerTask=FirebaseDatabase.getInstance().getReference("TaskAnswer");
        listViewAnswerTask=(ListView) findViewById(R.id.LVTaskAnswer);
        AnswerTaskList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseAnswerTask.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AnswerTaskList.clear();
                for(DataSnapshot answerTaskSnapShot:dataSnapshot.getChildren()){
                    AddTaskAnswerForDatabase addTaskAnswerForDatabase=
                            answerTaskSnapShot.getValue(AddTaskAnswerForDatabase.class);
                    AnswerTaskList.add(addTaskAnswerForDatabase);
                }
                GetAnswerofTaskFromDaabase getAnswerofTaskFromDaabase=
                        new GetAnswerofTaskFromDaabase(AnswersOfTasks.this,AnswerTaskList);
                listViewAnswerTask.setAdapter(getAnswerofTaskFromDaabase);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
