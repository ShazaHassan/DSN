package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.dsn.R.id.post;
import static com.example.android.dsn.R.id.writePost;

/**
 * Created by Shaza Hassan on 02-May-17.
 */

public class GroupOfAcadYearForStudent extends AppCompatActivity implements GroupOfAcadYear,AdapterView.OnItemSelectedListener {
    LinearLayout addPost;
    EditText writePost;
    TextView post;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_group_of_acad_year);

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
        post.setText(text);
        addPost.addView(post);//add text view in page
        addPost.addView(view1);//add line to separate between posts

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(!item.equals("select subject"))
        {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            Intent registerIntent = new Intent(GroupOfAcadYearForStudent.this, AboutSubject.class);
            Spinner select=(Spinner) findViewById(R.id.subjectSelect);
            select.setSelection(0);
            startActivity(registerIntent);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void HODPage(View view) {
        Intent HodPage=new Intent(GroupOfAcadYearForStudent.this,HOD.class);
        startActivity(HodPage);
    }
}
