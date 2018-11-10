package com.example.ausias.pt13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class ReceiverSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){

        Log.d("onReceive","Entra");
        intent = new Intent("android.media.action.IMAGE_CAPTURE");
        context.startActivity(intent);

        /*intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:(+34)666666666"));
        context.startActivity(intent);
*/
        Log.d("onReceive","Surt");

    }

    }
