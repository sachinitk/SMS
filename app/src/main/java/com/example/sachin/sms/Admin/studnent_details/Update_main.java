package com.example.sachin.sms.Admin.studnent_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sachin.sms.R;

public class Update_main extends AppCompatActivity {
    Button edit_basic;
    Button edit_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_main);
        edit_basic = (Button)findViewById(R.id.edit_basic);
        edit_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_main.this,com.example.sachin.sms.Admin.studnent_details.update.edit_basic_info.class));
            }
        });
    }
}
