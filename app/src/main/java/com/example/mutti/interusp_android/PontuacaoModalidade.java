package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.PontuacaoModalidadeAdapter;

import java.util.ArrayList;

public class PontuacaoModalidade extends AppCompatActivity {

    ListView listModalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_modalidade);

        ImageView imgModalidade = (ImageView) findViewById(R.id.imgModalidade);
        TextView txtEsporte = (TextView) findViewById(R.id.txtEsporte);

        listModalidade = (ListView) findViewById(R.id.listPontuacaoModalidade);
        ArrayList<com.example.mutti.interusp_android.Model.PontuacaoModalidade> list = new ArrayList<>();
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(1, 0, 180));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(2, 1, 160));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(3, 2, 120));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(4, 3, 120));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(5, 4, 119));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(6, 5, 100));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(7, 6, 99));
        list.add(new com.example.mutti.interusp_android.Model.PontuacaoModalidade(8, 7, 99));
        PontuacaoModalidadeAdapter adapter = new PontuacaoModalidadeAdapter(this, list);
        listModalidade.setAdapter(adapter);
    }
}
