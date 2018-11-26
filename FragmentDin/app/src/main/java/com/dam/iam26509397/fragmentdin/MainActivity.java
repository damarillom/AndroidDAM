package com.dam.iam26509397.fragmentdin;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BlankFragment.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener {

    Button boton, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton=(Button) findViewById(R.id.button);
        boton.setOnClickListener(this);

        boton2=(Button) findViewById(R.id.button2);
        boton2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        boolean fragmentTrans = false;
        Fragment fragment=null;
        switch (v.getId()) {
            case (R.id.button) :
                fragmentTrans = true;
                //FragmentManager fragmentManager=getSupportFragmentManager();
                //FragmentTransaction transaction=fragmentManager.beginTransaction();
                //BlankFragment fragment= new BlankFragment();
                fragment= new BlankFragment();
                //transaction.add(R.id.layoutPrincipal, fragment);
                //transaction.addToBackStack(null);
                //transaction.commit();

                break;
            case (R.id.button2):
                fragmentTrans=true;
                fragment = new Fragment2();
                break;

            default:

                break;


        }
        if (fragmentTrans) {
            getSupportFragmentManager().beginTransaction().replace(R.id.layoutPrincipal, fragment).addToBackStack(null).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
