package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Shaza Hassan on 05-May-17.
 */

public class HODForProfessor extends AppCompatActivity implements HOD {

    private LinearLayout addPost;
    private EditText writePost;
    private TextView post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);
        editInElement();
    }

    @Override
    public void writePost(View view) {
        post =new TextView(this);
        View view1 =new View(this);
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the size of line which separate between posts
        view1.setBackgroundColor(Color.GRAY);
        post.setBackgroundResource(R.drawable.bordertopost);//add the rectangle for each post
        writePost= (EditText) findViewById(R.id.ETwritePostHOD) ;
        String text=writePost.getText().toString();//get text of post from EditText

    }

    @Override
    public void editInElement() {
        Button message,uploadFiles;
        Spinner select;
        message=(Button) findViewById(R.id.BmessageHOD);
        message.setVisibility(View.VISIBLE);
        uploadFiles=(Button) findViewById(R.id.BuploadFilesHOD);
        uploadFiles.setVisibility(View.GONE);
        select=(Spinner) findViewById(R.id.Spinnerselectacademicyear);
        select.setVisibility(View.GONE);

    }
    public void messageToHOD(View view){
        Intent message=new Intent(HODForProfessor.this,MessageToHOD.class);
        startActivity(message);
    }
}
