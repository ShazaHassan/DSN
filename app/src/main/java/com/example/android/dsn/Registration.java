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

public class Registration extends AppCompatActivity {
        DataBaseHelper helper;
    EditText username,email,password,repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        helper =new DataBaseHelper(this);
        username = (EditText) findViewById(R.id.ETusername);
        email= (EditText) findViewById(R.id.ETemail);
        password=(EditText) findViewById(R.id.ETPass);
        repeat= (EditText) findViewById(R.id.ETrepeatpassword);
    }

    public void GoToLogin(View view) {

            String name=username.getText().toString();
            String mail=email.getText().toString();
            String pass=password.getText().toString();
            String rep=repeat.getText().toString();
            /*if(pass.equals(rep)) {

                Boolean isInsert=helper.insertDataForUser(name,
                    mail,
                    pass);
            if(isInsert){
                Toast.makeText(Registration.this,"data inserted",Toast.LENGTH_LONG).show();

            }else
            {
                Toast.makeText(Registration.this,"data not inserted",Toast.LENGTH_LONG).show();

            }
        }
        else{
            Toast.makeText(Registration.this,"not match password",Toast.LENGTH_LONG).show();

        }*/

        Intent StartLoginActivity = new Intent(Registration.this, Login.class);
        startActivity(StartLoginActivity);
    }
}
