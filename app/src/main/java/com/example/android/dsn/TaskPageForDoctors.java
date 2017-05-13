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
import android.widget.TextView;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class TaskPageForDoctors extends AppCompatActivity {
    private LinearLayout AddTask;
    private EditText TaskNum, TaskDesc, TaskDeadline;
    private TextView OldTaskNum, OldTaskDesc, OldTaskDeadline;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_task);
         EditVisibilityOfDElements();
        }




    public void GoToAnswersPage (View view){
        Intent StartAnswersPageActivity = new Intent(TaskPageForDoctors.this,AnswersOfTasks.class);
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

                button1 = (Button)TaskPageForDoctors.this.findViewById(R.id.Bupload);
                button1.setVisibility(View.INVISIBLE);


            }



    public void AddNewTask(View view) {
        AddTask = (LinearLayout) findViewById(R.id.writtenpost);
        OldTaskNum = new TextView(this);
        OldTaskDeadline = new TextView(this);
        OldTaskDesc = new TextView(this);

        View view1 = new View(this);

        //set the size of line which separate between posts

        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
        view1.setBackgroundColor(Color.GRAY);

        /*
        add the rectangle for each post

        OldTaskNum.setBackgroundResource(R.drawable.bordertopost);
        OldTaskDesc.setBackgroundResource(R.drawable.bordertopost);
        OldTaskDeadline.setBackgroundResource(R.drawable.bordertopost);
        */

       // GET Edit texts where the tasks are written in

        TaskNum = (EditText) findViewById(R.id.ETno);
        TaskDesc = (EditText) findViewById(R.id.ETdes);
        TaskDeadline = (EditText) findViewById(R.id.ETdead);

        //get text of post from EditText

        String text1 = TaskNum.getText().toString();
        String text2 = TaskDesc.getText().toString();
        String text3 = TaskDeadline.getText().toString();



        if (text1.equals("") || text2.equals("") || text3.equals("")) ;
        else {

            //clear EditText after add text in group

            TaskNum.setText("");
            TaskDesc.setText("");
            TaskDeadline.setText("");

            // Add old task on the page ( as a text view)

            OldTaskNum.setText("Task No.:" +" "+ text1);
            OldTaskDesc.setText("Description:" +" "+ text2);
            OldTaskDeadline.setText("Deadline:"+" " + text3);

            //Add text view in page

            AddTask.addView(OldTaskNum);
            AddTask.addView(OldTaskDesc);
            AddTask.addView(OldTaskDeadline);

            //add line to separate between posts

           AddTask.addView(view1);
        }
    }
    }














