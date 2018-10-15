package com.dam.iam26509397.pt1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Tag = "MainActivity";
    public static String EXTRA_MESSAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Tag, "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag, "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void help(View view) {

        Intent intent = new Intent(this, AjudaActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void singUp(View view) {

        Intent intent = new Intent(this, RegistraActivity.class);
        startActivity(intent);

    }

    public void entrar(View view) {
        EditText user = (EditText) findViewById(R.id.editText);
        EditText pass1 = (EditText) findViewById(R.id.editText3);
        if (user.getText().toString().equals("") || pass1.getText().toString().equals("")) {
            Toast.makeText(this, "Error: A field is empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }
    }
}
