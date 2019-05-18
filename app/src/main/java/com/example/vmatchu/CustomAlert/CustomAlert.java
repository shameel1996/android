package com.example.vmatchu.CustomAlert;

import android.content.Context;
import android.support.v7.app.AlertDialog;

public class CustomAlert {
    public static AlertDialog.Builder alert;

    public static void alertDialog(Context context, String message){

        alert = new AlertDialog.Builder(context);
        alert.setMessage(message);
        alert.setPositiveButton("OK",null);
        alert.show();
    }
}
