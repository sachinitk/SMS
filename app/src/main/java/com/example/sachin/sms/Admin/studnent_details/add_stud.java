package com.example.sachin.sms.Admin.studnent_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sachin.sms.Admin.admin_menu;
import com.example.sachin.sms.R;

public class add_stud extends AppCompatActivity {
    private Button subpro ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stud);

        subpro = (Button)findViewById(R.id.submit_proceed1);
        subpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "Student Added Sucessfully! Redirecting to for futher details fillup";
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(add_stud.this,admin_menu.class));
            }
        });
    }
}
