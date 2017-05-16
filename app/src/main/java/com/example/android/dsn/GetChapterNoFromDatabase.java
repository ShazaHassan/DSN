package com.example.android.dsn;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ShazaHassan on 16-May-17.
 */

public class GetChapterNoFromDatabase extends ArrayAdapter<AddnewChForDatabase> {
    private Activity context;
    private List<AddnewChForDatabase> chList;

    public GetChapterNoFromDatabase(Activity context, List<AddnewChForDatabase> chList) {
        super(context, R.layout.new_ch, chList);
        this.context = context;
        this.chList = chList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.new_ch, null, true); //take the layout of post for database as template for each element will show
        AddnewChForDatabase addnewChForDatabase = chList.get(position);

        Button chNO=(Button) listViewItem.findViewById(R.id.BChNoDatabase);
        chNO.setText(addnewChForDatabase.getChNO());
        chNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPage=new Intent(context,QuestionForChStudent.class);
                context.startActivity(newPage);

            }
        });
        return listViewItem;
    }
}

class GetChapterNoFromDatabaseForDr extends ArrayAdapter<AddnewChForDatabase> {
    private Activity context;
    private List<AddnewChForDatabase> chList;

    public GetChapterNoFromDatabaseForDr(Activity context, List<AddnewChForDatabase> chList) {
        super(context, R.layout.new_ch, chList);
        this.context = context;
        this.chList = chList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.new_ch, null, true); //take the layout of post for database as template for each element will show
        AddnewChForDatabase addnewChForDatabase = chList.get(position);

        Button chNO=(Button) listViewItem.findViewById(R.id.BChNoDatabase);
        chNO.setText(addnewChForDatabase.getChNO());
        chNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPage=new Intent(context,QuestionForChForDoctor.class);
                context.startActivity(newPage);

            }
        });

        return listViewItem;
    }
}