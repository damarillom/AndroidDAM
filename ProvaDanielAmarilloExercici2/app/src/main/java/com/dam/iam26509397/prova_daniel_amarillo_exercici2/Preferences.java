package com.dam.iam26509397.prova_daniel_amarillo_exercici2;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferences);

        addPreferencesFromResource(R.xml.preferences);
    }
}