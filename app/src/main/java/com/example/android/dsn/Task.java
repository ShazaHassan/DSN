package com.example.android.dsn;

/*
created by Mariam Mamdouh on 5-5-2017
 */

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


public class Task extends AppCompatActivity {
    private LinearLayout AddTask;
    private EditText TaskNum, TaskDesc, TaskDeadline;
    private TextView OldTaskNum, OldTaskDesc, OldTaskDeadline;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Text3, Text4, Text5;
                Button submit;
                TextView text10, text14, text16;

                //OnClick new task button make the 3 editTexts and submit button visible

                Text3 = (EditText) Task.this.findViewById(R.id.no);
                Text3.setVisibility(View.VISIBLE);

                Text4 = (EditText) Task.this.findViewById(R.id.dead);
                Text4.setVisibility(View.VISIBLE);

                Text5 = (EditText) Task.this.findViewById(R.id.des);
                Text5.setVisibility(View.VISIBLE);

                submit = (Button) Task.this.findViewById(R.id.Subbmit);
                submit.setVisibility(View.VISIBLE);

                text10 = (TextView) Task.this.findViewById(R.id.textView10);
                text10.setVisibility(View.VISIBLE);

                text14 = (TextView) Task.this.findViewById(R.id.textView14);
                text14.setVisibility(View.VISIBLE);

                text16 = (TextView) Task.this.findViewById(R.id.textView16);
                text16.setVisibility(View.VISIBLE);

            }
        });
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

        //add the rectangle for each post

       /* OldTaskNum.setBackgroundResource(R.drawable.bordertopost);
        OldTaskDesc.setBackgroundResource(R.drawable.bordertopost);
        OldTaskDeadline.setBackgroundResource(R.drawable.bordertopost);*/

        TaskNum = (EditText) findViewById(R.id.no);
        TaskDesc = (EditText) findViewById(R.id.des);
        TaskDeadline = (EditText) findViewById(R.id.dead);

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

            OldTaskNum.setText(text1);
            OldTaskDesc.setText(text2);
            OldTaskDeadline.setText(text3);

            //add text view in page

            AddTask.addView(OldTaskNum);
            AddTask.addView(OldTaskDesc);
            AddTask.addView(OldTaskDeadline);

            //add line to separate between posts

           AddTask.addView(view1);
        }
    }
    }










   /* public void VisibleInputTex (View view){

        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);

    }*/
    //}
//}
