package com.example.android.dsn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.id;
/*
* Created by Mariam on 13-May-17
 */

public class TaskAnswers extends AppCompatActivity {
    private EditText name,section,taskNo,file;
    DatabaseReference answerTaskDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_answers);
        answerTaskDatabase= FirebaseDatabase.getInstance().getReference("TaskAnswer");
        name=(EditText) findViewById(R.id.EDFullName);
        section=(EditText) findViewById(R.id.EDSection);
        taskNo=(EditText) findViewById(R.id.EDTaskNo);
        file=(EditText) findViewById(R.id.EDFile);

    }

    public void UploadTask(View view) {
        String Name=name.getText().toString();
        String Sec=section.getText().toString();
        String No=taskNo.getText().toString();
        String File=file.getText().toString();
        if(Name.equals("")||Sec.equals("")||No.equals("")||File.equals(""));
        else{
            name.setText("");
            section.setText("");
            taskNo.setText("");
            file.setText("");
            //FIRST GIVE ID FOR EVERY ELEMENT IN DATA
            String IDTaskAnswer=answerTaskDatabase.push().getKey();
            //SEND DATA TO CLASS THIS CLASS USE TO SEND DATA TO DATABASE
            AddTaskAnswerForDatabase addTaskAnswerForDatabase=new
                    AddTaskAnswerForDatabase(IDTaskAnswer,Name,Sec,No,File);
            addTaskAnswerForDatabase.setID(IDTaskAnswer);
            addTaskAnswerForDatabase.setName(Name);
            addTaskAnswerForDatabase.setSec(Sec);
            addTaskAnswerForDatabase.setNo(No);
            addTaskAnswerForDatabase.setFile(File);
            //ADD THE DATA TO DATABASE
            answerTaskDatabase.child(IDTaskAnswer).setValue(addTaskAnswerForDatabase);
        }

    }
}
