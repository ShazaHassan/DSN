package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Mariam on 22-April-17.
 *
 */

public class ResetPassword extends AppCompatActivity {
    EditText email,pass, repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        email= (EditText) findViewById(R.id.ETemail);
        pass= (EditText ) findViewById(R.id.ETpassword);
        repeat= (EditText) findViewById(R.id.ETrepeatpassword);

    }

    public void GoToLogin(View view) {
       /* if(pass.getText().toString().equals(repeat.getText().toString())) {


            boolean isUpdate = helper.update(email.getText().toString(), pass.getText().toString());
            if (isUpdate) {
                Toast.makeText(ResetPassword.this, "updated", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(ResetPassword.this, "not updated", Toast.LENGTH_LONG).show();

            }
        }
        else{
            Toast.makeText(ResetPassword.this, "not matched password", Toast.LENGTH_LONG).show();

        }*/
        Intent StartLoginActivity = new Intent(ResetPassword.this, Login.class);
        startActivity(StartLoginActivity);
    }
}
