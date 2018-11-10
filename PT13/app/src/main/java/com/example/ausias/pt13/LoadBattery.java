package com.example.ausias.pt13;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LoadBattery extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Log.d("onReceive","antes");

            setContentView(R.layout.activity_alert);

            Log.d("onReceive","antes");

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("onReceive",e.getMessage());
        }

    }

}
