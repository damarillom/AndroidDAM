package com.dam.iam26509397.pt14_daniel_amarillo_morales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            setContentView(R.layout.boto);

            Button boto = (Button) findViewById((R.id.button));

            boto.setOnClickListener(this);

            /**boto.setOnClickListener(new_View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(),"posat 1", Toast.LENGTH_SHORT);
                }
            });*/
        } catch (Exception e) {

        }






        Button boto2 = (Button) findViewById(R.id.button2);

        boto2.setOnClickListener(this);

        boto2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Boto2", "Boton 2 pulsado");
            }
        });




    }


    public void onClick3 (View v) {
        Toast.makeText(getApplicationContext(), "pulsado 3", Toast.LENGTH_SHORT);
        Log.d("Boto3", "Boton 3 pulsado");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button):
                Toast.makeText(getApplicationContext(), "posat3", Toast.LENGTH_SHORT);
                break;
            case (R.id.button2):
                Toast.makeText(getApplicationContext(), "posat2", Toast.LENGTH_SHORT);
                break;


        }
    }
}
