package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Local;
import com.example.mutti.interusp_android.Utils.DataHolder;

import java.util.ArrayList;

public class ListaLocais extends AppCompatActivity {

    private ArrayList<Local> locais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        TextView local = (TextView)findViewById(R.id.local);

        locais = DataHolder.getInstance().getLocaisSalvos();

        String titulo = getIntent().getStringExtra("nome");
        if(local!=null) {
            local.setText(titulo);
        }
    }



}