package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.PontuacaoModalidadeAdapter;
import com.example.mutti.interusp_android.Model.PontuacaoModalidade;

import java.util.ArrayList;

public class PontuacaoModalidadeTabela extends AppCompatActivity {

    ListView listModalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_modalidade_tabela);

        ImageView imgModalidade = (ImageView) findViewById(R.id.imgModalidade);
        TextView txtEsporte = (TextView) findViewById(R.id.txtEsporte);

        listModalidade = (ListView) findViewById(R.id.listPontuacaoModalidade);
        ArrayList<PontuacaoModalidade> list = new ArrayList<>();
        list.add(new PontuacaoModalidade(1, 0, 180));
        list.add(new PontuacaoModalidade(2, 1, 160));
        list.add(new PontuacaoModalidade(3, 2, 120));
        list.add(new PontuacaoModalidade(4, 3, 120));
        list.add(new PontuacaoModalidade(5, 4, 119));
        list.add(new PontuacaoModalidade(6, 5, 100));
        list.add(new PontuacaoModalidade(7, 6, 99));
        list.add(new PontuacaoModalidade(8, 7, 99));
        PontuacaoModalidadeAdapter adapter = new PontuacaoModalidadeAdapter(this, list);
        listModalidade.setAdapter(adapter);
    }
}
