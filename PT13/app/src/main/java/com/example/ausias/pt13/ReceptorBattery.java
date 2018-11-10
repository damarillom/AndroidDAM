package com.example.ausias.pt13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;


public class ReceptorBattery extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        //Intent main = new Intent(context,Main2Activity.class);
        //context.startActivity(main);

        Log.d("onReceive","Entra");
        //Intent batt = new Intent(context,LoadBattery.class);
        //context.startActivity(batt);

        intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:(+34)666666666"));
        context.startActivity(intent);




    }

}
