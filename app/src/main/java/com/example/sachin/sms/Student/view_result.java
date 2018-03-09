package com.example.sachin.sms.Student;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sachin.sms.R;

import java.util.ArrayList;

public class view_result extends AppCompatActivity {
    private String sem,sgpa;
    ArrayList<String> semlist;
   private LinearLayout ll1;
   private Double cgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_string);
        ll1 = (LinearLayout)findViewById(R.id.resultll1);
        SharedPreferences sh = getApplicationContext().getSharedPreferences("Sach",MODE_PRIVATE);
        sem = sh.getString("val5",null);
        int semester =  Integer.parseInt(sem);
        cgpa = 0.0;
        for(int i = 1; i<= semester; i++ )
        {
            sgpa =sh.getString("val"+(9+1),null);
            Float sgpaint = Float.parseFloat(sgpa);
            cgpa += sgpaint;
            TextView t1 = new TextView(this);
            t1.setText("sgpa of sem"+i+":-" +sgpa);
            ll1.addView(t1);
        }
        TextView t2 = new TextView(this);
        t2.setText("CGPA:-" + (cgpa/semester));
        ll1.addView(t2);



    }
}
