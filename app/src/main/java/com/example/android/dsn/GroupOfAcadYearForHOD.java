package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.android.dsn.R.id.hod;

/**
 * Created by Shaza Hassan on 05-May-17.
 */

public class GroupOfAcadYearForHOD extends AppCompatActivity implements GroupOfAcadYear {


    private LinearLayout addPost;
    private EditText writePost;
    private TextView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_of_acad_year);
        Intent intent = getIntent();
        String message = intent.getStringExtra(HODForHOD.YEAR);
        TextView textView = (TextView) findViewById(R.id.acadYear);
        textView.setText(message);
        editInElement();
    }

    public void editInElement(){
        Spinner subject=(Spinner) findViewById(R.id.subjectSelect);
        subject.setVisibility(View.GONE);
        Button hod=(Button)findViewById(R.id.hod);
        hod.setVisibility(View.INVISIBLE);
    }


    public void messagetoRep(View view) {
        Intent message=new Intent(GroupOfAcadYearForHOD.this,MessageToRepresentative.class);
        startActivity(message);
    }

    public void writePost(View view) {
        addPost=(LinearLayout) findViewById(R.id.writtenpost);
        post =new TextView(this);
        View view1 =new View(this);
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the size of line which separate between posts
        view1.setBackgroundColor(Color.GRAY);
        post.setBackgroundResource(R.drawable.bordertopost);//add the rectangle for each post
        writePost= (EditText) findViewById(R.id.writePost) ;
        String text=writePost.getText().toString();//get text of post from EditText
        if(text.equals(""));
        else {
            writePost.setText("");//clear EditText after add text in group
            post.setText(text);
            addPost.addView(post);//add text view in page
            addPost.addView(view1);//add line to separate between posts
        }
    }
}
