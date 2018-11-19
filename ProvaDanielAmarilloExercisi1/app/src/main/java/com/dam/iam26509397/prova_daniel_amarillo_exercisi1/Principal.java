package com.dam.iam26509397.prova_daniel_amarillo_exercisi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    //Daniel Amarillo Morales
    //amarilleitor96@gmail.com
    public int operador1 = 0;
    public int operador2 = 0;
    public String operacio = "suma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        try {
            Intent intent = getIntent();
            String msg = intent.getStringExtra("msg");
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText(msg);
        } catch (Exception e) {

        }
    }

    public void suma(View v) {
        try {
            Log.d("Suma:", "suma");
            Intent op = new Intent(this, Operacio.class);
            EditText editText = (EditText) findViewById(R.id.editText);
            try {
                operador1 = Integer.parseInt(editText.getText().toString());
            } catch (Exception e) {

            }
            EditText editText2 = (EditText) findViewById(R.id.editText2);
            try {
                operador2 = Integer.parseInt(editText2.getText().toString());
            } catch (Exception e) {

            }
            operacio = "suma";
            op.putExtra("operador1", operador1);
            op.putExtra("operador2", operador2);
            op.putExtra("operacio", operacio);
            startActivityForResult(op, 1);
        } catch (Exception e) {
            Log.d("Suma Exception", ""+e);
        }

    }

    public void resta(View v) {
        Log.d("Resta:","Resta");
        Intent op = new Intent(this, Operacio.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        try {
            operador1 = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        try {
            operador2 = Integer.parseInt(editText2.getText().toString());
        } catch (Exception e) {

        }
        operacio = "resta";
        op.putExtra("operador1", operador1);
        op.putExtra("operador2", operador2);
        op.putExtra("operacio", operacio);
        startActivityForResult(op,1);

    }
}
