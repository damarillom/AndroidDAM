package com.dam.eva.listviewrec;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Bloc {

    private String data;
    private String tempe;
    private String fredCalor;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempe() {
        return tempe;
    }

    public void setTempe(String tempe) {
        this.tempe = tempe;
    }

    public String getFredCalor() {
        return fredCalor;
    }

    public void setFredCalor(String fredCalor) {
        this.fredCalor = fredCalor;
    }

    public Bloc(String data, String tempe, String fredCalor) {
        this.data = data;
        this.tempe = tempe;
        this.fredCalor = fredCalor;
    }
}
