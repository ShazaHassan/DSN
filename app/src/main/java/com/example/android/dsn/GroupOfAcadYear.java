package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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







    }

    //this show which item is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(!item.equals("select subject"))
        {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            Intent registerIntent = new Intent(GroupOfAcadYear.this, AboutSubject.class);
            Spinner select=(Spinner) findViewById(R.id.subjectSelect);
            select.setSelection(0);
            startActivity(registerIntent);
        }



        // Showing selected spinner item



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




    //when click on post button add post to page
    public void writePost(View view){
        addPost=(LinearLayout) findViewById(R.id.writtenpost);
        post =new TextView(this);
        View view1 =new View(this);
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the size of line which separate between posts
        view1.setBackgroundColor(Color.GRAY);
        post.setBackgroundResource(R.drawable.bordertopost);//add the rectangle for each post
        writePost= (EditText) findViewById(R.id.writePost) ;
        String text=writePost.getText().toString();//get text of post from EditText
        writePost.setText("");//clear EditText after add text in group
        post.setText(text);
        addPost.addView(post);//add text view in page
        addPost.addView(view1);//add line to separate between posts
    }

}
