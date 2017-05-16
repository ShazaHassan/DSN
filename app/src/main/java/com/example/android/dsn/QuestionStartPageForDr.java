package com.example.android.dsn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.ID;

/**
 * Created by ShazaHassan on 16-May-17.
 */

public class QuestionStartPageForDr extends AppCompatActivity {

    DatabaseReference databaseNewCh;
    ListView chapterListView;
    List<AddnewChForDatabase> chapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_start_page);
        Intent intent=getIntent();
        TextView quTitle= (TextView) findViewById(R.id.TvquestionTitle);
        String ti=intent.getStringExtra("sub");
        quTitle.setText(ti);
        databaseNewCh= FirebaseDatabase.getInstance().getReference("NewChapter");
        chapterListView=(ListView) findViewById(R.id.LVChNo);
        chapterList=new ArrayList<>();
        Button deleteCh=(Button) findViewById(R.id.BDeleteCh);
        deleteCh.setVisibility(View.VISIBLE);
        Button AddCh=(Button) findViewById(R.id.BDeleteCh);

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
                GetChapterNoFromDatabase getChapterNoFromDatabase=new GetChapterNoFromDatabase(QuestionStartPageForDr.this,chapterList);
                chapterListView.setAdapter(getChapterNoFromDatabase);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
