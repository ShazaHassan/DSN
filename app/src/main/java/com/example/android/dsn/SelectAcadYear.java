package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectAcadYear extends AppCompatActivity {


    private Button first,second,third,forth;

    public static final String EXTRA_MESSAGE = "com.example.android.dsn.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_acad_year);
        first= (Button)findViewById(R.id.firstyear);
        second= (Button)findViewById(R.id.secondyear);
        third= (Button)findViewById(R.id.thirdyear);
        forth= (Button)findViewById(R.id.forthyear);

    }


    public void firstYear(View view) {
        Intent next=new Intent(SelectAcadYear.this,GroupOfAcadYearForProfessor.class);
        String year=first.getText().toString();
        next.putExtra( EXTRA_MESSAGE,year);
        startActivity(next);

    }
    public void secondYear(View view) {
        Intent next=new Intent(SelectAcadYear.this,GroupOfAcadYearForProfessor.class);
        String year=second.getText().toString();
        next.putExtra( EXTRA_MESSAGE,year);
        startActivity(next);

    }
    public void thirdYear(View view) {
        Intent next=new Intent(SelectAcadYear.this,GroupOfAcadYearForProfessor.class);
        String year=third.getText().toString();
        next.putExtra( EXTRA_MESSAGE,year);
        startActivity(next);
    }
    public void forthYear(View view) {
        Intent next=new Intent(SelectAcadYear.this,GroupOfAcadYearForProfessor.class);
        String year=third.getText().toString();
        next.putExtra( EXTRA_MESSAGE,year);
        startActivity(next);
    }

}
