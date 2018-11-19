package com.dam.eva.tasquesasincrones;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button button, button2, button3;

    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setLogoDescription("Toolbar Eva");
            //toolbar.setNavigationIcon(R.drawable.ic_android_black_24dp);
            toolbar.setSubtitle("toolbar");
            //toolbar.setOverflowIcon(R.mipmap.ic_launcher);
            //toolbar.setLogo(R.drawable.ic_android_black_24dp);
            setSupportActionBar(toolbar);


            button = (Button) findViewById(R.id.button);
            button.setOnClickListener(this);

            button2 = (Button) findViewById(R.id.button2);
            button2.setOnClickListener(this);

            button3 = (Button) findViewById(R.id.button3);
            button3.setOnClickListener(this);


            //String method=radioId==R.id.Paypal ? "PayPal" : "Direct";
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            //amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("onCreate: ", e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }





    //1. video broadcast receiver developer.android.com
    // els processos en background de les apps, si no estan controlats al processador de l'usuari, poden ser problematics.
    // En casos de poca memòria, el so ha de passar a memoria i treure aquests processos background, es diu memory thrashing.
    // baixa el rendiment del sistema, i de la app. Un implicit broadcast llença aquests processos, trigger --> declara un event -->
    // en comptes de cridar a una app específica. es perd l'escenari de passar dades a una altre app. en comptes, es té, un
    // broadcast d'una app (nou vídeo o foto)
    // en un manifest, declarat com a static, això pot comportar aixecar una app que no està en execució, només per la oportunitat
    // de respondre.
    // Es perden cicles de RAM valuats per aixecar apps que han de decidir si responen o no al event.
    // Connectivity_change es de les pitjor, pot aixecar fins a 100 apps en minuts, empitjorant el rendiment del dispositiu.

    // Solucio: ja no es declaren com a static receiver al manifest, ja no les engega, ara només
    // han d'estar en execució previament i haver declarat i subscrit el receiver. Però no engegarà la app.
    // Altres solucions són, per Connectivity_change
    // : per planejar un treball o job, JobSchedule o Firebase,  Ja no escoltem passivament, sino que planifiquem
    // en batch tots els treballs i aconseguim un entorn més estable.
    // Per a new_picture o new_video. es treuen per que dificulten l'experiencia de la càmera. Des de l'API 24, nouget., android 7.0
    // JobScheduler s'ha millorat per tal de considerar un trigger els canvis en proveidors de continguts
    // canvi de paradigma, un mon dinamic sense receivers passius que demanen temps de processador que s'hauria de manegar molt millor.


    //exemple amb Thread i exemple amb solucio pura Android AsyncTask,
    // tasques asincrones: 1 fil, taskes una darrera l altre, tema: una que triga un temps, imatge de 10M, a partir 5 segons, dialeg anr
    // esperar o tancar-la , desintal.lar app, solucio: tasca asincrona, un fil paralel al de la interfície d usuari, app principal en un nucli
    // , taskes
    // en paral.lel en altre nucli, que informen quan acaben i actualitzen, taskes pesades en fil apart, no interfereixen ni bloquejen la intefaç d usuari
    // per darrera, al background altra tasca. P.ex tocar pantalla no respondrà.
    // sols Thread, sols pura Android    4 minuts
    // 1. tasca que simula aquest temps d' espera. dura 1 segon, en un try catch, obliga

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(this, "entra 1", Toast.LENGTH_SHORT).show();

                for (int i = 1; i <= 10; i++) {
                    UnSegundo();
                }
                break;
            case R.id.button2:
                //Toast.makeText(this, "entra 2", Toast.LENGTH_SHORT).show();
                Fils();
                //hilos peta pel toast
                //Hilos();
                break;
            case R.id.button3:
                try {
                    //Toast.makeText(this, "entra 3", Toast.LENGTH_SHORT).show();
                    ExAsyncTask aT = new ExAsyncTask();
                    aT.execute();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("onClick: ", e.getMessage());
                }
            default:
                break;

        }
    }

    private void UnSegundo() {
// espera un segon, tasca per simular el temps que triga

        try {

            //agafa el fil actual i el posa a dormir
            Thread.sleep(1000);  //milisegons    --- 1 segon

        } catch (InterruptedException e) {

        }


    }


    private void Hilos() {
        //cal generar el Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                //fa error
                for (int i = 1; i <= 10; i++) {
                    UnSegundo();
                }
                Toast.makeText(getBaseContext(), "Tasca llarga ended", Toast.LENGTH_SHORT).show();
            }
        }).start(); //en acabar de run, començarà
    }

    private void Fils() {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //faig primer mini-error, peta perque no pot fer toast, pq Thread no pot interactuar amb la interfaç d'usuari
                    for (int i = 1; i <= 10; i++) {
                        UnSegundo();
                    }
                    //Toast.makeText(getBaseContext(), "Tasca llarga finalitzada", Toast.LENGTH_SHORT).show();
                    // un tercer fil que es comunica amb el primer, codi ininteligible si et comuniques molt amb user interface


                    runOnUiThread(new Runnable() {
                        @Override
                        //tercer fil que es comunica amb el segon
                        public void run() {
                            Toast.makeText(getBaseContext(), "Tasca llarga finalitzada bé", Toast.LENGTH_SHORT).show();
                        }

                        //ininteligible amb molta comunicació amb l usuari
                        // veure post a Threads

                    });
                }
            }).start();
        } catch (Exception e) {
            Log.d("fils", e.getMessage());
        }

    }

    private class ExAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean res) {
            //super.onPostExecute(aVoid);
            if (res)
                Toast.makeText(MainActivity.this, "Tasca llarga acabada a AsyncTask", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(MainActivity.this, "Tasca llarga cancelada a AsyncTask", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for (int i = 1; i <= 10; i++) {
                UnSegundo();
                publishProgress(i * 10);
                if (isCancelled()) {
                    break;
                }
            }
            return true;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.menuExamen) {

            try {
                Intent al = new Intent(this, Examen.class);
                this.startActivity(al);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onReceive", "Error: " + e.getMessage());

            }
        } else if (id == R.id.menuCalculadora) {
            try {
                Intent al = new Intent(this, Calculadora.class);
                this.startActivity(al);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onReceive", "Error: " + e.getMessage());

            }
        } else if (id == R.id.menuGestures) {
            try {
                Intent al = new Intent(this, Gestures.class);
                this.startActivity(al);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onReceive", "Error: " + e.getMessage());

            }

        } else if (id == R.id.menuFib) {
            try {
                Intent al = new Intent(this, Fibonacci.class);
                this.startActivity(al);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onReceive", "Error: " + e.getMessage());

            }
        } else if (id == R.id.menuBotons) {
            try {
                Intent al = new Intent(this, Botons.class);
                this.startActivity(al);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onReceive", "Error: " + e.getMessage());

            }
        }
        return true;
    }
}

