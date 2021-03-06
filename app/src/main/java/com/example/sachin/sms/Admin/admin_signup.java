package com.example.sachin.sms.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sachin.sms.MainActivity;
import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.ConfigAdmin;
import com.example.sachin.sms.SupportClasses.RequestHandler;
import com.example.sachin.sms.SupportClasses.ValidationClass;

import java.util.HashMap;

public class admin_signup extends AppCompatActivity {
   private  Button gologin,btnsingup;
   private EditText emailText,passwordText,nameText,instpasswordText;
   String email,password,ev,instipassword,name,pv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);
        nameText = (EditText) findViewById(R.id.admin_name);
        instpasswordText = (EditText)findViewById(R.id.admin_institute_password);
        btnsingup = (Button)findViewById(R.id.admin_signup_btn);
        emailText= (EditText)findViewById(R.id.admin_email);
        passwordText = (EditText)findViewById(R.id.admin_password);

        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           name = nameText.getText().toString().trim();
           instipassword = instpasswordText.getText().toString().trim();
                login();
            }
        });


        // go to login button
          gologin = (Button)findViewById(R.id.admin_gologin);
        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admin_signup.this,admin_signup.class));
            }
        });

    }
    public void login() {
        ValidationClass vc = new ValidationClass();
        email = emailText.getText().toString().trim();
        password = passwordText.getText().toString().trim();
        ev = vc.validateEmail(email);
        pv = vc.validatePassword(password);
        if (ev != null) {
            emailText.setError(ev);
            return;
        } else if (pv != null) {
            passwordText.setError(pv);
        }
        authLogin();


    }

    public void authLogin() {
        class AuthoLogin extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(admin_signup.this, "Addding....", "Waiting...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("Registration Successfully"))
                {
                    Toast.makeText(admin_signup.this, "signup Sucessfull!Welcome", Toast.LENGTH_SHORT).show();
                    //getData();
                    Intent i = new Intent(getApplicationContext(),admin_menu.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(admin_signup.this, s, Toast.LENGTH_LONG).show();
                }
            }


            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();
                hashMap.put(ConfigAdmin.admin_name,name);
                hashMap.put(ConfigAdmin.admin_email,email);
                 hashMap.put(ConfigAdmin.admin_institute_token,instipassword);
                hashMap.put(ConfigAdmin.admin_pass,password);
                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(ConfigAdmin.admin_signup_url,hashMap);
            }
        }

        AuthoLogin  al = new AuthoLogin();
        al.execute();


    }
}
