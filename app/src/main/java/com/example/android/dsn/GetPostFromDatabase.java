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

import static android.R.attr.name;
import static com.example.android.dsn.R.id.post;

/**
 * Created by ShazaHassan on 14-May-17.
 */

public class GetPostFromDatabase extends ArrayAdapter<PutPostInDatabase> {
    private Activity context;
    private List<PutPostInDatabase> postList;
    public GetPostFromDatabase (Activity context,List<PutPostInDatabase> postList){
        super(context,R.layout.post_for_database,postList);
        this.context=context;
        this.postList=postList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.post_for_database,null,true); //take the layout of post for database as template for each element will show
        TextView Post= (TextView) listViewItem.findViewById(R.id.PostFromDatabase);
        PutPostInDatabase putPostInDatabase=postList.get(position);
        Post.setText(putPostInDatabase.getPost());
        return listViewItem;
    }
}
