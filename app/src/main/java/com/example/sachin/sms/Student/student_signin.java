package com.example.sachin.sms.Student;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.sachin.sms.MainActivity;
import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.AppController;
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;
import com.example.sachin.sms.SupportClasses.ValidationClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class student_signin extends AppCompatActivity {
    private EditText emailText, passwordText;
    private Button login;
    private String email, password, ev, pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signin);
        emailText = (EditText) findViewById(R.id.studemt_email);
        passwordText = (EditText) findViewById(R.id.student_password);
        login = (Button) findViewById(R.id.studemt_login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

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
                loading = ProgressDialog.show(student_signin.this, "Addding....", "Waiting...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equalsIgnoreCase("Logined")) {
                    Toast.makeText(student_signin.this, "Login Sucessfull!Welcome", Toast.LENGTH_SHORT).show();
                    getData();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(student_signin.this, s, Toast.LENGTH_LONG).show();
                }
            }


            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                //hashMap.put(Configstu.Customer_name,name);
                hashMap.put(Configstu.stu_email, email);
                // hashMap.put(Configstu.Customer_mobile,mbl);
                hashMap.put(Configstu.stu_pass, password);
                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(Configstu.stu_login_url, hashMap);
            }
        }

        AuthoLogin al = new AuthoLogin();
        al.execute();


    }


    public void getData() {
        String url  = "http://10.50.47.178/SMS/fetch_all.php?email=sachinitk@gmail.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                       // pd.hide();


                        try {

                            JSONArray jsonarray = new JSONArray(response);

                            for(int i=0; i < jsonarray.length(); i++) {

                                JSONObject jsonobject = jsonarray.getJSONObject(i);


                                String id = jsonobject.getString("name");
                                Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();

                               // result.setText(" ID -"+id+"\n Price -"+price+"\n Name -"+name+"\n Phone -"+phone);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();


                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error != null) {

                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );
        AppController.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }




}
