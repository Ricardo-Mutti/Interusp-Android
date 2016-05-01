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
        list.add(new Pontuacao(1, "Atletismo", 1, 180));
        list.add(new Pontuacao(2, "Futebol de Campo", 2, 160));
        list.add(new Pontuacao(3, "Futebol Futsal", 3, 120));
        list.add(new Pontuacao(4, "Basquete", 4, 120));
        list.add(new Pontuacao(5, "Natação", 5, 119));

        PontuacaoTabelaAdapter adapter = new PontuacaoTabelaAdapter(this, list);
        listPontuacao.setAdapter(adapter);
    }
}
