package com.example.android.dsn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lenovo on 09/05/2017.
 */

public class TaskPageForStudents extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        EditVisibilityOfSElements();
    }

    public void EditVisibilityOfSElements() {
        EditText Text3, Text4, Text5;
        TextView text10, text14, text16,TAddnewtask;
        Button bupload,baddtask,banswers;

        // make sure that the "upload" button is visible ,3 editTexts,text views and any other button is invisible,


        Text3 = (EditText) TaskPageForStudents.this.findViewById(R.id.no);
        Text3.setVisibility(View.INVISIBLE);

        Text4 = (EditText) TaskPageForStudents.this.findViewById(R.id.dead);
        Text4.setVisibility(View.INVISIBLE);

        Text5 = (EditText) TaskPageForStudents.this.findViewById(R.id.des);
        Text5.setVisibility(View.INVISIBLE);


        text10 = (TextView) TaskPageForStudents.this.findViewById(R.id.textView10);
        text10.setVisibility(View.INVISIBLE);

        text14 = (TextView) TaskPageForStudents.this.findViewById(R.id.textView14);
        text14.setVisibility(View.INVISIBLE);

        //text16 = (TextView) TaskPageForStudents.this.findViewById(R.id.textView16);
       // text16.setVisibility(View.INVISIBLE);

        bupload = (Button)TaskPageForStudents.this.findViewById(R.id.Bupload);
        bupload.setVisibility(View.VISIBLE);

        baddtask = (Button)TaskPageForStudents.this.findViewById(R.id.BAddTask);
        baddtask.setVisibility(View.INVISIBLE);

        banswers = (Button)TaskPageForStudents.this.findViewById(R.id.BAnswers);
        banswers.setVisibility(View.INVISIBLE);

        TAddnewtask=(TextView) TaskPageForStudents.this.findViewById(R.id.Addtask);
        TAddnewtask.setVisibility(View.INVISIBLE);



    }
}
