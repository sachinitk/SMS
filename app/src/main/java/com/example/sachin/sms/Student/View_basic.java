package com.example.sachin.sms.Student;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sachin.sms.R;

public class View_basic extends AppCompatActivity {

    private  String name,username,address,email,semester,mobile;
    private TextView stud_name,stud_username,stud_email,stud_semester,stud_address,stud_mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_basic);
       SharedPreferences sh = getApplicationContext().getSharedPreferences("Sach",MODE_PRIVATE);



       name  = sh.getString("val1",null);
       Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
       stud_name = (TextView)findViewById(R.id.stud_name);
       stud_name.setText(name);

       username = sh.getString("val2",null);
       stud_username = (TextView)findViewById(R.id.stud_username);
       stud_username.setText(username);

       address  = sh.getString("val3",null);
       stud_address = findViewById(R.id.stud_address);
       stud_address.setText(address);

         email = sh.getString("val0",null);
        stud_email = (TextView)findViewById(R.id.stud_email);
        stud_email.setText(email);

        semester = sh.getString("val5",null);
        stud_semester = (TextView)findViewById(R.id.stud_semester);
        stud_semester.setText(semester);

        mobile = sh.getString("val4",null
        );
        stud_mobile = (TextView)findViewById(R.id.stud_mobile);
        stud_mobile.setText(mobile);


    }
}
