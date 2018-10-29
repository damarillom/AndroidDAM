package com.dam.iam26509397.pt13_daniel_amarillo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Proves extends AppCompatActivity {
    //Emulador: Nexus 5X API 27
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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




        //Intent intent = new Intent(this, NavegadorPropi.class);


    }
}
