package com.example.sachin.sms.Student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sachin.sms.MainActivity;
import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.DownloadTask;

public class stu_main extends AppCompatActivity {
     private Button view_basic, view_fees, view_result, view_message, view_attendance, view_time_table, stu_logout;
     final Context context =this;

     String URL = "http://10.50.46.108/SMS/down.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main);
        view_basic = (Button) findViewById(R.id.view_basic_info);
        view_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,View_basic.class));
            }
        });
        view_fees = (Button) findViewById(R.id.view_fees);
        view_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,view_fees_details.class));
            }
        });
        view_result = (Button) findViewById(R.id.view_result);
        view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this, com.example.sachin.sms.Student.view_result.class));
            }
        });
        view_message = (Button) findViewById(R.id.view_message);
        view_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(stu_main.this,stu_main.class));
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                SharedPreferences sh = getApplicationContext().getSharedPreferences("Sach",MODE_PRIVATE);
                String p = sh.getString("val6",null);
                alertDialogBuilder.setTitle(p);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        });
        /*
        view_attendance = (Button) findViewById(R.id.view_attendance);
        view_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this,stu_main.class));
            }
        });*/
        view_time_table = (Button) findViewById(R.id.view_timetable);
        view_time_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(stu_main.this,stu_main.class));
                new DownloadTask(stu_main.this, URL);
            }
        });
        stu_logout = (Button) findViewById(R.id.stud_logout);
        stu_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(stu_main.this, MainActivity.class));
            }
        });


    }
}