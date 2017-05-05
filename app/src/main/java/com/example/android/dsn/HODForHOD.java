package com.example.android.dsn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

/**
 * Created by Shaza Hassan on 05-May-17.
 */

public class HODForHOD extends AppCompatActivity implements HOD, AdapterView.OnItemSelectedListener {
    private LinearLayout addPost;
    private EditText writePost;
    private TextView post;
    private Spinner select;
    public static final String YEAR = "com.example.android.dsn.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);
        editInElement();
        addElementInSpinner();
    }

    @Override
    public void writePost(View view) {
        addPost=(LinearLayout) findViewById(R.id.writtenPostHOD);
        post =new TextView(this);
        View view1 =new View(this);
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the size of line which separate between posts
        view1.setBackgroundColor(Color.GRAY);
        post.setBackgroundResource(R.drawable.bordertopost);//add the rectangle for each post
        writePost= (EditText) findViewById(R.id.writePostHOD) ;
        String text=writePost.getText().toString();//get text of post from EditText
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
        Button message;
        message=(Button) findViewById(R.id.messageHOD);
        message.setVisibility(View.GONE);
    }
     private void addElementInSpinner(){
         select=(Spinner) findViewById(R.id.selectacademicyear);
         select.setOnItemSelectedListener(this);
         ArrayAdapter<CharSequence> degree = ArrayAdapter.createFromResource(this,R.array.academicYear, android.R.layout.simple_spinner_item);
         degree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         select.setAdapter(degree);
     }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=((TextView) view).getText().toString();
        if(!item.equals("Select Academic Year"))
        {
            Intent next=new Intent(HODForHOD.this,GroupOfAcadYearForHOD.class);
            next.putExtra( YEAR,item);
            startActivity(next);
            select.setSelection(0);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
