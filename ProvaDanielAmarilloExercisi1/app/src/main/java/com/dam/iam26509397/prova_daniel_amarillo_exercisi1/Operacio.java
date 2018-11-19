package com.dam.iam26509397.prova_daniel_amarillo_exercisi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Operacio extends AppCompatActivity {
    TextView tvSum;
    Button btnSendResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacio);


        Log.d("Hola","Estoy en Operacio");
        Intent intent = getIntent();


        int result = 0;
        int operador1 = Integer.parseInt(intent.getStringExtra("operador1"));
        int operador2 = Integer.parseInt(intent.getStringExtra("operador2"));
        String operacio = intent.getStringExtra("operacio");
        //tvSum = (TextView) findViewById(R.id.textView);
        String msg = "";
        if (operacio.equals("suma")) {
            result = operador1 + operador2;
            msg = "La suma de " +operador1+" i "+operador2+" és "+result;
        } else if (operacio.equals("resta")) {
            result = operador1 - operador2;
            msg = "La resta de " +operador1+" i "+operador2+" és "+result;
        }
        Intent prin = new Intent(this, Principal.class);
        prin.putExtra("msg", msg);
        startActivity(prin);

    }


}
