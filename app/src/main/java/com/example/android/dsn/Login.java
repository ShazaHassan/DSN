package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

   private EditText username;
    //DataBaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
       // myDB = new DataBaseHelper (this); //call the constructor of database helper
    }
    public void GoToResetPassword(View view){
        Intent StartResetPasswordActivity = new Intent(Login.this,ResetPassword.class);
        startActivity(StartResetPasswordActivity);
    }

    public void login(View view) {
        View focusView=new View(this);
        boolean cancel=false;
        username=(EditText) findViewById(R.id.ETUsername);
        String UserName=username.getText().toString();
        if (UserName.equals("Student")||UserName.equals("student"))
        {
            Intent login= new Intent(Login.this,GroupOfAcadYearForStudent.class);
            startActivity(login);
            cancel=false;
            username.setText("");
        }
            else if(UserName.equals("Doctor")||UserName.equals("doctor")){
            Intent login= new Intent(Login.this,SelectAcadYear.class);
            login.putExtra("user",UserName);
            startActivity(login);
            cancel=false;
            username.setText("");
        }
        else if (UserName.equals("HOD")|| UserName.equals("hod")) {
            Intent login= new Intent(Login.this,HODForHOD.class);
            login.putExtra("user",UserName);
            startActivity(login);
            cancel=false;
            username.setText("");
        }else
        {
                username.setError("error");
                focusView = username;
                cancel = true;

        }
        if (cancel)
        {
            focusView.requestFocus();
        }

    }

}
