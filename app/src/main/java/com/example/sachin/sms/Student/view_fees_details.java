package com.example.sachin.sms.Student;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sachin.sms.R;

public class view_fees_details extends AppCompatActivity {
    private TextView total_amntText,Due_amntText,fees_messageText;
    private String total_amnt,due_amnt,fees_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fees_details);

        SharedPreferences sh = getApplicationContext().getSharedPreferences("Sach",MODE_PRIVATE);
        total_amnt  = sh.getString("val7",null);
         due_amnt =    sh.getString("val8",null);
     fees_message =   sh.getString("val9",null);
        total_amntText = (TextView)findViewById(R.id.total_amnt_view);
        total_amntText.setText(total_amnt);

       Due_amntText = (TextView)findViewById(R.id.due_amnt_view);
       Due_amntText.setText(due_amnt);

       fees_messageText = (TextView)findViewById(R.id.fees_message_view);
       fees_messageText.setText(fees_message);

    }
}
