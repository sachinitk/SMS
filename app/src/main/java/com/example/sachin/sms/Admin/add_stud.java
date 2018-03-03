package com.example.sachin.sms.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

            }
        });
    }
}
