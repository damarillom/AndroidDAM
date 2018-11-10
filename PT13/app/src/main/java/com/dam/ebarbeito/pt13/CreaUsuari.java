package com.dam.ebarbeito.pt13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ausias.pt13.R;

public class CreaUsuari extends AppCompatActivity {
    private EditText userName;
    private boolean male=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.act_creausuari);

            userName = (EditText) findViewById(R.id.username);
            View viewById = findViewById(R.id.female);
            //RadioButton femaleButton = (RadioButton) findViewById(R.id.female);
            //RadioButton maleButton = (RadioButton) findViewById(R.id.male);

            viewById.setAlpha(0.4f);

            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gender);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.male:
                            //femaleButton.setChecked(false);  no cal
                            break;
                        case R.id.female:
                            //maleButton.setChecked(false);
                            male = false;
                            break;
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onCreate: ",e.getMessage());
        }

    }


    public void onClick1(View view) {
        String gen;
        if (male) gen="home";
        else gen="dona";
        Toast.makeText(this, "usuari, creat:"+userName.getText().toString()+ ", Gènere: " +gen, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(User.USER_NAME, userName.getText().toString());
        intent.putExtra(User.USER_GENDER, male);

        setResult(RESULT_OK, intent);
        super.finish();
    }



}

