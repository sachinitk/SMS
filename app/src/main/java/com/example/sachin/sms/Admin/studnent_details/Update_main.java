package com.example.sachin.sms.Admin.studnent_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sachin.sms.R;

public class Update_main extends AppCompatActivity {
    private Button edit_basic;
  private   Button edit_result;
    private Button edit_fees;
    private Button edit_noti;

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

        //go to edit class button
        edit_result = (Button)findViewById(R.id.update_result);
        edit_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_main.this,com.example.sachin.sms.Admin.studnent_details.update.edit_result.class));
            }
        });

        edit_fees = (Button)findViewById(R.id.update_fees);
        edit_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_main.this,com.example.sachin.sms.Admin.studnent_details.update.edit_fees.class));
            }
        });

        edit_result = (Button)findViewById(R.id.update_result);
        edit_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_main.this,com.example.sachin.sms.Admin.studnent_details.update.edit_result.class));
            }
        });

        edit_noti = (Button)findViewById(R.id.notification);
        edit_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_main.this,com.example.sachin.sms.Admin.studnent_details.update.Notification_update.class));
            }
        });
    }

}
