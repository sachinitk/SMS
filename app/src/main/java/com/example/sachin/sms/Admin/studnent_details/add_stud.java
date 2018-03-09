package com.example.sachin.sms.Admin.studnent_details;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sachin.sms.Admin.admin_menu;
import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.ConfigAdmin;
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;

import java.util.HashMap;

import static com.example.sachin.sms.SupportClasses.ConfigAdmin.*;

public class add_stud extends AppCompatActivity {
    private Button subpro ;
    private EditText stud_name,stud_email,stud_username,stud_addr,
                        stud_mobile;
    private Spinner sem;
    String name,email,username,addr,mobile,semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stud);

        stud_name = (EditText)findViewById(R.id.stud_add_name);
        stud_email = (EditText)findViewById(R.id.add_stud_email);
       // stud_password = (EditText)findViewById(R.id.add_stud_password);
        stud_username = (EditText)findViewById(R.id.stud_add_username);
        stud_addr = (EditText)findViewById(R.id.add_stud_address);
        stud_mobile = (EditText)findViewById(R.id.add_stud_mobile);
        sem = (Spinner)findViewById(R.id.sem_choose);


        subpro = (Button)findViewById(R.id.submit_proceed1);
        subpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "Student Added Sucessfully! Redirecting to for futher details fillup";
                insertdata();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(add_stud.this,admin_menu.class));
            }
        });
    }
    private  void insertdata(){
        name = stud_name.getText().toString().trim();
        email = stud_email.getText().toString().trim();
        //password = stud_password.getText().toString().trim();
        username = stud_username.getText().toString().trim();
        mobile = stud_mobile.getText().toString().trim();
        addr = stud_addr.getText().toString().trim();
        semester = sem.getSelectedItem().toString().trim();
        class AddStudent extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
              //  loading = ProgressDialog.show(SignUp.this, "Addding....", "Waiting...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
               // loading.dismiss();
               // Toast.makeText(SignUp.this, s, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();
               hashMap.put(Configstu.stu_name,name);
               hashMap.put(Configstu.stu_email,email);
                hashMap.put(Configstu.stu_username,username);
              //  hashMap.put(Configstu.stu_pass,password);
                hashMap.put(Configstu.stu_addr,addr);
                hashMap.put(Configstu.stu_mobile,mobile);
                hashMap.put(Configstu.stu_sem,semester);

                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(admin_add_stud_url,hashMap);
            }
        }

        AddStudent as = new AddStudent();
        as.execute();
    }
}




