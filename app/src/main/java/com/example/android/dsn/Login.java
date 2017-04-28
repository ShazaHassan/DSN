package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

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
        Intent login= new Intent(Login.this,SelectAcadYear.class);
        startActivity(login);
    }
}
