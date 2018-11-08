package com.dam.iam26509397.pt13_daniel_amarillo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Proves extends AppCompatActivity {
    //Emulador: Nexus 5X API 27

    private Context mContext;

    private TextView mTextViewInfo;
    private TextView mTextViewPercentage;
    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;

    private TextView mBatteryLevelText;
    private ProgressBar mBatteryLevelProgress;
    private BroadcastReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_LOW));

        //IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        //mContext.registerReceiver(mBroadcastReceiver,iFilter);
    }

    public void onClickMissatge(View v) {
        String url="vull enviar aquest missatge per whatsup";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,url);
        intent.setType("text/plain");

        intent.setPackage("com.whatsapp");

        if (intent.resolveActivity(getPackageManager())==null) {
            Toast.makeText(this, "no tinc WhatsUp, mostraré alternatives", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(Intent.ACTION_SEND);
            intent2.putExtra(Intent.EXTRA_TEXT,url);
            intent2.setType("text/plain");

            String title = getResources().getString(R.string.chooser_title1);
            Intent chooser=Intent.createChooser(intent2,title);


            //startActivity(intent2);
            startActivity(chooser);
            return;
        }

        startActivity(intent);
    }

    public void openURL(View v) {
        EditText edit = (EditText)findViewById(R.id.editText);
        String url = edit.getText().toString();
        try {
            String urlPart1 = url.substring(0, 11);
            String urlPart2 = url.substring(url.length()-4);
            //Pattern p = Pattern.compile(".\\.es");

            if (url.equals("http://www.escoladeltreball.org")) {
                //Intent intent = new Intent(Proves.this, NavegadorPropi.class);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                //intent.putExtra(Intent.ACTION_VIEW, Uri.parse(url));
                String title = getResources().getString(R.string.chooser_title2);
                Intent chooser=Intent.createChooser(intent,title);
                startActivity(chooser);
            } else if (url.isEmpty()) {
                Toast.makeText(this, "Introduca una URL", Toast.LENGTH_SHORT).show();
            } else if (urlPart1.equals("http://www.") && (urlPart2.equals(".com") || urlPart2.equals(".org") ) ) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                String title = getResources().getString(R.string.chooser_title2);
                Intent chooser=Intent.createChooser(browserIntent,title);
                startActivity(chooser);
            } else {
                Toast.makeText(this, "URL incorrecta", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }


        //Intent intent = new Intent(this, NavegadorPropi.class);


    }



    //private class BatteryBroadcastReceiver extends BroadcastReceiver {
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Bateria baja", Toast.LENGTH_SHORT).show();
            Intent battery = new Intent(Proves.this, BatteryReceiver.class);
            startActivity(battery);
        }
    };


}
