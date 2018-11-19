package com.dam.eva.tasquesasincrones;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.InputMismatchException;

public class Calculadora extends AppCompatActivity {

    EditText caixa;
    Button fib;
    String TAG = "Proves";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onCreate: ",e.getMessage());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        if (sharedPreferences.getBoolean("calculator_preference", false)) {

            setContentView(R.layout.layout_cientific);

            caixa = findViewById(R.id.editText5);
            fib = (Button) findViewById(R.id.bFib);
            fib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String numString = caixa.getText().toString();

                    if (numString.trim().length() > 0) {
                        try{
                            int numInt = Integer.parseInt(numString.trim());
                            caixa.setText(String.valueOf(fibonacci(numInt)));

                            Log.d(TAG, "onClick: "+ fibonacci(numInt));
                        } catch (InputMismatchException e) {
                            e.getMessage();
                        }
                    }

                }
            });
        } else{
            setContentView(R.layout.layout_normal);
        }

    }

    public int stringToInteger(String str) {

        return Integer.parseInt(str);
    }

    public int fibonacci (int n) {
        if (n==0) return 0;
        else if (n==1) return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id == R.id.preferences) {
            startActivity(new Intent(this, Preferences.class));

        }


        return super.onOptionsItemSelected(item);
    }
}
