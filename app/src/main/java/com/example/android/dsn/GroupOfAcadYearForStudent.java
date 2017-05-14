package com.example.android.dsn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaza Hassan on 02-May-17.
 */

public class GroupOfAcadYearForStudent extends AppCompatActivity implements GroupOfAcadYear,AdapterView.OnItemSelectedListener {
    private EditText writePost;
    DatabaseReference databasePost;
    ListView listViewPost;
    List<PutPostInDatabase> postList;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_group_of_acad_year);
       databasePost= FirebaseDatabase.getInstance().getReference("post");
       listViewPost=(ListView)  findViewById(R.id.LVPost);
       postList=new ArrayList<>();
       addElementInSpinnerOfSubject();
       editInElement();

   }

   /* @Override
    public void onBackPressed() {

    }*/

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
                GetPostFromDatabase getPostFromDatabase= new GetPostFromDatabase(GroupOfAcadYearForStudent.this,postList);
                listViewPost.setAdapter(getPostFromDatabase);//show the data in arrayList
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

    @Override
    public void writePost(View view) {
        writePost= (EditText) findViewById(R.id.writePost) ;
        String text=writePost.getText().toString();//get text of post from EditText
        writePost.setText("");//clear EditText after add text in group
        if(text.equals(""));
        else {
            writePost.setText("");//clear EditText after add text in group
           //FIRST GIVE ID FOR EVERY ELEMENT IN DATA
            String ID=databasePost.push().getKey();
            //SEND DATA TO CLASS THIS CLASS USE TO SEND DATA TO DATABASE
            PutPostInDatabase putPostInDatabase=new PutPostInDatabase();
            putPostInDatabase.setPost(text);
            putPostInDatabase.setID(ID);

            //ADD THE DATA TO DATABASE
            databasePost.child(ID).setValue(putPostInDatabase);
        }

    }

    @Override
    public void editInElement() {
        Button message=(Button) findViewById(R.id.MessageToRep);
        message.setVisibility(View.GONE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(!item.equals("select subject"))
        {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            Intent registerIntent = new Intent(GroupOfAcadYearForStudent.this, AboutSubjectForStudent.class);
            Spinner select=(Spinner) findViewById(R.id.subjectSelect);
            registerIntent.putExtra("subject",item)  ;
            startActivity(registerIntent);
            select.setSelection(0);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void HODPage(View view) {
        Intent HodPage=new Intent(GroupOfAcadYearForStudent.this,HODForStudent.class);
        startActivity(HodPage);
    }
}
