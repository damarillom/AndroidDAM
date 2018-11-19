package com.dam.eva.tasquesasincrones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Gestures extends AppCompatActivity {

    private static ListView listView;
    private static String[] NAMES=new String[] {"Tom","Jerry","Mary","Jeremy","Leyla","Ana"};
    //adapter between data and the view

    private TextView textView1;

    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_gest);

            textView1=(TextView) findViewById(R.id.textView2);


            listView();

        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "test: ",e.getMessage());
        }

    }

    public void listView() {
    //carrega les dades a la listview
        listView=(ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.name_list,NAMES);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=(String) listView.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), "Posició:" +position + " Valor: " + value, Toast.LENGTH_SHORT).show();
            }
        });


    }



}