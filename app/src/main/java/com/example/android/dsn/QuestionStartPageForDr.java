package com.example.android.dsn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionStartPageForDr extends AppCompatActivity {

    DatabaseReference databaseNewCh;
    ListView chapterListView;
    List<AddnewChForDatabase> chapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_start_page_for_dr);
        databaseNewCh= FirebaseDatabase.getInstance().getReference("NewChapter");
        chapterListView=(ListView) findViewById(R.id.LVChNo);
        chapterList=new ArrayList<>();
    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseNewCh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                chapterList.clear();
                for (DataSnapshot chSnapShot: dataSnapshot.getChildren()){
                    AddnewChForDatabase addnewChForDatabase=chSnapShot.getValue(AddnewChForDatabase.class);
                    chapterList.add(addnewChForDatabase);
                }
                GetChapterNoFromDatabaseForDr getChapterNoFromDatabase=new
                        GetChapterNoFromDatabaseForDr(QuestionStartPageForDr.this,chapterList);
                chapterListView.setAdapter(getChapterNoFromDatabase);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
