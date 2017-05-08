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

public class GroupOfAcadYearForProfessor extends AppCompatActivity implements AdapterView.OnItemSelectedListener,GroupOfAcadYear {





   private LinearLayout addPost;
    private EditText writePost;
    private TextView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_of_acad_year);

        //take the name of the button that select the academic year and add at the top of page

        Intent intent = getIntent();
        String message = intent.getStringExtra(SelectAcadYear.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.acadYear);
        textView.setText(message);
        addElementInSpinnerOfSubject();
        editInElement();

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

    //this show which item is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(!item.equals("select subject"))
        {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            Intent registerIntent = new Intent(GroupOfAcadYearForProfessor.this, AboutSubjectForProfessor.class);
            Spinner select=(Spinner) findViewById(R.id.subjectSelect);
            registerIntent.putExtra("subject",item)  ;
            startActivity(registerIntent);
            select.setSelection(0);
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

    public void HODPage(View view) {
        Intent HodPage=new Intent(GroupOfAcadYearForProfessor.this,HODForProfessor.class);
        startActivity(HodPage);
    }
}
