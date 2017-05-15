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

public class AnswersOfTasks extends AppCompatActivity {
    DatabaseReference answerTaskDatabase;
    ListView listViewAnswerTask;
    List<AddTaskAnswerForDatabase> answerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        answerTaskDatabase= FirebaseDatabase.getInstance().getReference("TaskAnswer");
        listViewAnswerTask=(ListView) findViewById(R.id.LVTaskAnswer);
        answerList=new ArrayList<>();
        setContentView(R.layout.activity_answers_of_tasks);
    }

    @Override
    protected void onStart() {
        super.onStart();
        answerTaskDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                answerList.clear();
                for(DataSnapshot answerSnapShot:dataSnapshot.getChildren()){
                    AddTaskAnswerForDatabase addTaskToDatabase=answerSnapShot.getValue(AddTaskAnswerForDatabase.class);
                    answerList.add(addTaskToDatabase);//store the data that come from database in arrayList
                }
                GetAnswerofTaskFromDaabase getTaskFromDatabase=new GetAnswerofTaskFromDaabase(AnswersOfTasks.this,answerList);
                listViewAnswerTask.setAdapter(getTaskFromDatabase);//show the data in arrayList
                    }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
