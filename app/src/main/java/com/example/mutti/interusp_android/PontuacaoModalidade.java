package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.PontuacaoModalidadeAdapter;
import com.example.mutti.interusp_android.Model.FaculdadePosicaoPontuacao;
import com.example.mutti.interusp_android.Model.Modalidade;

import java.util.ArrayList;

public class PontuacaoModalidade extends AppCompatActivity {

    ListView listModalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_modalidade);

        boolean isFem = getIntent().getBooleanExtra("feminino", false);
        String esporte = getIntent().getStringExtra("modalidade");

        //PEGA PRO INTENT QUAL MODALIDADE
        ImageView imgModalidade = (ImageView) findViewById(R.id.imgModalidade);
        TextView txtEsporte = (TextView) findViewById(R.id.txtEsporte);

        switch (esporte) {
            case "atletismo":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_atletismo));
                break;
            case "basquete":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_basquete));
                break;
            case "beisebol":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_soft));
                break;
            case "softbol":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_soft));
                break;
            case "futebol de campo":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_campo));
                break;
            case "futsal":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_futsal));
                break;
            case "handebol":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_handball));
                break;
            case "judô":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_judo));
                break;
            case "karatê":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_karate));
                break;
            case "natação":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_natacao));
                break;
            case "pólo":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_polo));
                break;
            case "rugby":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_rugby));
                break;
            case "tênis":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_tenis));
                break;
            case "tênis de mesa":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_tenismesa));
                break;
            case "vôlei":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_volei));
                break;
            case "xadrez":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_xadrez));
                break;
        }
        txtEsporte.setText(esporte);

        if (isFem) {
            txtEsporte.setTextColor(getResources().getColor(R.color.rosa_tema));
        }

        listModalidade = (ListView) findViewById(R.id.listPontuacaoModalidade);

        Modalidade modalidade = new Modalidade();
        //modalidade= DATAHOLDER


        ArrayList<FaculdadePosicaoPontuacao> list = new ArrayList<>();

//        list = modalidade.getPontuacao_total()

        list.add(new FaculdadePosicaoPontuacao(2, 1, 160));
        list.add(new FaculdadePosicaoPontuacao(3, 2, 120));
        list.add(new FaculdadePosicaoPontuacao(4, 3, 120));
        list.add(new FaculdadePosicaoPontuacao(5, 4, 119));
        list.add(new FaculdadePosicaoPontuacao(6, 5, 100));
        list.add(new FaculdadePosicaoPontuacao(7, 6, 99));
        list.add(new FaculdadePosicaoPontuacao(8, 7, 99));

        PontuacaoModalidadeAdapter adapter = new PontuacaoModalidadeAdapter(this, list);
        listModalidade.setAdapter(adapter);
    }
}
