package com.example.android.dsn;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ShazaHassan on 14-May-17.
 */

public class GetTaskFromDatabase extends ArrayAdapter<AddTaskToDatabase> {
    private Activity context;
    private List<AddTaskToDatabase> taskList;
    public GetTaskFromDatabase (Activity context,List<AddTaskToDatabase> taskList){
        super(context,R.layout.task_for_database,taskList);
        this.context=context;
        this.taskList=taskList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.task_for_database,null,true); //take the layout of post for database as template for each element will show

        TextView taskNo= (TextView) listViewItem.findViewById(R.id.TVTaskNoDatabase);
        TextView taskDesc= (TextView) listViewItem.findViewById(R.id.TVTaskDescDatabase);
        TextView taskDeadline= (TextView) listViewItem.findViewById(R.id.TVTaskDeadlineDatabase);

        //set text in textView in which in template layout
        AddTaskToDatabase addTaskToDatabase=taskList.get(position);
        taskNo.setText("Task Number:"+addTaskToDatabase.getTaskNo());
        taskDesc.setText("Task Description:"+addTaskToDatabase.getTaskDescription());
        taskDeadline.setText("Task Deadline:"+addTaskToDatabase.getTaskDeadline());
        return listViewItem;
    }
}
