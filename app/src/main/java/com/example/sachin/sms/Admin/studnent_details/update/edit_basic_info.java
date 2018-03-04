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
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;

import java.util.HashMap;

import static com.example.sachin.sms.SupportClasses.ConfigAdmin.admin_add_stud_url;

public class edit_basic_info extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
        private String get_username;
    private RadioGroup rg1;
    private EditText edit;
    private Button submit;
    String email,token,text,variable;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_basic_info);
        pref = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        get_username = pref.getString("usernamepref","no string");
        Toast.makeText(getApplicationContext(),get_username,Toast.LENGTH_SHORT).show();

        rg1 = (RadioGroup)findViewById(R.id.rg_edit_basic);
        rg1.setOnCheckedChangeListener(this);
        edit = (EditText)findViewById(R.id.basic_fill);
        submit = (Button)findViewById(R.id.submit_basic);
        actv(false);
        text  = edit.getText().toString().trim();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertdata();
                Toast.makeText(getApplicationContext(),"if you want to edit more click else press backspace",Toast.LENGTH_LONG).show();
            }
        });
    }




    @Override
    public void onCheckedChanged(RadioGroup group,int checkedId){
        switch (checkedId)
        {
            case  R.id.edit_stud_email:
             token = "email";
             variable = Configstu.stu_email;
            actv(true);
            break;
            case R.id.edit_stud_mobile:
                token = "mobile";
                variable= Configstu.stu_mobile;
                actv(true);
                break;
            case  R.id.edit_stud_password:
                token = "password";
                variable = Configstu.stu_pass;
                actv(true);
                break;
            case  R.id.edit_stud_address:
                token = "address";
                variable= Configstu.stu_addr;
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
                // Toast.makeText(SignUp.this, s, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();
                //hashMap.put(Configstu.stu_name,name);
                hashMap.put(token,variable);
                hashMap.put(variable,text);
                hashMap.put(Configstu.stu_username,get_username);

                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(admin_add_stud_url,hashMap);
            }
        }

        editBasic as = new editBasic();
        as.execute();
    }

}