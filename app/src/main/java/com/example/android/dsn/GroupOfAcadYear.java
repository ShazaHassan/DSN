package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class GroupOfAcadYear extends AppCompatActivity implements AdapterView.OnItemSelectedListener {





    LinearLayout addPost;
    EditText writePost;
    TextView post;
    Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_of_acad_year);






        Intent intent = getIntent();
        String message = intent.getStringExtra(SelectAcadYear.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.acadYear);
        textView.setText(message);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.subjectSelect);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("select subject");
        categories.add("Software 1");
        categories.add("Math");
        categories.add("UI");
        categories.add("Software 2");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);



        //when click on post button
        addPost=(LinearLayout) findViewById(R.id.mainPage);
        post =new TextView(this);
        postButton=(Button) findViewById(R.id.post);
        writePost= (EditText) findViewById(R.id.writePost) ;






    }

    //this show which item is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        Intent registerIntent = new Intent(GroupOfAcadYear.this, AboutSubject.class);
        startActivity(registerIntent);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




    //when click on post button add post to page
    public void writePost(View view){

                addPost.addView(addNewPost(writePost.getText().toString()));
                writePost.setText("");

    }


    private TextView addNewPost(String text) {
        final ActionBar.LayoutParams layoutParams= new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        post.setLayoutParams(layoutParams);
        post.setText(text);
        return post;
    }
}
