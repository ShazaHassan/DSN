package com.example.android.dsn;

import android.app.Activity;
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
    private List<AddnewChForDatabase> answerList;

    public GetChapterNoFromDatabase(Activity context, List<AddnewChForDatabase> answerList) {
        super(context, R.layout.new_ch, answerList);
        this.context = context;
        this.answerList = answerList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.new_ch, null, true); //take the layout of post for database as template for each element will show
        AddnewChForDatabase addnewChForDatabase = answerList.get(position);

        Button chNO=(Button) listViewItem.findViewById(R.id.BChNoDatabase);
        chNO.setText(addnewChForDatabase.getChNO());

        return listViewItem;
    }
}

