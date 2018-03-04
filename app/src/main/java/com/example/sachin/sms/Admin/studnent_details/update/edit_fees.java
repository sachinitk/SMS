package com.example.sachin.sms.Admin.studnent_details.update;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sachin.sms.Admin.studnent_details.Update_main;
import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.ConfigAdmin;
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;

import java.util.HashMap;

public class edit_fees extends AppCompatActivity {
    private EditText total_amt,due_amt,fees_msg;
    private Button button_fees;
    private String t_amt,d_amt,f_msg;
    private String get_username;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        get_username = pref.getString("usernamepref","no string");
        setContentView(R.layout.activity_edit_fees);
    total_amt = (EditText)findViewById(R.id.total_amount);
    due_amt = (EditText)findViewById(R.id.due_amount);
    fees_msg = (EditText)findViewById(R.id.fees_message);
    button_fees = (Button)findViewById(R.id.btn_submit_fees);
    button_fees.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            t_amt = total_amt.getText().toString().trim();
            d_amt = due_amt.getText().toString().trim();
            f_msg = fees_msg.getText().toString();
            insertdata();
           // startActivity(new Intent(edit_fees.this, Update_main.class));


        }
    });
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
                Toast.makeText(getApplicationContext(), t_amt, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();

               hashMap.put(Configstu.stu_total_amount,t_amt);
               hashMap.put(Configstu.stu_due_amount,d_amt);
               hashMap.put(Configstu.fees_msg,f_msg);
               hashMap.put(Configstu.stu_username,get_username);

                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(ConfigAdmin.admin_edit_fees_url,hashMap);
            }
        }

        editBasic as = new editBasic();
        as.execute();
    }

}
