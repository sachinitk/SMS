package com.example.sachin.sms.Student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sachin.sms.R;

public class stu_main extends AppCompatActivity {
     private Button view_basic, view_fees, view_result, view_message, view_attendance, view_time_table, stu_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main);
        view_basic = (Button) findViewById(R.id.view_basic_info);
        view_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });
        view_fees = (Button) findViewById(R.id.view_fees);
        view_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });
        view_result = (Button) findViewById(R.id.view_result);
        view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });
        view_message = (Button) findViewById(R.id.view_message);
        view_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });
        view_attendance = (Button) findViewById(R.id.view_attendance);
        view_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });
        view_time_table = (Button) findViewById(R.id.view_timetable);
        view_time_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });
        stu_logout = (Button) findViewById(R.id.stud_logout);


    }
}