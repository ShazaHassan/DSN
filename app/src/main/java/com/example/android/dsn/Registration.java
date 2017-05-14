package com.example.android.dsn;

import android.support.annotation.NonNull;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.dsn.R.layout.user;

public class Registration extends AppCompatActivity {
   private EditText username,email,password,repeat;
    DatabaseReference databaseUser;
    ListView listViewUser,listViewID;
    List<RegistrationForDatabase> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        databaseUser=FirebaseDatabase.getInstance().getReference("Student");
        listViewUser=(ListView) findViewById(R.id.list_item);
        listViewID=(ListView) findViewById(R.id.ListID);
        userList=new ArrayList<>();
        username = (EditText) findViewById(R.id.ETusername);
        email= (EditText) findViewById(R.id.ETemail);
        password=(EditText) findViewById(R.id.ETPass);
        repeat= (EditText) findViewById(R.id.ETrepeatpassword);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseUser.addValueEventListener  (new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userList.clear();

                for(DataSnapshot userSnapShot: dataSnapshot.getChildren()){
                    RegistrationForDatabase registrationForDatabase=userSnapShot.getValue(RegistrationForDatabase.class);
                    userList.add(registrationForDatabase);
                }
                User user111=new User(Registration.this,userList);
                listViewID.setAdapter(user111);

                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseUser.addValueEventListener  (new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userList.clear();

                for(DataSnapshot userSnapShot: dataSnapshot.getChildren()){
                    RegistrationForDatabase registrationForDatabase=userSnapShot.getValue(RegistrationForDatabase.class);
                    userList.add(registrationForDatabase);
                }
                UserID user111=new UserID(Registration.this,userList);
                listViewUser.setAdapter(user111);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void GoToLogin(View view) {

            String name=username.getText().toString().trim();
            String mail=email.getText().toString().trim();
            String pass=password.getText().toString().trim();
            String rep=repeat.getText().toString().trim();
        if(TextUtils.isEmpty(mail)){
            Toast.makeText(this,"please insert mail",Toast.LENGTH_LONG).show();
        }if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"please insert pass",Toast.LENGTH_LONG).show();
        }if(TextUtils.isEmpty(rep)){
            Toast.makeText(this,"please insert repeat mail",Toast.LENGTH_LONG).show();
        }if(pass.equals(rep)){
            String id=databaseUser.push().getKey();
            RegistrationForDatabase registrationForDatabase= new
                    RegistrationForDatabase();
            registrationForDatabase.setUserID(id);
            registrationForDatabase.setUserName(name);
            registrationForDatabase.setEmail(mail);
            registrationForDatabase.setPassword(pass);
            databaseUser.child(id).setValue(registrationForDatabase);
            Toast.makeText(this,"done",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Registration.this,"not match password",Toast.LENGTH_LONG).show();

        }
       /* Intent StartLoginActivity = new Intent(Registration.this, Login.class);
        startActivity(StartLoginActivity);*/
    }
}
