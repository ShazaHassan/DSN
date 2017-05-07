package com.example.android.dsn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.attr.id;

/**
 * Created by Shaza Hassan on 05-May-17.
 */

public class AboutSubjectForStudent extends AppCompatActivity implements AboutSubject, AdapterView.OnItemSelectedListener {

    private Spinner others,editContain,editDegree,editTeach,messenger;
    private Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_subject);
        addElementInSpinnerOthers();
        editSomeElementInPage();

    }
    private void editSomeElementInPage(){
        messenger=(Spinner)findViewById(R.id.message);
        messenger.setVisibility(View.GONE);
        editContain=(Spinner)findViewById(R.id.editContain);
        editContain.setVisibility(View.INVISIBLE);
        editDegree=(Spinner) findViewById(R.id.editDegree);
        editDegree.setVisibility(View.INVISIBLE);
        editTeach=(Spinner) findViewById(R.id.editTeachassistance);
        editTeach.setVisibility(View.INVISIBLE);
        upload=(Button) findViewById(R.id.uploadSlides);
        upload.setVisibility(View.INVISIBLE);

    }
    @Override
    public void addElementInSpinnerOthers() {
        others =(Spinner) findViewById(R.id.others);
        others.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> other=ArrayAdapter.createFromResource(this, R.array.others,android.R.layout.simple_spinner_item);
        other.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        others.setAdapter(other);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String item = ((TextView) view).getText().toString();
            if(item.equals("Task"))
            {
                others.setSelection(0);
                Intent taskPage = new Intent(AboutSubjectForStudent.this,Task.class);
                startActivity(taskPage);
            }
            else if(item.equals("Questions"))
            {
                others.setSelection(0);
                Intent questionPage=new Intent(AboutSubjectForStudent.this,QuestionStartPage.class);
                TextView title= (TextView) findViewById(R.id.title) ;
                String ti=title.getText().toString();
                questionPage.putExtra("sub",ti);
                startActivity(questionPage);
            }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
