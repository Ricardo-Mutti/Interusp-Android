package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mutti.interusp_android.Adapter.PontuacaoAtleticaAdapter;

import java.util.ArrayList;

public class PontuacaoAtletica extends AppCompatActivity {

    ListView listPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_atletica);

        listPontuacao = (ListView) findViewById(R.id.listPontuacao);
        ArrayList<com.example.mutti.interusp_android.Model.PontuacaoAtletica> list = new ArrayList<>();
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(0, "Atletismo", 1, 180));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(1, "Futebol de Campo", 2, 160));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(2, "Futebol Futsal masculino", 3, 120));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(3, "Basquete masculino", 4, 120));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(4, "Natação masculino", 5, 119));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(5, "Handebol masculino", 6, 100));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(6, "Judô", 7, 99));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(7, "Karate", 8, 99));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(8, "Polo", 9, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(9, "Rugby masculino", 10, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(10, "Basebol", 11, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(11, "Volei masculino", 12, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(12, "Tênis masculino", 13, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(13, "Tênis de Mesa masculino", 14, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(14, "Xadrez", 15, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(15, "Futebol Futsal feminino", 16, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(16, "Basquete feminino", 17, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(17, "Natação feminino", 18, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(18, "Handebol feminino", 19, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(19, "Rugby feminino", 20, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(20, "Softbol", 21, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(21, "Volei feminino", 22, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(22, "Tênis feminino", 23, 95));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoAtletica(23, "Tênis de Mesa feminino", 24, 95));

        PontuacaoAtleticaAdapter adapter = new PontuacaoAtleticaAdapter(this, list);
        listPontuacao.setAdapter(adapter);
    }
}
