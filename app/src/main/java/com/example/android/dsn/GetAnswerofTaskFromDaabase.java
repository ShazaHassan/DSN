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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by ShazaHassan on 15-May-17.
 */

public class GetAnswerofTaskFromDaabase extends ArrayAdapter<AddTaskAnswerForDatabase> {
    private Activity context;
    private List<AddTaskAnswerForDatabase> answerList;

    public GetAnswerofTaskFromDaabase(Activity context, List<AddTaskAnswerForDatabase> answerList) {
        super(context, R.layout.answer_of_task_for_database, answerList);
        this.context = context;
        this.answerList = answerList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.answer_of_task_for_database, null, true); //take the layout of post for database as template for each element will show
        AddTaskAnswerForDatabase addTaskAnswerForDatabase = answerList.get(position);

        TextView nameStudent=(TextView) listViewItem.findViewById(R.id.TVNameDatabase);
        TextView sec=(TextView) listViewItem.findViewById(R.id.TVSecDatabase);
        TextView taskNo=(TextView) listViewItem.findViewById(R.id.TVTaskNoDatabase);
        TextView file=(TextView) listViewItem.findViewById(R.id.TVFileDatabase);
        nameStudent.setText("Name"+addTaskAnswerForDatabase.getName());
        sec.setText("Sec"+addTaskAnswerForDatabase.getSec());
        taskNo.setText("task NO"+addTaskAnswerForDatabase.getNo());
        file.setText("File"+addTaskAnswerForDatabase.getFile());
        return listViewItem;
    }
}
