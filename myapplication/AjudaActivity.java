package com.dam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class AjudaActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        text= (TextView) findViewById(R.id.textAjuda);
        //Bundle b = this.getIntent().getExtras();

        text.setText("T'ajudaré, "+  message);

        Toast.makeText(this, "Usuari: " + message + " creat.", Toast.LENGTH_LONG).show();



    }
}
