package com.example.sachin.sms.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sachin.sms.R;

public class admin_menu extends AppCompatActivity {
    private Button add_stud ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        add_stud = (Button)findViewById(R.id.add_student);

        add_stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admin_menu.this, com.example.sachin.sms.Admin.add_stud.class));
            }
        });
    }
}
