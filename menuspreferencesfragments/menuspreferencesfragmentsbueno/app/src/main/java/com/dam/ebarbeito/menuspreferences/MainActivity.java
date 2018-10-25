package com.dam.ebarbeito.menuspreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //comento i descomento per veure exemple butons i fragments
        //setContentView(R.layout.activity_maino);
    }

    public void onClickLower(View view) {
        EditText editText = findViewById(R.id.editText);
        editText.setText(editText.getText().toString().toLowerCase());
    }
    public void onClickUpper(View view) {
        EditText editText = findViewById(R.id.editText);
        editText.setText(editText.getText().toString().toUpperCase());
    }

    public void onClickCamel (View view){
       EditText editText=(EditText) findViewById(R.id.editText);
       if (editText.getText().toString().isEmpty())
           return;
        String TAG="onClickCamel";
        String[] camelPart;
        String camel="";
        camelPart=editText.getText().toString().split("\\s");
        for (int i=0;i< camelPart.length;i++) {
            if (i>0) camel+=" ";
            camel +=Character.toUpperCase(camelPart[i].charAt(0));
            camel += camelPart[i].substring(1).toLowerCase();
            Log.d(TAG,camel);
            }

        /*opció B, StringBuilder, no és eficient,no cal construir aquest buffer
        /*camelPart=editText.toString().toLowerCase().split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : camelPart) {
            String resultant = s.substring(0, 1).toUpperCase() + s.substring(1);  //o fer lowercase aquí per cada paraula
            builder.append(resultant + " ");
        }

 */     Log.d("onClickCamel","Camel es: " + camel);
        editText.setText(camel);
//        editText.setText(builder);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mess = sharedPreferences.getString("preference_message", null);

        String currDateTime, currDateTime2 = null;
        TextView txtView= (TextView) findViewById(R.id.textView);
        try {

            android.icu.util.GregorianCalendar cal = new android.icu.util.GregorianCalendar();
            String time=cal.getTime().toString();

            String formattedDate = "no hi ha res";

            SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            formattedDate=df.format(cal.getTime());

            //txtView.setText("Current date and time: " + formattedDate );
            txtView.setGravity(Gravity.CENTER);
            txtView.setTextSize(20);

            currDateTime = SimpleDateFormat.getDateTimeInstance().format(new Date());
            currDateTime2= new SimpleDateFormat("HH:mm:ss").format(new Date());
            txtView.setText("Sense formatar:" + time + ";\n Spanish way:"+formattedDate + ";\n A la inglesa" +  currDateTime + ";\n Només hora: " + currDateTime2);

            //forçar error a sota
            SimpleDateFormat data= new SimpleDateFormat();
            //data.format(Date.class);

        } catch (Exception e) {
            e.printStackTrace();

            Log.d("onStart", "Error mess:" + e.getMessage() );
            //Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
        }


        try {
            Toast toast = Toast.makeText(this, mess, Toast.LENGTH_LONG);
            toast.show();
            Log.i("MainActivty", mess);

            LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);

            //layout.setBackgroundColor(Color.parseColor("#80ff80"));

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
