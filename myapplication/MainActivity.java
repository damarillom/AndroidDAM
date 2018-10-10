package com.dam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.dam.myapplication.MESSAGE";

    Button boton;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //alternativa 1, amb bundle
    /** Called when the user taps the Send button */
    public void Send(View view) {
        texto = (EditText) findViewById(R.id.editText);
        boton= (Button) findViewById(R.id.button);
        //intent explícit entre activites
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //ho fem amb variable bundle
        Bundle b= new Bundle();
        b.putString("Nombre", texto.getText().toString());
        intent.putExtras(b);
        //passar més variables...
        startActivity(intent);
    }


    public void Ajuda(View view){e

        Intent intent = new Intent(this, AjudaActivity.class);

        //passem amb variable public static final
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);

    }



    public void Calculator (View view){
        EditText e1 = (EditText) findViewById(R.id.editText2);
        EditText e2 = (EditText) findViewById(R.id.editText3);
        TextView res = (TextView) findViewById(R.id.textView);

        int num= Integer.parseInt(e1.getText().toString());
        int num2= Integer.parseInt(e2.getText().toString());
        int sum= num+num2;
        res.setText(Integer.toString(sum));


    }
    //exercici extra: passar més variables per bundle o per claus id,valor .....

}
