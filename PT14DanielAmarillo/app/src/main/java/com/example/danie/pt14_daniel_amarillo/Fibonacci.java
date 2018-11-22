package com.example.danie.pt14_daniel_amarillo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fibonacci extends AppCompatActivity implements View.OnClickListener {
    int num, fib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        Button boto = (Button) findViewById(R.id.button);

        boto.setOnClickListener(this);

        boto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Boto", "Boton pulsado");
                fib(v);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button):
                Toast.makeText(getApplicationContext(), "HOLAAAA", Toast.LENGTH_SHORT);
                break;
            case (R.id.button3):
                Toast.makeText(getApplicationContext(), "posat2", Toast.LENGTH_SHORT);
                break;


        }
    }

    public void fib (View v) {
        Log.d("fib", "fib");
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.textView);
        try {
            Log.d("Hola", "hola");
            num = Integer.parseInt(editText.getText().toString());
            if (num >= 0) {

                fib = fibonacci(num);
                Log.d("fib", fib+"");
                textView.setText(""+fib);
            }
        } catch (Exception e) {

        }
    }

    public int fibonacci(int num) {
        Log.d("fibonacci", "fibonacci");
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return (fibonacci(num-1)+fibonacci(num-2));
        }
    }
}
