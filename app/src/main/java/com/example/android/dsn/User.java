package com.example.android.dsn;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ShazaHassan on 13-May-17.
 */

public class User extends ArrayAdapter<RegistrationForDatabase> {
    private Activity context;
    private List<RegistrationForDatabase> userList;

    public User(Activity context,List<RegistrationForDatabase> userList){
        super(context,R.layout.user,userList);
     this.context=context;
     this.userList=userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.user,null,true);

        RegistrationForDatabase registrationForDatabase=userList.get(position);

        TextView name=(TextView) listViewItem.findViewById(R.id.usertext);
        TextView mail=(TextView) listViewItem.findViewById(R.id.mail);

        name.setText(registrationForDatabase.getUserName());
        mail.setText(registrationForDatabase.getEmail());
        return  listViewItem;
    }
}




class UserID extends ArrayAdapter<RegistrationForDatabase> {
    private Activity context;
    private List<RegistrationForDatabase> userList;

    public UserID(Activity context,List<RegistrationForDatabase> userList){
        super(context,R.layout.user,userList);
        this.context=context;
        this.userList=userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.user,null,true);

        RegistrationForDatabase registrationForDatabase=userList.get(position);

        TextView name=(TextView) listViewItem.findViewById(R.id.usertext);
        TextView mail=(TextView) listViewItem.findViewById(R.id.mail);

        name.setText(registrationForDatabase.getUserID());
        mail.setText(registrationForDatabase.getPassword());
        return  listViewItem;
    }
}


