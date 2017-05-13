package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Mariam on 20-April-17.
 *
*/
public class StartPage extends AppCompatActivity {
    private View view;
    DataBaseHelper mydb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        mydb1 = new DataBaseHelper(this);

    }

    public void GoToLogin(View view) {
        this.view = view;
        Intent StartLoginActivity = new Intent(StartPage.this, Login.class);
        startActivity(StartLoginActivity);
    }


    public void GoToRegisteration(View view) {
        Intent StartRegisterationActivity = new Intent(StartPage.this, Registration.class);
        startActivity(StartRegisterationActivity);
    }
}
    // method which insert data into database



