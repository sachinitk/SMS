package com.example.sachin.sms.Admin.studnent_details.update;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.ConfigAdmin;
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;

import java.util.HashMap;

public class edit_result extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener  {
    private String get_username;
    private EditText edit;
    private String  text;
    private Button submit_gpa;
    SharedPreferences pref;
    RadioGroup rg1;
    String variable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_result);
        edit = (EditText)findViewById(R.id.fill_result);
        pref = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        get_username = pref.getString("usernamepref","no string");
        Toast.makeText(getApplicationContext(),get_username,Toast.LENGTH_SHORT).show();
        rg1 = (RadioGroup)findViewById(R.id.rg_edit_result);
        rg1.setOnCheckedChangeListener(this);

        submit_gpa = (Button)findViewById(R.id.submit_gpa);
        submit_gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text= edit.getText().toString().trim();
                insertdata();
            }
        });
    }
    @Override
    public void onCheckedChanged(RadioGroup group,int checkedId){
        switch (checkedId)
        {
            case  R.id.first:
                variable = "sem1";
                actv(true);
                break;
            case R.id.second:
                variable= "sem2";
                actv(true);
                break;
            case  R.id.third:
                variable = "sem3";
                actv(true);
                break;
            case  R.id.fourth:
                variable= "sem4";
                actv(true);
                break;
            case  R.id.fifth:
                variable = "sem5";
                actv(true);
                break;
            case R.id.sixth:
                variable= "sem6";
                actv(true);
                break;
            case  R.id.seventh:
                variable = "sem7";
                actv(true);
                break;
            case  R.id.eight:
                //token = "address";
                variable= "sem8";
                actv(true);
                break;
        }
    }
    private void actv(final boolean active){
        edit.setEnabled(active);
        if(active){
            edit.requestFocus();
        }
    }
    private  void insertdata() {


        class editBasic extends AsyncTask<Void,Void,String> {
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
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();
                //hashMap.put(Configstu.stu_name,name);
                //hashMap.put(token,variable);
                hashMap.put("var",variable);
                hashMap.put(variable,text);

                hashMap.put(Configstu.stu_username,get_username);

                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(ConfigAdmin.admin_edit_result_url,hashMap);
            }
        }

        editBasic as = new editBasic();
        as.execute();
    }

}
