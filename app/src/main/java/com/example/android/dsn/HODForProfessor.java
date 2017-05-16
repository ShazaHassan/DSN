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

/**
 * Created by Mariam on 05-May-17.
 */

public class HODForProfessor extends AppCompatActivity implements HOD {

    private EditText writePost;
    DatabaseReference databasePost;
    ListView listViewPost;
    List<PutPostInDatabase> postList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);
        databasePost= FirebaseDatabase.getInstance().getReference("HODPost");
        listViewPost=(ListView) findViewById(R.id.LVPostHOD);
        postList=new ArrayList<>();
        editInElement();
    }

    public void writePost(View view) {
        writePost= (EditText) findViewById(R.id.ETwritePostHOD) ;
        String text=writePost.getText().toString();//get text of post from EditText
        writePost.setText("");
        if(text.equals(""));
        else {
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
                GetPostFromDatabaseForHOD getPostFromDatabase= new GetPostFromDatabaseForHOD(HODForProfessor.this,postList);
                listViewPost.setAdapter(getPostFromDatabase);//show the data in arrayList
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
