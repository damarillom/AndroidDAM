package com.dam.iam26509397.menuspreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.dam.iam26509397.menuspreferences.R;

public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferences);

        addPreferencesFromResource(R.xml.preferences);
    }
}
