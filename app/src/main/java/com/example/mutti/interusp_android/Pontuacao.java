package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mutti.interusp_android.Adapter.PontuacaoAdapter;

import java.util.ArrayList;

public class Pontuacao extends AppCompatActivity {

    ListView listPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        listPontuacao = (ListView) findViewById(R.id.listPontuacao);
        ArrayList<com.example.mutti.interusp_android.Model.Pontuacao> list = new ArrayList<>();
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(0, 130, 140, 180));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(1, 110, 120, 160));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(2, 100, 120, 160));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(3, 97, 100, 120));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(4, 87, 90, 119));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(5, 70, 87, 100));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(6, 60, 68, 99));
        list.add(new com.example.mutti.interusp_android.Model.Pontuacao(7, 50, 56, 99));
        PontuacaoAdapter adapter = new PontuacaoAdapter(this, list);
        listPontuacao.setAdapter(adapter);
    }
}
