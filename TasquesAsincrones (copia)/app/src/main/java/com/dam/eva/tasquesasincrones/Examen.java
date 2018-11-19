package com.dam.eva.tasquesasincrones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Examen extends AppCompatActivity implements View.OnClickListener{
    private static final int SUB_ACTIVITY_OPERACIO=10;
    private static final int SUB_ACTIVITY_2 = 20;
    private String tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.activity_examen);

            /*Button boto=(Button) findViewById(R.id.suma);
            boto.setOnClickListener(this);

            Button boto2=(Button) findViewById(R.id.resta);
            boto2.setOnClickListener(this);
*/

        } catch (Exception e) {

            e.printStackTrace();
            //si no poso windowActionBar a false al meu tema que ja té Action Bar.
            Log.d( "onCreate: ",e.getMessage());
        }
    }



    public void onClickS(View v) {

        try {

        EditText sum = (EditText) findViewById(R.id.editText1);
        String suma1 = sum.getText().toString();

        EditText sum2 = (EditText) findViewById(R.id.editText2);
        String suma2 = sum2.getText().toString();

         tip="suma";

            //Toast.makeText(this, "tip és"+ tip, Toast.LENGTH_SHORT).show();

        if (suma1.isEmpty() || suma2.isEmpty()) {
            Toast.makeText(this, "Empty url fields", Toast.LENGTH_SHORT).show();
            return; }

            Intent intent = new Intent(this,Operacio.class);
            intent.putExtra("op1",suma1);
            intent.putExtra("op2",suma2);
            intent.putExtra("op3","suma");
            startActivityForResult(intent,SUB_ACTIVITY_OPERACIO);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onClickGo: ",e.getMessage()+ " , dades:"); // + suma1+suma2);
        }

    }

    public void onClickR(View v) {

        try {

            EditText sum = (EditText) findViewById(R.id.editText1);
            String suma1 = sum.getText().toString();

            EditText sum2 = (EditText) findViewById(R.id.editText2);
            String suma2 = sum2.getText().toString();

            tip="resta";

            //Toast.makeText(this, "tip és"+ tip, Toast.LENGTH_SHORT).show();

            if (suma1.isEmpty() || suma2.isEmpty()) {
                Toast.makeText(this, "Empty url fields", Toast.LENGTH_SHORT).show();
                return; }

            Intent intent = new Intent(this,Operacio.class);
            intent.putExtra("op1",suma1);
            intent.putExtra("op2",suma2);
            intent.putExtra("op3","resta");
            startActivityForResult(intent,SUB_ACTIVITY_OPERACIO);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onClickGo: ",e.getMessage()+ " , dades:"); // + suma1+suma2);
        }

    }


    // This is the callback for the started sub-activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SUB_ACTIVITY_OPERACIO && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Integer resultat= extras.getInt("resultat");
                String res;
                EditText sum = (EditText) findViewById(R.id.editText1);
                String suma1 = sum.getText().toString();

                EditText sum2 = (EditText) findViewById(R.id.editText2);
                String suma2 = sum2.getText().toString();


                res="La " + tip + " de " + suma1+ " i " +suma2+ " és " + String.valueOf(resultat);
                TextView txtUser= (TextView) findViewById(R.id.textViewUser);
                //Toast.makeText(this, res, Toast.LENGTH_SHORT).show();

                txtUser.setText(res);


            }
        }

    }


    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
        case (R.id.suma): tip="suma";
            case (R.id.resta): tip="resta";
        }
        */

    }
}
