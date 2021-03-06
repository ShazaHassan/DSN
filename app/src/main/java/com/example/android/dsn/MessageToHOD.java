package com.example.android.dsn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Shaza Hassan on 05-May-17.
 */

public class MessageToHOD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_to_representative);
        editInElement();
    }

    public void sendMessage(View view) {
        LinearLayout messages= (LinearLayout) findViewById(R.id.L3messages);
        TextView message=new TextView(this);
        EditText writeMessage= (EditText) findViewById(R.id.ETwriteMessage);
        String messageWritten=writeMessage.getText().toString();
        writeMessage.setText("");
        message.setText(messageWritten);
        message.setBackgroundResource(R.drawable.bordertomessage);//add the regtangle for each message
        message.setTextColor(Color.WHITE);
        messages.addView(message);
        View view1 =new View(this);//add a line to seperate between two message
        view1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));//set the height and width for line
        view1.setBackgroundColor(Color.WHITE);
        messages.addView(view1);//add line to linear layout

    }
    private void editInElement(){
        TextView head= (TextView) findViewById(R.id.TvmessageTo);
        head.setText("Message To HOD");
    }
}
