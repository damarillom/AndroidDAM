package com.dam.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        text= (TextView) findViewById(R.id.textDisplay);
        Bundle b = this.getIntent().getExtras();
        text.setText("Benvingut "+  b.getString("Nombre"));




    }
}
