package com.example.android.dsn;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HODForStudent extends AppCompatActivity implements HOD{
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
                GetPostFromDatabaseForHOD getPostFromDatabase= new GetPostFromDatabaseForHOD(HODForStudent.this,postList);
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
        //hide button to send message
        message=(Button) findViewById(R.id.BmessageHOD);
        message.setVisibility(View.GONE);
        //hide button to upload file
        uploadFiles=(Button) findViewById(R.id.BuploadFilesHOD);
        uploadFiles.setVisibility(View.GONE);
        //hide the spinner to select academic year
        select=(Spinner) findViewById(R.id.Spinnerselectacademicyear);
        select.setVisibility(View.GONE);
        //hide the area to write post
        RelativeLayout AreaToWritePost=(RelativeLayout) findViewById(R.id.R2);
        AreaToWritePost.setVisibility(View.GONE);
    }

}
