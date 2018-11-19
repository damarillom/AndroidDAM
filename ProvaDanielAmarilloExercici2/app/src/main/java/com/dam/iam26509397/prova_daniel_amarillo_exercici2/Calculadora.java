package com.dam.iam26509397.prova_daniel_amarillo_exercici2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.prefs.Preferences;

public class Calculadora extends AppCompatActivity {
    //Daniel Amarillo Morales
    //amarilleitor96@gmail.com
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_cientific);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        Log.d("CreateOptionsMenu", "CreateOpetionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.preferences)  {
            Log.d("OnOptionsItemsSelected", ""+id);
            //Esta linea falla y no entiendo el porque
            startActivity(new Intent(this, Preferences.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);

        if (settings.getBoolean("mode", true)) {
            setContentView(R.layout.activity_calculadora_cientific);
        } else {
            setContentView(R.layout.activity_calculadora);
        }
    }

    public void fib(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        int fib = 0;
        Log.d("Function fib", "Function fib");
        try {
            fib = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        if (fib > 1) {
            //El metodo de java fibonacci(int) no compila
            //fib = fibonacci(fib-1) - fibonacci(fib-2);
            Log.d("fib", "fib");
            fib = (fib-1) - (fib-2);
        }
        editText.setText(""+fib);
    }
}
