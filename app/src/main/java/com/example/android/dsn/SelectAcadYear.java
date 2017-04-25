package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class SelectAcadYear extends AppCompatActivity {


    protected Button first,second,third,forth;

    public static final String EXTRA_MESSAGE = "com.example.android.dsn.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_acad_year);

        first=(Button) findViewById(R.id.firstyear);
        second=(Button)  findViewById(R.id.secondyear);
        third= (Button) findViewById(R.id.thirdyear);
        forth=(Button) findViewById(R.id.forthyear);



        // go to academic year page and write the name of year
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                String fi= first.getText().toString();
                registerIntent.putExtra(EXTRA_MESSAGE, fi);
                startActivity(registerIntent);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                String fi= second.getText().toString();
                registerIntent.putExtra(EXTRA_MESSAGE, fi);
                startActivity(registerIntent);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                String fi= third.getText().toString();
                registerIntent.putExtra(EXTRA_MESSAGE, fi);
                startActivity(registerIntent);
            }
        });
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                String fi= forth.getText().toString();
                registerIntent.putExtra(EXTRA_MESSAGE, fi);
                startActivity(registerIntent);
            }
        });
    }
}
