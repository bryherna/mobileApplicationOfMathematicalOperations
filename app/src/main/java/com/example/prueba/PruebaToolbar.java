package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class PruebaToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar);

    }
}