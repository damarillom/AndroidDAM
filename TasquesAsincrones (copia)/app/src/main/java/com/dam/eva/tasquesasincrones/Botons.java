package com.dam.eva.tasquesasincrones;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Botons extends AppCompatActivity { //implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            setContentView(R.layout.boto);

            Button boto=(Button) findViewById(R.id.button);
            boto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Pulsado el 1", Toast.LENGTH_SHORT).show();
                }
            });

            Button boto2=(Button) findViewById(R.id.button2);

            //Accés a botons:
            //2.delegate a la classe (this) ,
            //2. he d'implementar View.onClickListener per posar-lo a escoltar --> genera event recollit a onClick(View v)
            //boto2.setOnClickListener(this);

            //1.inline
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

    //3.metode onclick
    //al boto3 li fas un onClick especial, mètode exclusiú per a ell, el que hem fet fins ara
    public void onClick3 (View view) {
        Button boto= (Button) findViewById(R.id.button3);
        if (boto!=null) Log.d("test", "onClick3: ");
        Toast.makeText(getApplicationContext(),"Pulsat3", Toast.LENGTH_SHORT).show();

    }

    //mètode 2.
    public void onClick (View view) {

        switch (view.getId()){
            case (R.id.button):
                //per aqui no entrarà mai doncs sobreescrivim a dalt el mètode onClick
                Toast.makeText(getApplicationContext(),"Polsat1", Toast.LENGTH_SHORT).show();
            case (R.id.button3):
                Toast.makeText(getApplicationContext(),"Polsat3", Toast.LENGTH_SHORT).show();
                //per aqui no entra doncs té mètode exclusiu per a ell
                break;
            case (R.id.button2):
                Toast.makeText(getApplicationContext(),"Polsat2", Toast.LENGTH_SHORT).show();
                break;

        }
    }


}
