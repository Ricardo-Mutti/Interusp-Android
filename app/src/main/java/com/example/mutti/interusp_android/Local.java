package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Local extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        String titulo= null;
        titulo = getIntent().getStringExtra("nome");
        TextView local=(TextView)findViewById(R.id.local);
        local.setText(titulo);
    }



}
