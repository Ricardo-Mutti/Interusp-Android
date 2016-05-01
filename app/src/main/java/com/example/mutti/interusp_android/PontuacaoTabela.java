package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mutti.interusp_android.Adapter.PontuacaoTabelaAdapter;
import com.example.mutti.interusp_android.Model.Pontuacao;

import java.util.ArrayList;

public class PontuacaoTabela extends AppCompatActivity {

    ListView listPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_tabela);

        listPontuacao = (ListView) findViewById(R.id.listPontuacao);
        ArrayList<Pontuacao> list = new ArrayList<>();
        list.add(new Pontuacao(0, "Atletismo", 1, 180));
        list.add(new Pontuacao(1, "Futebol de Campo", 2, 160));
        list.add(new Pontuacao(2, "Futebol Futsal masculino", 3, 120));
        list.add(new Pontuacao(3, "Basquete masculino", 4, 120));
        list.add(new Pontuacao(4, "Natação masculino", 5, 119));
        list.add(new Pontuacao(5, "Handebol masculino", 6, 100));
        list.add(new Pontuacao(6, "Judô", 7, 99));
        list.add(new Pontuacao(7, "Karate", 8, 99));
        list.add(new Pontuacao(8, "Polo", 9, 95));
        list.add(new Pontuacao(9, "Rugby masculino", 10, 95));
        list.add(new Pontuacao(10, "Basebol", 11, 95));
        list.add(new Pontuacao(11, "Volei masculino", 12, 95));
        list.add(new Pontuacao(12, "Tênis masculino", 13, 95));
        list.add(new Pontuacao(13, "Tênis de Mesa masculino", 14, 95));
        list.add(new Pontuacao(14, "Xadrez", 15, 95));
        list.add(new Pontuacao(15, "Futebol Futsal feminino", 16, 95));
        list.add(new Pontuacao(16, "Basquete feminino", 17, 95));
        list.add(new Pontuacao(17, "Natação feminino", 18, 95));
        list.add(new Pontuacao(18, "Handebol feminino", 19, 95));
        list.add(new Pontuacao(19, "Rugby feminino", 20, 95));
        list.add(new Pontuacao(20, "Softbol", 21, 95));
        list.add(new Pontuacao(21, "Volei feminino", 22, 95));
        list.add(new Pontuacao(22, "Tênis feminino", 23, 95));
        list.add(new Pontuacao(23, "Tênis de Mesa feminino", 24, 95));

        PontuacaoTabelaAdapter adapter = new PontuacaoTabelaAdapter(this, list);
        listPontuacao.setAdapter(adapter);
    }
}
