package com.dam.iam26509397.pt15_daniel_amarillo;

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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFactorialAsync.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFactorialAsync#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFactorialAsync extends Fragment {
    Button but;
    EditText editText;
    TextView textView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentPrimoAsync.OnFragmentInteractionListener mListener;

    public FragmentFactorialAsync() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPrimoAsync.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPrimoAsync newInstance(String param1, String param2) {
        FragmentPrimoAsync fragment = new FragmentPrimoAsync();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_factorial_async, container, false);
        editText = (EditText) v.findViewById(R.id.editText);
        textView = (TextView) v.findViewById(R.id.textView2);
        but = (Button) v.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) v.findViewById(R.id.editText);
                TextView textView = (TextView) v.findViewById(R.id.textView);
                ExAsyncTask aT = new ExAsyncTask();
                aT.execute();
            }
        });

        return v;
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
        if (context instanceof FragmentPrimoAsync.OnFragmentInteractionListener) {
            mListener = (FragmentPrimoAsync.OnFragmentInteractionListener) context;
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

    private class ExAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            Log.d("Execute","execute");
            super.onPreExecute();
            Log.d("Execute","execute2");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                int numero = Integer.parseInt(editText.getText().toString());
                int factorial = 1;
                for (int i=2;i<=numero;i++) {
                    factorial = factorial * i;
                }
                textView.setText(""+factorial);
            } catch (Exception e) {
                Log.d("Factorial", ""+e);
            }

            Log.d("Execute","back");
            if (isCancelled()) {
                return false;
            }


            return true;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("Execute","progress");
        }

        @Override
        protected void onPostExecute(Boolean res) {
            //super.onPostExecute(aVoid);
            Log.d("Execute","post");
            if (res) {
                Log.d("Execute",res+"");
                //Toast.makeText(Fibonacci.this, "Fibonacci ha anat be", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            //Toast.makeText(Fibonacci.this, "Tasca llarga cancelada", Toast.LENGTH_SHORT).show();
        }


        /**public ExAsyncTask() {
         super();
         }*/


    }
}
