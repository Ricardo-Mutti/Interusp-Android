package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PontuacaoTabela extends AppCompatActivity {

    ListView listPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_tabela);

        listPontuacao = (ListView) findViewById(R.id.listPontuacao);
    }
}
