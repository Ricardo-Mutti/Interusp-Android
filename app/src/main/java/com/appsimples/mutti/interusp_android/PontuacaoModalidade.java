package com.appsimples.mutti.interusp_android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Adapter.PontuacaoModalidadeAdapter;
import com.appsimples.mutti.interusp_android.Manager.GetModalidades;
import com.appsimples.mutti.interusp_android.Model.FaculdadePosicaoPontuacao;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PontuacaoModalidade extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    ListView listModalidade;
    TextView action_title;



    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            listModalidade = (ListView) findViewById(R.id.listPontuacaoModalidade);

            ArrayList<FaculdadePosicaoPontuacao> faculs;

            if(DataHolder.getInstance().getModalidade().getPontuacao_total().length==0) {
             faculs = new ArrayList<>(Arrays.asList(DataHolder.getInstance().getModalidade().getPontuacao_min()));
            }else{
                faculs = new ArrayList<>(Arrays.asList(DataHolder.getInstance().getModalidade().getPontuacao_total()));

            }

            Collections.sort(faculs, new Sorting_pontuacao());
            PontuacaoModalidadeAdapter adapter = new PontuacaoModalidadeAdapter(context, faculs);
            listModalidade.setAdapter(adapter);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_modalidade);

        boolean isFem = getIntent().getBooleanExtra("feminino", false);
        String esporte = getIntent().getStringExtra("modalidade");
        int modalidade_id = getIntent().getIntExtra("modalidade_id", 0);

        //PEGA PRO INTENT QUAL MODALIDADE
        ImageView imgModalidade = (ImageView) findViewById(R.id.imgModalidade);
        TextView txtEsporte = (TextView) findViewById(R.id.txtEsporte);

        GetModalidades getModalidades = new GetModalidades(context);
        getModalidades.getModalidades(String.valueOf(modalidade_id));


        switch (esporte) {
            case "atletismo":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_atletismo_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_atletismo));
                }
                break;
            case "basquete":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_basquete_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_basquete));
                }
                break;
            case "beisebol":
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_beisebol));
                break;
            case "softbol":
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_soft));
                break;
            case "futebol de campo":
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_campo));
                break;
            case "futsal":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_futsal_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_futsal));
                }
                break;
            case "handebol":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_handball_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_handball));
                }
                break;
            case "judô":
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_judo));
                break;
            case "karatê":
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_karate));
                break;
            case "natação":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_natacao_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_natacao));
                }
                break;
            case "pólo":
                imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_polo));
                break;
            case "rugby":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_rugby_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_rugby));
                }
                break;
            case "tênis":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_tenis_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_tenis));
                }
                break;
            case "tênis de mesa":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_tenismesa_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_tenismesa));
                }
                break;
            case "vôlei":
                if(isFem){
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_volei_fem));
                }else{
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_volei));
                }
                break;
            case "xadrez":
                    imgModalidade.setImageDrawable(getResources().getDrawable(R.drawable.modalidade_xadrez));
                break;
        }
        txtEsporte.setText(esporte);

        if (isFem) {
            txtEsporte.setTextColor(getResources().getColor(R.color.rosa_tema));
        }

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Pontuação Modalidade");
        LinearLayout action_bar = (LinearLayout) findViewById(R.id.action_bar);
        action_bar.setBackgroundColor(Color.parseColor(sharedpreferences.getString("cor1", "#000000")));
        action_title.setTextColor(Color.parseColor(sharedpreferences.getString("cor2", "#000000")));
        final ImageView back_button = (ImageView) findViewById(R.id.btnVoltar);
        back_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kGetModalidadesDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }

    public class Sorting_pontuacao implements Comparator<FaculdadePosicaoPontuacao> {
        public int compare(FaculdadePosicaoPontuacao faculdadePosicaoPontuacao1, FaculdadePosicaoPontuacao faculdadePosicaoPontuacao2) {

            Integer x1 = faculdadePosicaoPontuacao1.getPontuacao();
            Integer x2 = faculdadePosicaoPontuacao2.getPontuacao();

                return x2.compareTo(x1);

        }
    }





}
