package com.dam.ebarbeito.pt13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ausias.pt13.R;

public class Botons extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            setContentView(R.layout.boto);

            Button boto=(Button) findViewById(R.id.button);
            boto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Pulsado el 1",Toast.LENGTH_SHORT).show();
                }
            });

            Button boto2=(Button) findViewById(R.id.button2);

            //1.inline, 2.delegate, 3.metodo onclick
            boto2.setOnClickListener(this);
            boto2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("botons","clicks:botó 2");


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onCreate: ",e.getMessage());
        }

    }


    //al boto3 li faries un onClick especial, mètode exclusiú per a ell
    public void onClick3 (View view) {
        Button boto= (Button) findViewById(R.id.button3);
        if (boto!=null) Log.d("test", "onClick3: ");
        Toast.makeText(getApplicationContext(),"Pulsat3",Toast.LENGTH_SHORT).show();

    }

    public void onClick (View view) {

        switch (view.getId()){
            case (R.id.button3):
                Toast.makeText(getApplicationContext(),"Polsat3",Toast.LENGTH_SHORT).show();
                break;
            case (R.id.button2):
                Toast.makeText(getApplicationContext(),"Polsat2",Toast.LENGTH_SHORT).show();
                break;

        }
    }


}
