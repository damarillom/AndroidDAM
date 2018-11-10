package com.example.ausias.pt13;
//package com.dam.ebarbeito.pt13;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.dam.ebarbeito.pt13.Botons;
import com.dam.ebarbeito.pt13.CreaUsuari;
import com.dam.ebarbeito.pt13.Learn;
import com.dam.ebarbeito.pt13.User;


public class Proves extends AppCompatActivity {

    // constants que determinen quina sub-activitat crida / retorna
    public static final int SUB_ACTIVITY_CREATE_USER = 10;
    private static final int SUB_ACTIVITY_LEARN = 20;
    private static final int REQUEST_LEARN_MATH=30;
    private User user;
    private BroadcastReceiver br;
    private int eva;


    private BroadcastReceiver br2=new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    //extenc aquí
                    //intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    //context.startActivity(intent);
                    Intent batt = new Intent(context,LoadBattery.class);
                    context.startActivity(batt);

                }

        @Override
        protected void finalize() throws Throwable {
            unregisterReceiver(br2);
            Log.d( "onStart: ", "finalize br2");

            super.finalize();
        }
    };

    @Override
    protected void onStart() {

        br=new ReceptorBattery();
        IntentFilter filt= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filt.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //filt.addAction(Intent.ACTION_BATTERY_LOW);
        registerReceiver(br,filt, Manifest.permission.CALL_PHONE,null);

        //br2=new ReceiverSMS();
        //IntentFilter filt2= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //filt2.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //registerReceiver(br2,filt2);

        super.onStart();
        eva+=1;
        Log.d( "onStart: ", String.valueOf(eva));
    }


    @Override
    protected void onStop() {
        try {
            super.onStop();
            //unregisterReceiver(br);
            //unregisterReceiver(br2);
            Log.d("onStart","onStop passa ");

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("onStop ",e.getMessage());
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proves);
        try {


            Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
            toolbar.setLogoDescription("Toolbar Eva");
            toolbar.setNavigationIcon(R.drawable.ic_android_black_24dp);
            toolbar.setSubtitle("toolbar");
            //toolbar.setOverflowIcon(R.mipmap.ic_launcher);
            //toolbar.setLogo(R.drawable.ic_android_black_24dp);
            setSupportActionBar(toolbar);


        } catch (Exception e) {

            e.printStackTrace();
            //si no poso windowActionBar a false al meu tema que ja té Action Bar.
            Log.d( "onCreate: ",e.getMessage());
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

       /* if (id == R.id.menuItemWeb) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.escoladeltreball.org"));
            startActivity(intent);
            return true;
        }
        else*/ if (id==R.id.alerta) {

            try {
                Intent al = new Intent(this,LoadBattery.class);
                this.startActivity(al);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onReceive", "Error: " + e.getMessage() );

            }
        }
        else if (id==R.id.webview) {
            // provar des de pt12
            try {
                Intent intent=new Intent("com.example.ausias.pt13.Proves");
                String url="http://www.escoladeltreball.org";
                //intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onOptionsItemSelected: ",e.getMessage());

            }
        }
        else if (id == R.id.menuItemShareWhatsApp) {

            EditText editText = (EditText) findViewById(R.id.adrText);
            if (!editText.getText().toString().isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                intent.setType("text/plain");

                intent.setPackage("com.whatsapp");
                Log.d("test", "Invoking whatsapp");

                if (intent.resolveActivity(getPackageManager()) == null) {
                    Log.d("test", "Couldn't find whatsapp:alternatives showing");
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                    intent.setType("text/plain");
                }

                startActivity(intent);
            }
            else Toast.makeText(this, "El text a enviar no pot ser buit", Toast.LENGTH_SHORT).show();
            return  true;
        }


        else if (id == R.id.menuMiss) {
            //View v=null;
            onClickMiss();
            //Intent intent = new Intent(this,MesIntents.class);
            //startActivity(intent);
            return true;
        }


        else if (id == R.id.menuMesIntents) {
            Intent intent = new Intent(this,MesIntents.class);
            startActivity(intent);
            return true;
        }

        else if (id == R.id.menuIUI) {
            try {
                Intent intent = new Intent(this, CreaUsuari.class);
                startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onOptionsItemSelected: ", e.getMessage());
            }
        }
        else if (id == R.id.menuLearn) {
                try {
                    Intent intent = new Intent(this,Learn.class);
                    //AQUÍ no li passem cap paràmetre extra
                    startActivityForResult(intent, SUB_ACTIVITY_LEARN);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("onOptionsItemSelected: ",e.getMessage());
                }
            }

        else if (id == R.id.menuMaths) {
            try {

                Intent i = new Intent(this, Learn.class);
                //aquí ja si li passem l'incremental per segona i consecutives vegades
                i.putExtra("skillLevel", user.getSkillPoints());

                // TODO: 5/11/18
                //per examen, que això vagi a una altre activity....
                startActivityForResult(i, REQUEST_LEARN_MATH);

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("onOptionsItemSelected: ", e.getMessage());
            }
        }
        else if (id == R.id.menuBotons) {
                startActivity(new Intent(this,Botons.class));
            }


        return super.onOptionsItemSelected(item);
    }


    public void onClickMiss() {

        String url = "enviar aquest missatge";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, url);
        intent.setType("text/plain");

        intent.setPackage("com.whatsapp");

        //Verificar si l'intent el podra resoldre algu
        if ((intent.resolveActivity(getPackageManager()) == null)) {
            Toast.makeText(this, "no ha trobat whatsup, mostra alternatives!!!", Toast.LENGTH_SHORT).show();
            //crea un nou intent menys restrictiu, sense setPackage
            //chooser

            Intent intent2 = new Intent(Intent.ACTION_SEND);
            intent2.putExtra(Intent.EXTRA_TEXT, url);
            intent2.setType("text/plain");

            String title = getResources().getString(R.string.chooser_title);
            Intent chooser = Intent.createChooser(intent2, title);

            startActivity(chooser);

            return;
        }
        else
        {Toast.makeText(this, "tot bé, ha trobat whatsup", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
    public void onClickGo(View v) {
        String TAG="test";
        EditText adr = (EditText) findViewById(R.id.adrText);
        String url = adr.getText().toString();
        //Intent mostraWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(adrTxt));

        if (url.isEmpty()) {
            Toast.makeText(this, "Empty url field", Toast.LENGTH_SHORT).show();
            return; }

        //url ha de començar per http, etc,  ben formada
        url=(benFormada(url));
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();


        //provar primer un intent explicit a NavegadorPRopi, salt directe al Webview amb url fixa

        /*Intent intent = new Intent(this,NavegadorPropi.class);
        Log.d("test","Entro");
        intent.setData(Uri.parse(url));
        startActivity(intent);
*/
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            //intent.setData(Uri.parse("http://www.escoladeltreball.org"));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d( "onClickGo: ",e.getMessage()+ " , url és:" + url);
        }

    }

    private String benFormada(String webPage) {

        int valid = 0;
        Uri url = Uri.parse(webPage);

        if ((webPage.toLowerCase().startsWith("http://")) && webPage.toLowerCase().contains("www.") && ((webPage.toLowerCase().endsWith(".com")) ||
                (webPage.toLowerCase().endsWith(".cat")) ||
                (webPage.toLowerCase().endsWith(".es")) ||
                (webPage.toLowerCase().endsWith(".net")) ||
                (webPage.toLowerCase().endsWith(".org")))) {
            valid++;
        } else if ((!webPage.toLowerCase().startsWith("http://")) && (webPage.toLowerCase().startsWith("www.")) && ((webPage.toLowerCase().endsWith(".com")) ||
                (webPage.toLowerCase().endsWith(".cat")) ||
                (webPage.toLowerCase().endsWith(".es")) ||
                (webPage.toLowerCase().endsWith(".net")) ||
                (webPage.toLowerCase().endsWith(".org")))) {
            String httpUrl = "http://";
            url = Uri.parse(httpUrl + webPage);
            valid++;
        } else {
            webPage="http://www." + webPage;
            url = Uri.parse( webPage);
            //url.toString();
            //Toast.makeText(this, "url es:" + url + ", webpage es:" + webPage, Toast.LENGTH_SHORT).show();
            Log.d("onClickGo","url es:" + url.toString() + ", webpage es:" + webPage);
            valid = 1;
        }
        webPage=url.toString();
        return webPage;
    }



    // This is the callback for the started sub-activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SUB_ACTIVITY_CREATE_USER && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String name = extras.getString(User.USER_NAME);
                boolean gender = extras.getBoolean(User.USER_GENDER);
                user = new User(name, gender);
                updateUserInterface();
            }
        }
        if (resultCode == RESULT_OK && (requestCode == SUB_ACTIVITY_LEARN || requestCode==REQUEST_LEARN_MATH)) {
            if (data.hasExtra("skillLevel")) {
                int result = data.getExtras().getInt("skillLevel");
                user.setSkillPoints(result);
                Toast.makeText(this, "New Skill level " + String.valueOf(result), Toast.LENGTH_SHORT).show();
                updateUserInterface();
            }
        }
         }


    private void updateUserInterface() {
        //  show the new user values in the UI
        TextView txtViewL= (TextView) findViewById(R.id.textViewLevel);

        txtViewL.setText(String.valueOf(User.getSkillPoints()));

        TextView txtUser= (TextView) findViewById(R.id.textViewUser);
        txtUser.setText(User.getName());

        Toast.makeText(this, "Punts: " + String.valueOf(User.getSkillPoints()), Toast.LENGTH_SHORT).show();

    }
}

