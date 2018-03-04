package com.example.sachin.sms.Admin.studnent_details.update;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.ConfigAdmin;
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;

import java.util.HashMap;

public class Notification_update extends AppCompatActivity {
    private String get_username;
    SharedPreferences pref;
    private EditText indi_msg;
    private Button send_msg;
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_update);
        pref = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        get_username = pref.getString("usernamepref","no string");
        indi_msg = (EditText)findViewById(R.id.indi_msg);
        send_msg = (Button)findViewById(R.id.send_msg);
        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = indi_msg.getText().toString().trim();
                insertdata();
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
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();


                hashMap.put(Configstu.indi_msg,msg);
                hashMap.put(Configstu.stu_username,get_username);

                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(ConfigAdmin.admin_send_msg_url,hashMap);
            }
        }

        editBasic as = new editBasic();
        as.execute();
    }
}
