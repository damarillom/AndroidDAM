package com.dam.eva.navigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AsyncFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AsyncFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Button botonFact,botonPrim;
    private EditText ed;
    private TextView res,res2;
    private ProgressBar progressBar ;

    public AsyncFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try {
            View v= inflater.inflate(R.layout.fragment_async, container, false);
            botonPrim=(Button) v.findViewById(R.id.primer);
            botonFact=(Button) v.findViewById(R.id.fact);

            ed =(EditText) v.findViewById(R.id.num);
            res=(TextView) v.findViewById(R.id.res);
            res2=(TextView) v.findViewById(R.id.res2);

            progressBar=(ProgressBar) v.findViewById(R.id.progressBar);

            botonPrim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String numString=ed.getText().toString();
                        //Log.d("test",numString);

                        if (!numString.isEmpty()) {
                            PrimerAsyncTask primerAsyncTask =new PrimerAsyncTask();
                            primerAsyncTask.execute(Float.valueOf(numString));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d( "test","passa que:" + e.getMessage());
                    }
                }
            });

            botonFact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String numString=ed.getText().toString();
                        //Log.d("test",numString);

                        if (!numString.isEmpty()) {
                            FactAsyncTask  factAsync =new FactAsyncTask();
                            factAsync.execute(Float.valueOf(numString));

                            //Integer num = Integer.valueOf(ed.getText().toString());

                            //res.setText(String.valueOf(Factorial(num)));
                            //Toast.makeText(getActivity(), "Això és dins el fragment", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d( "test","passa que:" + e.getMessage());
                    }
                }
            });
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "test","aqui: " + e.getMessage());
            return null;
        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private class PrimerAsyncTask extends AsyncTask<Float, Integer, Boolean> {
        // tarea larga en background
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressBar.setMax(100);
            progressBar.setProgress(0);
            //iniciar vars, objectes, components interfaç
        }


        private boolean esPrimer(float num){
            progressBar.setMax((int) num);
            Boolean esPrimerAct = true;
            if(num<2)
            {
                esPrimerAct = false;
            }
            else
            {
                for(float x=2; x*x<=num; x++)
                {
                    if( num%x==0 ){
                        esPrimerAct = false;break;}
                    else {
                        publishProgress(((int) (x*x)));
                        Log.d("testing", String.valueOf(x*x));
                    }


                }
            }
            return esPrimerAct;
            //Toast.makeText(getActivity(), "és primer" +  String.valueOf(num),Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Boolean doInBackground(Float... params) {
            return esPrimer(params[0]);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());

        }

        //en acabar, carregar dades calculades a la interfície, fer toast d'errors, etc.
        @Override
        protected void onPostExecute(Boolean resultat) {
            //super.onPostExecute(aVoid);
            // TextView numR = (TextView) findViewById(R.id.res);
            String re=resultat? "És primer":"No és primer";
            //String method = radioId == R.id.PayPal ? "PayPal" : "Direct";

            res2.setText(re);
            res.setText("");

        }

    }

    private class FactAsyncTask extends AsyncTask<Float, Integer, Float> {

        public float Factorial(float num){
            progressBar.setMax((int) num);
            float result = 1;
            for (float factor = 2; factor <= num; factor++) {
                result *= factor;
                publishProgress(((int) (factor)));
                Log.d("testing", String.valueOf(factor));
                UnSegundo(); // retraso mig segon, provo números com 35, no més grans.

            }
            return result;
        }

        private void UnSegundo() {
            try {
                //retraso el fil mig segon per veure la barra com creix, en números grans, cal retrasar menos
                Thread.sleep(500);  //milisegons    --- 1 segon
            } catch (InterruptedException e) {
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setProgress(0);
            res.setText("");
            res2.setText("");

        }

        @Override
        protected Float doInBackground(Float... params) {
            return Factorial(params[0]);
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());

        }

        //en acabar, carregar dades calculades a la interfície, fer toast d'errors, etc.
        @Override
        protected void onPostExecute(Float fact) {
            //super.onPostExecute(aVoid);
           // TextView numR = (TextView) findViewById(R.id.res);
            res.setText(String.valueOf(fact));
            res2.setText("");
        }

        //cancelar bbdd, en tallar execucio segon fil, conexions bbdd, reserva memoria, cancela fent goback, tecla enrere, lliberar memoria
        // surt per aqui o a la de dalt
        @Override
        protected void onCancelled() {
            super.onCancelled();
            //Toast.makeText(MainActivity.this, "Tasca llarga cancelada a AsyncTask", Toast.LENGTH_SHORT).show();
            //Log.d("test", "onCancelled ");

        }


    }


}
