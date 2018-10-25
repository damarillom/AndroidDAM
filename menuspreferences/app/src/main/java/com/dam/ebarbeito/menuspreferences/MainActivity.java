package com.dam.ebarbeito.menuspreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


//Nexus 6 API 27
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickCamel (View view){

        EditText editText = (EditText) findViewById(R.id.editText);
        if (editText.getText().toString().isEmpty())
            return;

        String[] camelPart;
        String camel = "";
        try {
           camelPart = editText.getText().toString().split("\\s");
           for (int i = 0; i < camelPart.length; i++) {
                if (i > 0) camel+= " ";
               camel += Character.toUpperCase(camelPart[i].charAt(0));
               //a = Character.toUpperCase(a);
               camel += camelPart[i].substring(1).toLowerCase();
               //camel += camel + " " ;
               Log.d("onClickCamel", camel);
           }

           //SimpleDateFormat;
           //GregorianCalendar;
           Log.d("onClickCamel", camel);
           editText.setText(camel);
       } catch (Exception e) {
           e.printStackTrace();

       }
    }

    public void onClickUpper (View view){

        EditText editText = (EditText) findViewById(R.id.editText);
        if (editText.getText().toString().isEmpty())
            return;

        String[] camelPart;
        String camel = "";
        try {
            camel = editText.getText().toString().toUpperCase();

            //camelPart = editText.getText().toString().split("\\s");
            /**for (int i = 0; i < camelPart.length; i++) {
                if (i > 0) camel+= " ";
                camel += Character.toUpperCase(camelPart[i].charAt(0));
                //a = Character.toUpperCase(a);
                camel += camelPart[i].substring(1).toLowerCase();
                //camel += camel + " " ;
                Log.d("onClickCamel", camel);
            }*/

            //SimpleDateFormat;
            //GregorianCalendar;
            Log.d("onClickCamel", camel);
            editText.setText(camel);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mess = sharedPreferences.getString("preference_message", null);

        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        //EditText ed=(EditText) findViewById(R.id.editText);


        try {

            GregorianCalendar cal = new GregorianCalendar();
            String time = cal.getTime().toString();
            String formattedDate = "no hi ha res";
            //ho carrego en un textview2
            //necessari per practica pt12

            TextView txtView = (TextView) findViewById(R.id.textView2);

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            formattedDate = df.format(cal.getTime());

            String currDateTime, currDAteTime2 = null;
            currDateTime = SimpleDateFormat.getDateTimeInstance().format(new Date());
            currDAteTime2 = new SimpleDateFormat("HH:mm:ss").format(new Date());

            txtView.setGravity(Gravity.CENTER);
            txtView.setTextSize(20);
            txtView.setText("Sense formatar:" + time +
                    ";\nSpanish way:" + formattedDate +
            ";\n A la inglesa:" + currDateTime + ";\n Només hora:" + currDAteTime2);


            //Toast toast = Toast.makeText(this, mess, Toast.LENGTH_LONG);
            //toast.show();
            //Log.i("MainActivty", mess);

            LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);

            layout.setBackgroundColor(Color.parseColor("#80ff80"));

            if (sharedPreferences.getBoolean("preference_color", false)) {
                layout.setBackgroundColor(Color.BLUE);
            } else {

                layout.setBackgroundColor(Color.GREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("test",e.getMessage());
        }
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menueva,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.preferences)  {
            startActivity(new Intent(this, Preferences.class));
            return true;
        }


        else if(id==R.id.help) {
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://escoladeltreball.org"));
            startActivity(intent);
            return true;
        }
        //return true;
        return super.onOptionsItemSelected(item);
    }
}
