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

   private EditText username,password;
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
        View focusView=new View(this);
        boolean cancel=false;
        username=(EditText) findViewById(R.id.ETUsername);
        password=(EditText) findViewById(R.id.ETPass);
        RadioButton DR=(RadioButton) findViewById(R.id.RBDr);
        final String UserName=username.getText().toString();
        final String pass=password.getText().toString();
       /* if (UserName.equals("Student")||UserName.equals("student"))
        {
            Intent login= new Intent(Login.this,GroupOfAcadYearForStudent.class);
            startActivity(login);
            cancel=false;
            username.setText("");
        }
            else */if(DR.isChecked()){
            final List<User> drlist = new ArrayList<>();
            final DatabaseReference drDatabase= FirebaseDatabase.getInstance().getReference("Doctor");
            drDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot drSnapShot: dataSnapshot.getChildren()){
                        User user=drSnapShot.getValue(User.class);
                        drlist.add(user);
                    }
                    for(int i=0;i<drlist.size();i++){
                        if(UserName.equals(drlist.get(i).getEmail().toString())&&pass.equals(drlist.get(i).toString())){

                                Intent select=new Intent(Login.this,SelectAcadYear.class);
                                startActivity(select);

                                Toast.makeText(Login.this,"error password",Toast.LENGTH_LONG).show();

                        }else {
                            Toast.makeText(Login.this,"Not Valid user",Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        /*else if (UserName.equals("HOD")|| UserName.equals("hod")) {
            Intent login= new Intent(Login.this,HODForHOD.class);
            login.putExtra("user",UserName);
            startActivity(login);
            cancel=false;
            username.setText("");
        }/*else
        {
                username.setError("error");
                focusView = username;
                cancel = true;

        }
       /* if (cancel)
        {
            focusView.requestFocus();
        }
*/
    }

}
