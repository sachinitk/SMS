package com.example.sachin.sms.Admin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.sachin.sms.MainActivity;
import com.example.sachin.sms.R;
import com.example.sachin.sms.SupportClasses.ConfigAdmin;
import com.example.sachin.sms.SupportClasses.Configstu;
import com.example.sachin.sms.SupportClasses.RequestHandler;

import java.util.HashMap;
import java.util.prefs.Preferences;

public class admin_menu extends AppCompatActivity {

    private  Button update_stud,add_stud,delete_stud,bt,bt2,logout;
    private EditText et,et2;
    private String p,dp,spemail;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String usernamef = "usernamepref";
    SharedPreferences sharedPreferences;
   LinearLayout ll,ll1;
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
                bt = new Button(getApplicationContext());
                bt.setText("Proceed");
                ll.addView(bt);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        p = et.getText().toString().trim();
                       // Toast.makeText(getApplicationContext(),p,Toast.LENGTH_SHORT).show();
                       sharedPreferences.edit().putString(usernamef,p).commit();

                        startActivity(new Intent(admin_menu.this, com.example.sachin.sms.Admin.studnent_details.Update_main.class));

                    }
                });
            }
        });
       // setContentView(ll);

        // delete student picture

        ll1 = (LinearLayout)findViewById(R.id.delete_roll);
        delete_stud = (Button)findViewById(R.id.delete_student);

        delete_stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et2 = new EditText(getApplicationContext());
                ll1.addView(et2);
                bt2 = new Button(getApplicationContext());
                bt2.setText("Proceed to delete");
                ll1.addView(bt2);
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dp = et2.getText().toString().trim();
                       // Toast.makeText(getApplicationContext(),dp, Toast.LENGTH_LONG).show();

                        insertdata();

                    }
                });
            }
        });
        SharedPreferences getAdmin = getApplicationContext().getSharedPreferences("adminLogin",MODE_PRIVATE);
        spemail =  getAdmin.getString("email",null);

        logout = (Button)findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences getAdmin1 = getApplicationContext().getSharedPreferences("adminLogin",MODE_PRIVATE);
                SharedPreferences.Editor de = getAdmin1.edit();

                de.clear();
                de.commit();
                String p = getAdmin1.getString("email",null);
                Toast.makeText(getApplicationContext(),p,Toast.LENGTH_SHORT);
                startActivity(new Intent(admin_menu.this, MainActivity.class));

            }
        });


    }

    @Override
    public void onBackPressed(){
        if(spemail != null) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
    }

    private  void insertdata() {


        class delete_student extends AsyncTask<Void,Void,String> {
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
                Toast.makeText(getApplicationContext(),dp, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params)
            {
                HashMap<String,String> hashMap  =new HashMap<>();
                hashMap.put(Configstu.stu_username,dp);

                RequestHandler rh = new RequestHandler();

                return rh.sendPostRequest(ConfigAdmin.admin_delete_stu_url,hashMap);
            }
        }

        delete_student as = new delete_student();
        as.execute();
    }
}
