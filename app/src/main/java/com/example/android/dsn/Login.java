package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void GoToResetPassword(View view){
        Intent StartResetPasswordActivity = new Intent(Login.this,ResetPassword.class);
        startActivity(StartResetPasswordActivity);
    }

    public void login(View view) {
        View focusView=new View(this);
        boolean cancel=false;
        username=(EditText) findViewById(R.id.Username);
        String UserName=username.getText().toString();
        if (UserName.equals("Shaza"))
        {
            Intent login= new Intent(Login.this,GroupOfAcadYearForStudent.class);
            startActivity(login);
            cancel=false;
            username.setText("");
        }
            else if(UserName.equals("Mariam")){
            Intent login= new Intent(Login.this,SelectAcadYear.class);
            startActivity(login);
            cancel=false;
            username.setText("");
        } else{
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
