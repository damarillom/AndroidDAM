package com.example.ausias.pt13;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MesIntents extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 10;
    private Spinner spinner;
    private Bitmap bitmap ;
    private static final int REQUEST_IMAGE_PICK = 40;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            setContentView(R.layout.mes_intents);
//https://developer.android.com/guide/topics/ui/controls/spinner
            spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                    R.array.intents, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
            Log.d("onReceive",e.getMessage());
        }

    }

    public void onClick(View view) {
        int position = spinner.getSelectedItemPosition();
        Intent intent = null;

        try {
            switch (position) {
                case 0:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.gmail.com"));
                    break;
                case 1:

                    intent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:(+34)6666666"));
                    break;
                case 2:

                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("geo:50.123,7.1434?z=19"));
                    break;
                case 3:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=query"));
                    break;
                case 4:
                    //sempre hem de controlar si té permís càmera, sinó llençarà una SecurityException...
                    //veure-la comentant codi

                    int permCheck=ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    if (permCheck== PackageManager.PERMISSION_GRANTED) {
                        intent = new Intent("android.media.action.IMAGE_CAPTURE"); }
                    else {
                        //Toast.makeText(this, "PT13App no té permissos per obrir la càmera", Toast.LENGTH_SHORT).show();
                        //ara cal demanar permissos...
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

                            Toast.makeText(this, "Per seguretat, està deshabilitada. ", Toast.LENGTH_LONG).show();
                            //menu dialeg

                            ActivityCompat.requestPermissions(this,  new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);

                            // show an explanation to the user
                            // asincrona:no bloquejar el thread esperant la seva resposta
                            // Bona pràctica, try again to request the permission.
                        } else {
                            // request the permission.
                            // CALLBACK_NUMBER is a integer constants
                            Toast.makeText(this, "demana permis ", Toast.LENGTH_SHORT).show();
                            ActivityCompat.requestPermissions(this,  new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
                            // The callback method gets the result of the request.
                        }
                    }
                    //

                    break;
                case 5:
                    intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    //intent.addCategory(Intent.CATEGORY_APP_GALLERY);
                    //startActivityForResult(intent, REQUEST_IMAGE_PICK);
                    break;
                case 6:
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("content://contacts/people/"));
                    break;
                case 7:
                    intent = new Intent(Intent.ACTION_EDIT,
                            Uri.parse("content://contacts/people/1"));
                    break;


            }
            if (position==5) {
                    startActivityForResult(intent,REQUEST_IMAGE_PICK);

            } else
                startActivity(intent);



        } catch (Exception e) {
            e.printStackTrace();
            Log.d("onTest", e.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK)
            try (InputStream stream = getContentResolver().openInputStream(data.getData());) {
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }

                bitmap = BitmapFactory.decodeStream(stream);
                ImageView profilePicture=(ImageView) findViewById(R.id.userPicture);
                profilePicture.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d( "onTest: ",e.getMessage()+e.getCause());
            }

    }

    private void pickImage(View v){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_IMAGE_PICK);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, do your work....
                    Log.d("onRequestPerm" ,"uff");
                    try {
                        startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
                    } catch (Exception e){
                        e.printStackTrace();
                        Log.d( "onReq: ",e.getMessage());
                    }

            } else {
                    // permission denied
                    // Disable the functionality that depends on this permission.

                }
                return;
            }

            // other 'case' statements for other permssions
        }
    }
}
