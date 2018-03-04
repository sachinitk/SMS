package com.example.sachin.sms.Admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.sachin.sms.R;

public class admin_menu extends AppCompatActivity {
    private Button add_stud ;
    private  Button update_stud;
    private EditText et;
    String p;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String usernamef = "usernamepref";
    SharedPreferences sharedPreferences;
   LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        add_stud = (Button)findViewById(R.id.add_student);
       ll=(LinearLayout)findViewById(R.id.ad_roll);
       sharedPreferences = getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);

        update_stud = (Button)findViewById(R.id.update_student);
        add_stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admin_menu.this, com.example.sachin.sms.Admin.studnent_details.add_stud.class));

            }
        });
        update_stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et = new EditText(getApplicationContext());

                ll.addView(et);
                Button bt = new Button(getApplicationContext());
                bt.setText("Proceed");
                ll.addView(bt);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        p = et.getText().toString().trim();
                       // Toast.makeText(getApplicationContext(),p,Toast.LENGTH_SHORT).show();
                       sharedPreferences.edit().putString(usernamef,p).commit();

                        startActivity(new Intent(admin_menu.this, com.example.sachin.sms.Admin.studnent_details.update.edit_basic_info.class));

                    }
                });
            }
        });
       // setContentView(ll);

    }
}
