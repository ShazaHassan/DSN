package com.example.android.dsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
    }

   /* @Override
    public void onBackPressed() {
        finish();
    }*/

    public void Login(View view) {
        View focusView = new View(this);
        boolean cancel = false;
        username = (EditText) findViewById(R.id.ETUsername);
        password = (EditText) findViewById(R.id.ETPass);
        RadioButton DR = (RadioButton) findViewById(R.id.RBDr);
        RadioButton HOD = (RadioButton) findViewById(R.id.RBHOD);
        RadioButton student = (RadioButton) findViewById(R.id.RBStudent);
        final String Email = username.getText().toString();
        final String pass = password.getText().toString();
        if (student.isChecked()) {
            final List<Student> studentlist = new ArrayList<>();
            final DatabaseReference studentDatabase = FirebaseDatabase.getInstance().getReference("Student");
            studentDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    studentlist.clear();
                    for (DataSnapshot drSnapShot : dataSnapshot.getChildren()) {
                        Student user = drSnapShot.getValue(Student.class);
                        studentlist.add(user);
                    }
                    for (int i = 0; i < studentlist.size(); i++) {
                        String mail = studentlist.get(i).getEmail().toString(), password = studentlist.get(i).getPassword().toString();
                        if (Email.equals(mail)) {
                            if (pass.equals(password)) {
                                Intent group = new Intent(Login.this, GroupOfAcadYearForStudent.class);
                                startActivity(group);
                            } else {
                                Toast.makeText(Login.this, "Worng password", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Not Registed User", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            cancel = false;
            username.setText("");
        } else if (DR.isChecked()) {
            final List<User> drlist = new ArrayList<>();
            final DatabaseReference drDatabase = FirebaseDatabase.getInstance().getReference("Doctor");
            drDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    drlist.clear();
                    for (DataSnapshot drSnapShot : dataSnapshot.getChildren()) {
                        User user = drSnapShot.getValue(User.class);
                        drlist.add(user);
                    }
                    for (int i = 0; i < drlist.size(); i++) {
                        String mail = drlist.get(i).getEmail().toString(), password = drlist.get(i).getPassword().toString();
                        if (Email.equals(mail)) {
                            if (pass.equals(password)) {
                                Intent select = new Intent(Login.this, SelectAcadYear.class);
                                startActivity(select);
                            } else {
                                Toast.makeText(Login.this, "Wrong password", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Not Registed User", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }else if (HOD.isChecked()) {
            final List<User> HODlist = new ArrayList<>();
            final DatabaseReference drDatabase = FirebaseDatabase.getInstance().getReference("HOD");
            drDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HODlist.clear();
                    for (DataSnapshot drSnapShot : dataSnapshot.getChildren()) {
                        User user = drSnapShot.getValue(User.class);
                        HODlist.add(user);
                    }
                    for (int i = 0; i < HODlist.size(); i++) {
                        String mail = HODlist.get(i).getEmail().toString(),
                                password = HODlist.get(i).getPassword().toString();
                        if (Email.equals(mail)) {
                            if (pass.equals(password)) {
                                Intent group = new Intent(Login.this, HODForHOD.class);
                                startActivity(group);
                            } else {
                                Toast.makeText(Login.this, "Wrong password", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Not Registed User", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            cancel=false;
            username.setText("");
        }else
        {
                username.setError("error");
                focusView = username;
                cancel = true;

        }
       if (cancel)
        {
            focusView.requestFocus();
        }

    }

}
