package com.dam.iam26509397.pt1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.dam.iam26509397.pt1.MainActivity.EXTRA_MESSAGE;

public class RegistraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra);
    }



    public void crear(View view) {
        EditText user = (EditText) findViewById(R.id.editText2);
        EditText email = (EditText) findViewById(R.id.editText12);
        EditText phone = (EditText) findViewById(R.id.editText11);
        EditText pass1 = (EditText) findViewById(R.id.editText9);
        EditText pass2 = (EditText) findViewById(R.id.editText10);

        if (user.getText().toString().equals("") || email.getText().toString().equals("") || phone.getText().toString().equals("") || pass1.getText().toString().equals("") || pass2.getText().toString().equals("")) {
                Toast.makeText(this, "Error: A field is empty", Toast.LENGTH_SHORT).show();
        } else {
            if (pass1.getText().toString().equals(pass2.getText().toString())) {
                Toast.makeText(this, "user registered", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error: pass no equals", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void help(View view) {

        Intent intent = new Intent(this, AjudaActivity.class);
        startActivity(intent);

    }
}
