package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class teste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        String name = getIntent().getStringExtra("nome");
        TextView nome = (TextView) findViewById(R.id.nome);
        nome.setText(name);
    }
}
