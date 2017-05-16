package com.example.android.dsn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShazaHassan on  09-May-17.
 */

public class TaskPageForStudents extends AppCompatActivity {
    DatabaseReference databaseTask;
    List<AddTaskToDatabase> taskList;
    ListView listViewTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        databaseTask= FirebaseDatabase.getInstance().getReference("DataOfTask");
        taskList=new ArrayList<>();
        listViewTask=(ListView) findViewById(R.id.LVTaskAdded);
        EditVisibilityOfSElements();
    }

    public void EditVisibilityOfSElements() {
        EditText Text3, Text4, Text5;
        TextView text10, text14,TAddnewtask;
        Button bupload,baddtask,banswers;

        // make sure that the "upload" button is visible ,3 editTexts,text views and any other button is invisible,
        Text3 = (EditText) TaskPageForStudents.this.findViewById(R.id.ETno);
        Text3.setVisibility(View.GONE);

        Text4 = (EditText) TaskPageForStudents.this.findViewById(R.id.ETdead);
        Text4.setVisibility(View.GONE);

        Text5 = (EditText) TaskPageForStudents.this.findViewById(R.id.ETdes);
        Text5.setVisibility(View.GONE);


        text10 = (TextView) TaskPageForStudents.this.findViewById(R.id.Tvdes);
        text10.setVisibility(View.GONE);

        text14 = (TextView) TaskPageForStudents.this.findViewById(R.id.Tvdead);
        text14.setVisibility(View.GONE);

        bupload = (Button)TaskPageForStudents.this.findViewById(R.id.Bupload);
        bupload.setVisibility(View.VISIBLE);

        baddtask = (Button)TaskPageForStudents.this.findViewById(R.id.BAddTask);
        baddtask.setVisibility(View.GONE);

        banswers = (Button)TaskPageForStudents.this.findViewById(R.id.BAnswers);
        banswers.setVisibility(View.GONE);

        TAddnewtask=(TextView) TaskPageForStudents.this.findViewById(R.id.TvAddnewtask);
        TAddnewtask.setVisibility(View.GONE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseTask.addValueEventListener(new ValueEventListener() {
            //valueEventListener use to auto update when new data inserted in database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                taskList.clear();//clear arrayList at every print to prevent repeated data when will show to user
                for(DataSnapshot taskSnapShot:dataSnapshot.getChildren()){
                    AddTaskToDatabase addTaskToDatabase=taskSnapShot.getValue(AddTaskToDatabase.class);
                    taskList.add(addTaskToDatabase);//store the data that come from database in arrayList
                }
                GetTaskFromDatabase getTaskFromDatabase=new GetTaskFromDatabase(TaskPageForStudents.this,taskList);
                listViewTask.setAdapter(getTaskFromDatabase);//show the data in arrayList
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void GoToTaskAnswers (View view){
        Intent StartTaskAnswersActivity = new Intent(TaskPageForStudents.this, TaskAnswers.class);
        startActivity(StartTaskAnswersActivity);
    }
}
