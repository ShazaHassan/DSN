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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.dsn.R.id.hod;

/**
 * Created by ShazaHassan on 05-May-17.
 */

public class GroupOfAcadYearForHOD extends AppCompatActivity implements GroupOfAcadYear {


    private LinearLayout addPost;
    private EditText writePost;
    private TextView post;
    ListView listViewPost;
    List<PutPostInDatabase> postList;
    DatabaseReference databasePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_of_acad_year);
        databasePost= FirebaseDatabase.getInstance().getReference("post");
        listViewPost=(ListView)  findViewById(R.id.LVPost);
        postList=new ArrayList<>();
        Intent intent = getIntent();
        String message = intent.getStringExtra(HODForHOD.YEAR);
        TextView textView = (TextView) findViewById(R.id.acadYear);
        textView.setText(message);
        editInElement();
    }
//add data to spinner
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
        writePost= (EditText) findViewById(R.id.writePost) ;
        String text=writePost.getText().toString();//get text of post from EditText
        if(text.equals(""));
        else {
            writePost.setText("");
            //FIRST GIVE ID FOR EVERY ELEMENT IN DATA
            String ID=databasePost.push().getKey();
            //SEND DATA TO CLASS THIS CLASS USE TO SEND DATA TO DATABASE
            PutPostInDatabase putPostInDatabase=new PutPostInDatabase(text,ID);
            //ADD THE DATA TO DATABASE
            databasePost.child(ID).setValue(putPostInDatabase);
        }
    }
    //get data from Database
    @Override
    protected void onStart() {
        super.onStart();
        databasePost.addValueEventListener(new ValueEventListener() {
            //valueEventListener use to auto update when new data inserted in database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postList.clear();//clear arrayList at every print to prevent repeated data when will show to user
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    PutPostInDatabase putPost= postSnapShot.getValue(PutPostInDatabase.class);
                    postList.add(putPost);//store the data that come from database in arrayList
                }
                GetPostFromDatabase getPostFromDatabase= new GetPostFromDatabase(GroupOfAcadYearForHOD.this,postList);
                listViewPost.setAdapter(getPostFromDatabase);//show the data in arrayList
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
