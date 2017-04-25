package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectAcadYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_acad_year);
        final Button first= (Button) findViewById(R.id.firstyear);
        final Button second= (Button) findViewById(R.id.secondyear);
        final Button third= (Button) findViewById(R.id.thirdyear);
        final Button forth= (Button) findViewById(R.id.forthyear);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                SelectAcadYear.this.startActivity(registerIntent);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                SelectAcadYear.this.startActivity(registerIntent);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                SelectAcadYear.this.startActivity(registerIntent);
            }
        });
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SelectAcadYear.this, GroupOfAcadYear.class);
                SelectAcadYear.this.startActivity(registerIntent);
            }
        });
    }
}
