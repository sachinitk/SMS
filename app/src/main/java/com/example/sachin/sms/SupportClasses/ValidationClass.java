package com.example.sachin.sms.SupportClasses;

import android.util.Patterns;

/**
 * Created by sachin on 1/3/18.
 */

public class ValidationClass {

    public String validateEmail(String email)
    {
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Enter a valid email";
        }
        return  null;
    }

    public  String validatePassword(String password){
        if(password.isEmpty() || password.length()<4 || password.length()>12){
            return "4 to 10 alphanumeric character!";
        }
        return  null;
    }


}
