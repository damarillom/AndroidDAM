package com.dam.eva.navigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentCamera.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentCamera#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCamera extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button botonFragment;
    private EditText ed;
    private TextView res;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentCamera() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCamera.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCamera newInstance(String param1, String param2) {
        FragmentCamera fragment = new FragmentCamera();
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
        // Inflate the layout for this fragment
        try {
            View v= inflater.inflate(R.layout.fragment_camera, container, false);
            botonFragment=(Button) v.findViewById(R.id.primer);
            ed =(EditText) v.findViewById(R.id.num);
            res=(TextView) v.findViewById(R.id.res);
            //objeto no en vista
            botonFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String numString=ed.getText().toString();
                        //Log.d("test",numString);

                        if (!numString.isEmpty()) {
                            Integer num = Integer.valueOf(ed.getText().toString());
                            //Log.d("test",String.valueOf(num));

                            if (esPrimer(num)) {
                                res.setText("És primer");
                            }
                            else res.setText("No és primer");

                            //getActivity perque, no getContext ni this perque...
        //                    Toast.makeText(getActivity(), "Això és dins el fragment", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d( "test",e.getMessage());
                    }
                }
            });
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "test",e.getMessage());
            return null;
        }

    }

    public boolean esPrimer(int num){
        //Log.d("test",String.valueOf(num));

        Boolean esPrimerAct = true;
        if(num<2)
        {
            esPrimerAct = false;
        }
        else
        {
            for(int x=2; x*x<=num; x++)
            {
                if( num%x==0 ){
                    esPrimerAct = false;break;}
            }
        }
        return esPrimerAct;
        //Toast.makeText(getActivity(), "és primer" +  String.valueOf(num),Toast.LENGTH_SHORT).show();


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
}
