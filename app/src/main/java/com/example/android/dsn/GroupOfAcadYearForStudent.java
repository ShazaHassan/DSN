package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by Shaza Hassan on 02-May-17.
 */

public class GroupOfAcadYearForStudent extends AppCompatActivity implements GroupOfAcadYear,AdapterView.OnItemSelectedListener {
    private LinearLayout addPost;
    private EditText writePost;
    private TextView post;
    private static String publisher;
    DataBaseHelper helper;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_group_of_acad_year);
       addElementInSpinnerOfSubject();
       Intent publisherPost=getIntent();
       publisher = publisherPost.getStringExtra("user");
       editInElement();
       helper=new DataBaseHelper(this);

   }

    private void addElementInSpinnerOfSubject(){
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.subjectSelect);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("select subject");
        categories.add("Software 1");
        categories.add("Software2");
        categories.add("OS");
        categories.add("Micro");
        categories.add("Math");



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    public static String getPublisher() {
        return publisher;
    }

    @Override
    public void writePost(View view) {
        addPost=(LinearLayout) findViewById(R.id.writtenpost);
        post =new TextView(this);
        View view1 =new View(this);
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the size of line which separate between posts
        view1.setBackgroundColor(Color.GRAY);
        post.setBackgroundResource(R.drawable.bordertopost);//add the rectangle for each post
        writePost= (EditText) findViewById(R.id.writePost) ;
        String text=writePost.getText().toString();//get text of post from EditText
        writePost.setText("");//clear EditText after add text in group
        if(text.equals(""));
        else {
            writePost.setText("");//clear EditText after add text in group
            post.setText(text);
            addPost.addView(post);//add text view in page
            addPost.addView(view1);//add line to separate between posts
        }

    }

    @Override
    public void editInElement() {
        Button message=(Button) findViewById(R.id.MessageToRep);
        message.setVisibility(View.GONE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(!item.equals("select subject"))
        {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            Intent registerIntent = new Intent(GroupOfAcadYearForStudent.this, AboutSubjectForStudent.class);
            Spinner select=(Spinner) findViewById(R.id.subjectSelect);
            registerIntent.putExtra("subject",item)  ;
            startActivity(registerIntent);
            select.setSelection(0);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void HODPage(View view) {
        Intent HodPage=new Intent(GroupOfAcadYearForStudent.this,HODForStudent.class);
        startActivity(HodPage);
    }
}
