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

public class admin_singin extends AppCompatActivity {
    private EditText emailText,passwordText;
    private Button admin_login;
    String email,password,ev,pv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_singin);

        Button go_Signup = (Button)findViewById(R.id.admin_gosignup_btn);

        go_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admin_singin.this,admin_signup.class));
            }
        });

        emailText  = (EditText)findViewById(R.id.admin_email);
        passwordText = (EditText)findViewById(R.id.admin_password);
        admin_login = (Button)findViewById(R.id.admin_login_btn);
        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //login();
                startActivity(new Intent(admin_singin.this,admin_menu.class));
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
                loading = ProgressDialog.show(admin_singin.this, "Addding....", "Waiting...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("Logined"))
                {
                    Toast.makeText(admin_singin.this, "Login Sucessfull!Welcome", Toast.LENGTH_SHORT).show();
                    //getData();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(admin_singin.this, s, Toast.LENGTH_LONG).show();
                }
            }


            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();
                //hashMap.put(Configstu.Customer_name,name);
                hashMap.put(ConfigAdmin.admin_email,email);
                // hashMap.put(Configstu.Customer_mobile,mbl);
                hashMap.put(ConfigAdmin.admin_email,password);
                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(ConfigAdmin.admin_login_url,hashMap);
            }
        }

        AuthoLogin  al = new AuthoLogin();
        al.execute();


    }
}
