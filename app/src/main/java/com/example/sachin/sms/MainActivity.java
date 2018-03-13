package com.example.sachin.sms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sachin.sms.Admin.admin_singin;

public class MainActivity extends AppCompatActivity  {
    private  Button stud_main;
    String spemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button admin_main = (Button)findViewById(R.id.admin_menu);
        admin_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,admin_singin.class));
            }
        });


        stud_main = (Button)findViewById(R.id.student_menu);
        stud_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,com.example.sachin.sms.Student.student_signin.class));
            }
        });


    }
}
