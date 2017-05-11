package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StartPage extends AppCompatActivity {
    private View view;
    DataBaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
       myDB = new DataBaseHelper (this); //call the constructor of database helper

    }
    public void GoToLogin(View view){
        this.view = view;
        Intent StartLoginActivity = new Intent(StartPage.this,Login.class);
        startActivity(StartLoginActivity);
    }


    public void GoToRegisteration(View view){
        Intent StartRegisterationActivity = new Intent(StartPage.this,Registration.class);
        startActivity(StartRegisterationActivity);
    }

    /*// method which insert data into database
     public int insertData(){

     }*/
}
