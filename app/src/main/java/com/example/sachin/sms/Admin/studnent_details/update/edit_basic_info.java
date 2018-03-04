package com.example.sachin.sms.Admin.studnent_details.update;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sachin.sms.R;

public class edit_basic_info extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private String op1;
    private String get_username;
    private RadioGroup rg1;
    private EditText edit;
    private Button submit;
    String email;
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
    }




    @Override
    public void onCheckedChanged(RadioGroup group,int checkedId){
        switch (checkedId)
        {
            case  R.id.edit_stud_email:
             change_email();
            actv(true);
            break;
            case R.id.edit_stud_mobile:
                op1 = "call";
                actv(true);
                break;
            case  R.id.edit_stud_password:
                op1 = "cpp";
                actv(true);
                break;
            case  R.id.edit_stud_address:
                op1 = "call";
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

public void change_email(){
        email = edit.getText().toString().trim();

}

}