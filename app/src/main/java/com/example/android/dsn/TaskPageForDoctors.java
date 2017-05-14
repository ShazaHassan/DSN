package com.example.android.dsn;

/*
created by Mariam on 5-5-2017
 */

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.text1;


public class TaskPageForDoctors extends AppCompatActivity {
    private EditText TaskNum, TaskDesc, TaskDeadline;
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
        EditVisibilityOfDElements();
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
                GetTaskFromDatabase getTaskFromDatabase=new GetTaskFromDatabase(TaskPageForDoctors.this,taskList);
                listViewTask.setAdapter(getTaskFromDatabase);//show the data in arrayList
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void GoToAnswersPage(View view) {
        Intent StartAnswersPageActivity = new Intent(TaskPageForDoctors.this, AnswersOfTasks.class);
        startActivity(StartAnswersPageActivity);
    }

    public void EditVisibilityOfDElements() {
        EditText Text3, Text4, Text5;
        TextView text10, text14, text16;
        Button button1;

        // make sure that the 3 editTexts and text views  visible, "upload" button is invisible


        Text3 = (EditText) TaskPageForDoctors.this.findViewById(R.id.ETno);
        Text3.setVisibility(View.VISIBLE);

        Text4 = (EditText) TaskPageForDoctors.this.findViewById(R.id.ETdead);
        Text4.setVisibility(View.VISIBLE);

        Text5 = (EditText) TaskPageForDoctors.this.findViewById(R.id.ETdes);
        Text5.setVisibility(View.VISIBLE);


        text10 = (TextView) TaskPageForDoctors.this.findViewById(R.id.Tvdes);
        text10.setVisibility(View.INVISIBLE);

        text14 = (TextView) TaskPageForDoctors.this.findViewById(R.id.Tvdead);
        text14.setVisibility(View.INVISIBLE);

        //  text16 = (TextView) TaskPageForDoctors.this.findViewById(R.id.textView16);
        //text16.setVisibility(View.INVISIBLE);

        button1 = (Button) TaskPageForDoctors.this.findViewById(R.id.Bupload);
        button1.setVisibility(View.INVISIBLE);


    }

    public void AddNewTask(View view) {
        // GET Edit texts where the tasks are written in

        TaskNum = (EditText) findViewById(R.id.ETno);
        TaskDesc = (EditText) findViewById(R.id.ETdes);
        TaskDeadline = (EditText) findViewById(R.id.ETdead);

        //get text of post from EditText

        String taskNO = TaskNum.getText().toString();
        String taskDesc = TaskDesc.getText().toString();
        String taskDeadline = TaskDeadline.getText().toString();


        if (taskNO.equals("") || taskDesc.equals("") || taskDeadline.equals("")) ;
        else {
            //clear EditText after add text in group
            TaskNum.setText("");
            TaskDesc.setText("");
            TaskDeadline.setText("");
            String TaskID=databaseTask.push().getKey();
            AddTaskToDatabase addTaskToDatabase= new AddTaskToDatabase(TaskID,taskNO,taskDesc,taskDeadline);
            databaseTask.child(TaskID).setValue(addTaskToDatabase);
        }
    }
}














