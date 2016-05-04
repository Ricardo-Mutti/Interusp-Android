package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mutti.interusp_android.Adapter.PontuacaoGeralAdapter;
import com.example.mutti.interusp_android.Model.Faculdade;

import java.util.ArrayList;

public class PontuacaoGeral extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    ListView listPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_geral);

        listPontuacao = (ListView) findViewById(R.id.listPontuacao);

        ArrayList<Faculdade> list = new ArrayList<>();

        list.add(new Faculdade(0, 130, 140, 180));
        list.add(new Faculdade(1, 110, 120, 160));
        list.add(new Faculdade(2, 100, 120, 160));
        list.add(new Faculdade(3, 97, 100, 120));
        list.add(new Faculdade(4, 87, 90, 119));
        list.add(new Faculdade(5, 70, 87, 100));
        list.add(new Faculdade(6, 60, 68, 99));
        list.add(new Faculdade(7, 50, 56, 99));

        PontuacaoGeralAdapter adapter = new PontuacaoGeralAdapter(context,activity, list);
        listPontuacao.setAdapter(adapter);
    }
}
