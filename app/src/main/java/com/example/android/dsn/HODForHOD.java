package com.example.android.dsn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
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
 * Created by Shaza Hassan on 05-May-17.
 */

public class HODForHOD extends AppCompatActivity implements HOD, AdapterView.OnItemSelectedListener {
    private EditText writePost;
    private Spinner select;
    public static final String YEAR = "com.example.android.dsn.MESSAGE";
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
        addElementInSpinner();
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
                GetPostFromDatabaseForHOD getPostFromDatabase= new GetPostFromDatabaseForHOD(HODForHOD.this,postList);
                listViewPost.setAdapter(getPostFromDatabase);//show the data in arrayList
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void editInElement() {
        Button message;
        message=(Button) findViewById(R.id.BmessageHOD);
        message.setVisibility(View.GONE);
    }
     private void addElementInSpinner(){
         select=(Spinner) findViewById(R.id.Spinnerselectacademicyear);
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
