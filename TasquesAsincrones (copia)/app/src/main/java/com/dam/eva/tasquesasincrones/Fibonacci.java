package com.dam.eva.tasquesasincrones;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Fibonacci extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
    }

    public int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public class CalculaFibonacci extends AsyncTask<Integer, Void, Long> {

        @Override
        protected Long doInBackground(Integer... params) {
            return Long.valueOf(fibonacci(params[0]));
        }

        @Override
        protected void onPostExecute(Long resultat){
            super.onPostExecute(resultat);
            TextView numR = (TextView) findViewById(R.id.resFib);
            numR.setText(String.valueOf(resultat));
        }

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

    }

    public void fibRec(View v){
        
//fer
}

    public void fibAsy(View v){
        EditText num = (EditText) findViewById(R.id.nPosTxt);
        int numInt = new Integer(num.getText().toString());
        CalculaFibonacci cFib = new CalculaFibonacci();
        cFib.execute(numInt);
    }
}


