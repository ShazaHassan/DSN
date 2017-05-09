package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.android.dsn.R.id.Edit;

public class AboutSubjectForProfessor extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AboutSubject {

    private Spinner editContain, editDegree, editTeach, messenger, others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_subject);
        Intent SubjectName= getIntent();
        String subject=SubjectName.getStringExtra("subject");
        TextView title=(TextView) findViewById(R.id.title) ;
        title.setText(subject);
        addElementInSpinnerContain();
        addElementInSpinnerDegree();
        addElementInSpinnerTeachAssistance();
        addElementInSpinnerMessage();
        addElementInSpinnerOthers();

    }

    //add element spinner of edit for contain
    private void addElementInSpinnerContain() {
        editContain = (Spinner) findViewById(R.id.editContain);
        editContain.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.editContain, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editContain.setAdapter(adapter);

    }

    //add element spinner of edit for degree
    private void addElementInSpinnerDegree() {
        editDegree = (Spinner) findViewById(R.id.editDegree);
        editDegree.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> degree = ArrayAdapter.createFromResource(this, R.array.editDegree, android.R.layout.simple_spinner_item);
        degree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editDegree.setAdapter(degree);

    }

    //add element spinner of edit for teach assistance
    private void addElementInSpinnerTeachAssistance() {
        editTeach = (Spinner) findViewById(R.id.editTeachassistance);
        editTeach.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> teach = ArrayAdapter.createFromResource(this, R.array.editTeach, android.R.layout.simple_spinner_item);
        teach.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editTeach.setAdapter(teach);
    }

    //add element to spinner for message between DR and Staff &DR and representative
    private void addElementInSpinnerMessage() {
        messenger = (Spinner) findViewById(R.id.message);
        messenger.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> message = ArrayAdapter.createFromResource(this, R.array.message, android.R.layout.simple_spinner_item);
        message.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        messenger.setAdapter(message);
    }







    ////add element to spinner of others to go to task and questions page
    @Override
    public void addElementInSpinnerOthers() {
        others = (Spinner) findViewById(R.id.others);
        others.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> other = ArrayAdapter.createFromResource(this, R.array.others, android.R.layout.simple_spinner_item);
        other.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        others.setAdapter(other);
    }

    private void editInContain(View view) {
        TextView containOfCourse = (TextView) findViewById(R.id.textView);
        editContain = (Spinner) findViewById(R.id.editContain);
        editContain.setSelection(0);
        String contain = containOfCourse.getText().toString();
        containOfCourse.setVisibility(View.GONE);
        editContain.setVisibility(View.GONE);
        EditText containEdit = (EditText) findViewById(R.id.Contain);
        Button edit = (Button) findViewById(R.id.EditContain);
        containEdit.setVisibility(View.VISIBLE);
        edit.setVisibility(View.VISIBLE);
        containEdit.setText(contain);
        editDegree(view);
        editTeach(view);

    }

    private void editInDegree(View view) {
        TextView degreeOfCourse = (TextView) findViewById(R.id.degreeOfSub);
        editDegree = (Spinner) findViewById(R.id.editDegree);
        editDegree.setSelection(0);
        String degree = degreeOfCourse.getText().toString();
        degreeOfCourse.setVisibility(View.GONE);
        editDegree.setVisibility(View.GONE);
        EditText EditDegree = (EditText) findViewById(Edit);
        Button edit = (Button) findViewById(R.id.EditDegree);
        EditDegree.setVisibility(View.VISIBLE);
        edit.setVisibility(View.VISIBLE);
        EditDegree.setText(degree);
        editTeach(view);
        editContain(view);
    }

    private void editInTeach(View view) {
        TextView assistanceOfSub = (TextView) findViewById(R.id.editTeachAssistance);
        editTeach = (Spinner) findViewById(R.id.editTeachassistance);
        editTeach.setSelection(0);
        String teachAssistance = assistanceOfSub.getText().toString();
        assistanceOfSub.setVisibility(View.GONE);
        editTeach.setVisibility(View.GONE);
        EditText editTeachAss = (EditText) findViewById(R.id.editTeach);
        Button edit = (Button) findViewById(R.id.EditTeach);
        editTeachAss.setVisibility(View.VISIBLE);
        edit.setVisibility(View.VISIBLE);
        editTeachAss.setText(teachAssistance);
        editDegree(view);
        editContain(view);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;


        if (spinner.getId() == R.id.editContain) {
            String item = ((TextView) view).getText().toString();
            if (item.equals("edit")) {
                editInContain(view);
            }
        } else if (spinner.getId() == R.id.editDegree) {
            String item = parent.getItemAtPosition(position).toString();
            if (item.equals("edit")) {
                editInDegree(view);
            }
        } else if (spinner.getId() == R.id.editTeachassistance) {
            String item = ((TextView) view).getText().toString();
            if (item.equals("edit")) {
                editInTeach(view);
            }
        } else if (spinner.getId() == R.id.message) ;
        {
            String item = ((TextView) view).getText().toString();
            if (item.equals("To Staff") || item.equals("To Representative")) {
                messenger.setSelection(0);
                Intent messagePage = new Intent(AboutSubjectForProfessor.this, MessageToRepresentative.class);
                startActivity(messagePage);
            }

        }
        if (spinner.getId() == R.id.others) {
            String item = ((TextView) view).getText().toString();
            if (item.equals("Task")) {
                others.setSelection(0);
                Intent otherPages = new Intent(AboutSubjectForProfessor.this, TaskPageForDoctors.class);
                startActivity(otherPages);
            }
            else if(item.equals("Questions"))
            {
                others.setSelection(0);
                Intent questionPage=new Intent(AboutSubjectForProfessor.this,QuestionStartPage.class);
                TextView title= (TextView) findViewById(R.id.title) ;
                String ti=title.getText().toString();
                questionPage.putExtra("sub",ti);
                startActivity(questionPage);
            }
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    // when click in edit button the contain of textView will update
    public void editContain(View view) {
        EditText containEdit = (EditText) findViewById(R.id.Contain);//get editText in which update was written
        TextView containOfCourse = (TextView) findViewById(R.id.textView);
        Button edit = (Button) findViewById(R.id.EditContain);
        String contain = containEdit.getText().toString();// get contain of editText
        if(contain.equals("")){
            contain+=containOfCourse.getText().toString();
        }//this for using application for the first time edittext will be empty
        containOfCourse.setText(contain);//add update of textView to contain of subject
        containEdit.setVisibility(View.GONE);//hide the editText
        edit.setVisibility(View.GONE);//hide edit button
        containOfCourse.setVisibility(View.VISIBLE);//visible textView which contain the contain of subject
        editContain = (Spinner) findViewById(R.id.editContain);
        editContain.setVisibility(View.VISIBLE);//show spinner which contain edit option
    }

    public void editDegree(View view) {
        TextView degreeOfCourse = (TextView) findViewById(R.id.degreeOfSub);
        EditText degreeEdit = (EditText) findViewById(R.id.Edit);//get editText in which update was written
        String degree = degreeEdit.getText().toString();// get contain of editText
        if(degree.equals(""))
        {
            degree+=degreeOfCourse.getText().toString();
        }//this for using application for the first time edittext will be empty
        degreeOfCourse.setText(degree);//add update of textView to degree of subject
        Button edit = (Button) findViewById(R.id.EditDegree);
        degreeEdit.setVisibility(View.GONE);//hide the editText
        edit.setVisibility(View.GONE);//hide edit button
        TextView header = (TextView) findViewById(R.id.degree);
        header.setVisibility(View.VISIBLE);//visible textView of degree of subject
        degreeOfCourse.setVisibility(View.VISIBLE);//visible textView which contain the degree of subject
        degreeOfCourse.setText(degree);//add update of textView to degree of subject
        editDegree = (Spinner) findViewById(R.id.editDegree);
        editDegree.setVisibility(View.VISIBLE);//show spinner which contain edit option
    }

    public void editTeach(View view) {
        EditText TeachEdit = (EditText) findViewById(R.id.editTeach);//get editText in which update was written
        TextView teachOfSub = (TextView) findViewById(R.id.editTeachAssistance);
        Button edit = (Button) findViewById(R.id.EditTeach);
        String teach = TeachEdit.getText().toString();// get contain of editText
        if(teach.equals(""))
        {
            teach+=teachOfSub.getText().toString();
        }//this for using application for the first time edittext will be empty
        TeachEdit.setVisibility(View.GONE);//hide the editText
        edit.setVisibility(View.GONE);//hide edit button
        teachOfSub.setVisibility(View.VISIBLE);//visible textView which contain the teach assistance of subject
        teachOfSub.setText(teach);//add update of textView to teach assistance of subject
        editTeach = (Spinner) findViewById(R.id.editTeachassistance);
        editTeach.setVisibility(View.VISIBLE);//show spinner which contain edit option
    }
}
