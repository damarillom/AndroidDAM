package com.dam.iam26509397.toolbar;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button, button2, button3;
    private ProgressBar progressBar;

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


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

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
                    //fils();
                    hilos();
                    break;

                case (R.id.button3):
                    ExAsyncTask aT = new ExAsyncTask();
                    Log.d("boton","boton3");
                    aT.execute();
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

    //private void fils() {
    private void hilos() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {

                    UnSegon();
                }
                //aquí el toast fa crash perque la classe Thread no put interactuar amb la UI del usuari
                //Toast.makeText(MainActivity.this, "tasca llarga acabada", Toast.LENGTH_SHORT);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run () {
                        Toast.makeText(MainActivity.this, "tasca llarga acabada bé", Toast.LENGTH_SHORT).show();
                    }
                });
            }



        }).start();


    }



    private class ExAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            Log.d("Execute","execute");
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
            Log.d("Execute","execute2");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for (int i = 1;i<=10;i++) {
                UnSegon();
                publishProgress(i*10);
                Log.d("Execute","back");
                if (isCancelled()) {
                    break;
                }
            }

            return true;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
            Log.d("Execute","progress");
        }

        @Override
        protected void onPostExecute(Boolean res) {
            //super.onPostExecute(aVoid);
            Log.d("Execute","post");
            if (res) {
                Log.d("Execute",res+"");
                Toast.makeText(MainActivity.this, "Tasca larga amb AsyncTask a anat bé", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(MainActivity.this, "Tasca llarga cancelada", Toast.LENGTH_SHORT).show();
        }


        /**public ExAsyncTask() {
            super();
        }*/


    }
}
