package com.example.sachin.sms.Student;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
     String email, password, ev, pv;
    String username,name,adress,mobile,message,sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8,total_amnt,due_amnt,fees_message,semester;

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
                    Intent i = new Intent(getApplicationContext(), stu_main.class);
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
        String url  = "http://10.50.46.108/SMS/fetch_all.php?email="+email;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                       // pd.hide();


                        try {

                            JSONArray jsonarray = new JSONArray(response);

                            for(int i=0; i < jsonarray.length(); i++) {

                                JSONObject jsonobject = jsonarray.getJSONObject(i);


                                name  = jsonobject.getString("name");

                                username = jsonobject.getString("username");

                                SharedPreferences pref = getApplicationContext().getSharedPreferences("Sach",MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("val0",email);
                                editor.putString("val1",name);
                                editor.putString("val2",username);



                                //String  ac = pref.getString("val1",null);
                                //Toast.makeText(getApplicationContext(),ac,Toast.LENGTH_SHORT).show();



                               // pref.edit().putString(username,"username").commit();
                               // String s = pref.getString("username",null);
                                adress = jsonobject.getString("address");
                                editor.putString("val3",adress);
                                mobile = jsonobject.getString("phone");
                                editor.putString("val4",mobile);

                               // Toast.makeText(student_signin.this, s, Toast.LENGTH_LONG).show();

                                semester = jsonobject.getString("sem");
                                editor.putString("val5",semester);
                                message = jsonobject.getString("indi_msg");
                                editor.putString("val6",message);

                                total_amnt= jsonobject.getString("total_amnt");
                                editor.putString("val7",total_amnt);

                                due_amnt = jsonobject.getString("due_amnt");
                                editor.putString("val8",due_amnt);

                                fees_message = jsonobject.getString("fee_message");
                                editor.putString("val9",fees_message);
                                sem1 = jsonobject.getString("sem1");
                                editor.putString("val10",sem1);

                                sem2 = jsonobject.getString("sem2");
                                editor.putString("val11",sem2);

                                sem3 = jsonobject.getString("sem3");
                                editor.putString("val12",sem3);

                                sem4 = jsonobject.getString("sem4");
                                editor.putString("val13",sem4);

                                sem5 = jsonobject.getString("sem5");
                                editor.putString("val14",sem5);

                                sem6 = jsonobject.getString("sem6");
                                editor.putString("val15",sem6);

                                sem7 = jsonobject.getString("sem7");
                                editor.putString("val16",sem7);

                                sem8 = jsonobject.getString("sem8");
                                editor.putString("val17",sem8);


                                editor.commit();

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
