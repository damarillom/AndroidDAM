package com.dam.eva.tasquesasincrones;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Operacio extends AppCompatActivity {

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //extenc aquí
            intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:(+34)666666666"));
            context.startActivity(intent);

        }

        @Override
        protected void finalize() throws Throwable {
            unregisterReceiver(br);
            Log.d("onStart: ", "finalize br");

            super.finalize();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacio);

        IntentFilter filt = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filt.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(br, filt, Manifest.permission.CALL_PHONE, null);

    }

    public void onClickS(View v) {

        try {

            EditText sum = (EditText) findViewById(R.id.editText1);
            String suma1 = sum.getText().toString();

            Intent intent;

            if (suma1.isEmpty()) {
                intent = new Intent(Intent.ACTION_DIAL);
                Toast.makeText(this, "Empty tlfn", Toast.LENGTH_SHORT).show();
                }
            else {
                String tel="tel:(+34)" + suma1;

                intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
                //intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+34)6666666"));
                Toast.makeText(this, suma1, Toast.LENGTH_SHORT).show();

            }
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onClickS: ",e.getMessage()+ " , dades:"); // + suma1+suma2);
        }

    }


    public void onClickBack(View v){

        try {

            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "finish: ",e.getMessage());

        }
    }

    @Override
    public void finish(){
        try {


            String op1 = getIntent().getExtras().getString("op1");
            String op2 = getIntent().getExtras().getString("op2");
            String op3 = getIntent().getExtras().getString("op3");
            Integer res;
            Toast.makeText(this, op3, Toast.LENGTH_LONG).show();
            if (op3.equals("suma")) {
                res = Integer.valueOf(op1) + Integer.valueOf(op2);
                Toast.makeText(this, op3, Toast.LENGTH_LONG).show();

            }
            else {
                res = Integer.valueOf(op1) - Integer.valueOf(op2);
                Toast.makeText(this, op3, Toast.LENGTH_LONG).show();

            }
            Intent intent=new Intent();

            intent.putExtra("resultat",res);
            setResult(RESULT_OK,intent);
            unregisterReceiver(br);
            br=null;
            super.finish();


        } catch (Exception e) {

            e.printStackTrace();
            //si no poso windowActionBar a false al meu tema que ja té Action Bar.
            Log.d("onStart: ", e.getMessage());

        }
    }
}