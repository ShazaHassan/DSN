package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }

    public void GoToNewTask(View view) {
        Intent NewTaskPage = new Intent(Task.this, NewTask.class);
        startActivity(NewTaskPage);
    }
}
