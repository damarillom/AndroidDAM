package com.dam.iam26509397.pt12menusypreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v13.view.DragStartHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menupt12,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.preferences) {
            startActivity(new Intent(this, Preferences.class));
            return true;

        } else if (id==R.id.help) {
            Intent intent= new Intent(Intent.ACTION_VIEW);
            getIntent().setData(Uri.parse("http://escoladeltreball.org"));
            startActivity(intent);
            return true;

        }
        //return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String mess=sharedPreferences.getString("preference_message",null);

        Toast toast=Toast.makeText(this,mess,Toast.LENGTH_LONG);
        toast.show();

        Log.i("MainActivity",mess);

        LinearLayout layout=(LinearLayout) findViewById(R.id.activity_main);

        layout.setBackgroundColor(Color.parseColor("#80ff80"));
        if (sharedPreferences.getBoolean("preference_color", false)) {
            layout.setBackgroundColor(Color.BLUE);
        } else {
            layout.setBackgroundColor(Color.GREEN);
        }


    }
}
