package com.dam.iam26509397.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);


        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case (R.id.button):
                    Log.d("onClick:", "entra1");
                    Toast.makeText(this, "entra 1", Toast.LENGTH_SHORT);
                    for (int i = 1; i <= 2; i++) {

                        UnSegon();
                    }

                    break;
                case (R.id.button2):
                    fils();
                    break;
                case (R.id.button3):

                    break;

            }
        } catch (Exception e) {
            Log.d("onClick:",e.getMessage());
        }
    }

    private void UnSegon(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Log.d("onClick:",e.getMessage());
        }
    }

    private void fils() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {

                    UnSegon();
                }
                Toast.makeText(MainActivity.this, "tasca llarga acabada", Toast.LENGTH_SHORT);
            }

        }).start();
    }
}
