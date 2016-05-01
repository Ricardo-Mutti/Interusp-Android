package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PontuacaoModalidadeTabela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_modalidade_tabela);

        ImageView imgModalidade = (ImageView) findViewById(R.id.imgModalidade);
        TextView txtEsporte = (TextView) findViewById(R.id.txtEsporte);

        ListView listPontuacaoModalidade = (ListView) findViewById(R.id.listPontuacaoModalidade);


    }
}
