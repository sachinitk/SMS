package com.example.sachin.sms.SupportClasses;

import android.os.Environment;

/**
 * Created by sachin on 9/3/18.
 */

public class CheckForSDCard {
    //Check If SD Card is present or not method
    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}