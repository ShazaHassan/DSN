package com.example.android.dsn;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.android.dsn.R.id.post;
import static com.example.android.dsn.R.id.writePost;

public class MessageToRepresentative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_to_representative);
    }

    public void sendMessage(View view) {
        LinearLayout messages= (LinearLayout) findViewById(R.id.L3messages);
        TextView message=new TextView(this);
        EditText writeMessage= (EditText) findViewById(R.id.ETwriteMessage);
        String messageWritten=writeMessage.getText().toString();
        View view1 =new View(this);//add a line to seperate between two message
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the height and width for line
        view1.setBackgroundColor(Color.WHITE);
        message.setBackgroundResource(R.drawable.bordertomessage);//add the regtangle for each message
        message.setTextColor(Color.WHITE);
        if(messageWritten.equals(""));
        else {
            writeMessage.setText("");//clear EditText after send message
            message.setText(messageWritten);
            messages.addView(message);//add add message to window
            messages.addView(view1);//add line to separate between posts
        }

    }
}
