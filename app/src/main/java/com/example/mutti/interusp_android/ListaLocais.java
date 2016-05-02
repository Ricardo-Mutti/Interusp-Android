package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mutti.interusp_android.Utils.DataHolder;

import java.util.ArrayList;

public class ListaLocais extends AppCompatActivity {

    private ArrayList<com.example.mutti.interusp_android.Model.ListaLocais> locais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);

        TextView local = (TextView)findViewById(R.id.local_title);

        locais = DataHolder.getInstance().getLocaisSalvos();

        String titulo = getIntent().getStringExtra("nome");
        if(local!=null) {
            local.setText(titulo);
        }
    }



}
