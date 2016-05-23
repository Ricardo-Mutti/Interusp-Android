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
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Manager.GetJogos;
import com.appsimples.mutti.interusp_android.Model.Jogo;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ChaveamentoModalidade extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    ImageView chave_1, chave_2, chave_3, chave_4, chave_5, chave_6, chave_7, chave_8,
            chave_9, chave_10, chave_11, chave_12, chave_13, chave_14, chave_15;
    TextView chave_1_txt, chave_2_txt, chave_3_txt, chave_4_txt, chave_5_txt, chave_6_txt, chave_7_txt, chave_8_txt,
            chave_9_txt, chave_10_txt, chave_11_txt, chave_12_txt, chave_13_txt, chave_14_txt;
    TextView action_title;

    private int modalidade;
    private String nomeModalidade;
    private ArrayList<Jogo> jogos = new ArrayList<>();

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            jogos.clear();
            jogos.addAll(DataHolder.getInstance().getChaveamento());
            Collections.sort(jogos, new Comparator<Jogo>() {
                @Override
                public int compare(Jogo j1, Jogo j2) {
                    return j1.getChaveamento().compareTo(j2.getChaveamento());
                }
            });
            setData();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaveamento_modalidade);

        chave_1 = (ImageView) findViewById(R.id.chave_1);
        chave_2 = (ImageView) findViewById(R.id.chave_2);
        chave_3 = (ImageView) findViewById(R.id.chave_3);
        chave_4 = (ImageView) findViewById(R.id.chave_4);
        chave_5 = (ImageView) findViewById(R.id.chave_5);
        chave_6 = (ImageView) findViewById(R.id.chave_6);
        chave_7 = (ImageView) findViewById(R.id.chave_7);
        chave_8 = (ImageView) findViewById(R.id.chave_8);
        chave_9 = (ImageView) findViewById(R.id.chave_9);
        chave_10 = (ImageView) findViewById(R.id.chave_10);
        chave_11 = (ImageView) findViewById(R.id.chave_11);
        chave_12 = (ImageView) findViewById(R.id.chave_12);
        chave_13 = (ImageView) findViewById(R.id.chave_13);
        chave_14 = (ImageView) findViewById(R.id.chave_14);
        chave_15 = (ImageView) findViewById(R.id.chave_15);

        chave_1_txt = (TextView) findViewById(R.id.chave_txt_1);
        chave_2_txt = (TextView) findViewById(R.id.chave_txt_2);
        chave_3_txt = (TextView) findViewById(R.id.chave_txt_3);
        chave_4_txt = (TextView) findViewById(R.id.chave_txt_4);
        chave_5_txt = (TextView) findViewById(R.id.chave_txt_5);
        chave_6_txt = (TextView) findViewById(R.id.chave_txt_6);
        chave_7_txt = (TextView) findViewById(R.id.chave_txt_7);
        chave_8_txt = (TextView) findViewById(R.id.chave_txt_8);
        chave_9_txt = (TextView) findViewById(R.id.chave_txt_9);
        chave_10_txt = (TextView) findViewById(R.id.chave_txt_10);
        chave_11_txt = (TextView) findViewById(R.id.chave_txt_11);
        chave_12_txt = (TextView) findViewById(R.id.chave_txt_12);
        chave_13_txt = (TextView) findViewById(R.id.chave_txt_13);
        chave_14_txt = (TextView) findViewById(R.id.chave_txt_14);

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
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

        modalidade = getIntent().getIntExtra("modalidade", 0);
        nomeModalidade = getIntent().getStringExtra("nomeModalidade");

        GetJogos getJogos = new GetJogos(context);
        getJogos.GetChaveamento(modalidade);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title.setTextColor(Color.parseColor(sharedpreferences.getString("cor2", "#000000")));

        activity.registerReceiver(receiver, new IntentFilter(Constants.kChaveamentoDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }

    private void setData(){
        action_title.setText("Chaveamento " + nomeModalidade);

        if(jogos.get(0).getFaculdade_1()!=null) setDrawable(chave_1, jogos.get(0).getFaculdade_1());
        if(jogos.get(0).getFaculdade_2()!=null) setDrawable(chave_2, jogos.get(0).getFaculdade_2());
        if(jogos.get(1).getFaculdade_1()!=null) setDrawable(chave_3, jogos.get(1).getFaculdade_1());
        if(jogos.get(1).getFaculdade_2()!=null) setDrawable(chave_4, jogos.get(1).getFaculdade_2());
        if(jogos.get(2).getFaculdade_1()!=null) setDrawable(chave_5, jogos.get(2).getFaculdade_1());
        if(jogos.get(2).getFaculdade_2()!=null) setDrawable(chave_6, jogos.get(2).getFaculdade_2());
        if(jogos.get(3).getFaculdade_1()!=null) setDrawable(chave_7, jogos.get(3).getFaculdade_1());
        if(jogos.get(3).getFaculdade_2()!=null) setDrawable(chave_8, jogos.get(3).getFaculdade_2());
        if(jogos.get(4).getFaculdade_1()!=null) setDrawable(chave_9, jogos.get(4).getFaculdade_1());
        if(jogos.get(4).getFaculdade_2()!=null) setDrawable(chave_10, jogos.get(4).getFaculdade_2());
        if(jogos.get(5).getFaculdade_1()!=null) setDrawable(chave_11, jogos.get(5).getFaculdade_1());
        if(jogos.get(5).getFaculdade_2()!=null) setDrawable(chave_12, jogos.get(5).getFaculdade_2());
        if(jogos.get(6).getFaculdade_1()!=null) setDrawable(chave_13, jogos.get(6).getFaculdade_1());
        if(jogos.get(6).getFaculdade_2()!=null) setDrawable(chave_14, jogos.get(6).getFaculdade_2());
        if(jogos.size()>6) {if (jogos.get(7).getFaculdade_1() != null) setDrawable(chave_15, jogos.get(7).getFaculdade_1());}


        if(jogos.get(0).getPlacar_1()!=null) {
            String placar = jogos.get(0).getPlacar_1();
            if(jogos.get(0).getPlacar_1().length()>2){
                chave_1_txt.setTextSize(11);
            }
            if(jogos.get(0).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(0).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_1_txt.setText(placar);
        }

        if(jogos.get(0).getPlacar_2()!=null) {
            String placar = jogos.get(0).getPlacar_2();
            if(jogos.get(0).getPlacar_2().length()>2){
                chave_2_txt.setTextSize(11);
            }
            if(jogos.get(0).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(0).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_2_txt.setText(placar);
        }

        if(jogos.get(1).getPlacar_1()!=null) {
            String placar = jogos.get(1).getPlacar_1();
            if(jogos.get(1).getPlacar_1().length()>2){
                chave_3_txt.setTextSize(11);
            }
            if(jogos.get(1).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(1).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_3_txt.setText(placar);
        }


        if(jogos.get(1).getPlacar_2()!=null) {
            String placar = jogos.get(1).getPlacar_2();
            if(jogos.get(1).getPlacar_2().length()>2){
                chave_4_txt.setTextSize(11);
            }
            if(jogos.get(1).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(1).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_4_txt.setText(placar);
        }

        if(jogos.get(2).getPlacar_1()!=null) {
            String placar = jogos.get(2).getPlacar_1();
            if(jogos.get(2).getPlacar_1().length()>2){
                chave_5_txt.setTextSize(11);
            }
            if(jogos.get(2).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(2).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_5_txt.setText(placar);
        }

        if(jogos.get(2).getPlacar_2()!=null) {
            String placar = jogos.get(2).getPlacar_2();
            if(jogos.get(2).getPlacar_2().length()>2){
                chave_6_txt.setTextSize(11);
            }
            if(jogos.get(2).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(2).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_6_txt.setText(placar);
        }

        if(jogos.get(3).getPlacar_1()!=null) {
            String placar = jogos.get(3).getPlacar_1();
            if(jogos.get(3).getPlacar_1().length()>2){
                chave_7_txt.setTextSize(11);
            }
            if(jogos.get(3).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(3).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_7_txt.setText(placar);
        }

        if(jogos.get(3).getPlacar_2()!=null) {
            String placar = jogos.get(3).getPlacar_2();
            if(jogos.get(3).getPlacar_2().length()>2){
                chave_8_txt.setTextSize(11);
            }
            if(jogos.get(3).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(3).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_8_txt.setText(placar);
        }


        if(jogos.get(4).getPlacar_1()!=null) {
            String placar = jogos.get(4).getPlacar_1();
            if(jogos.get(4).getPlacar_1().length()>2){
                chave_9_txt.setTextSize(11);
            }
            if(jogos.get(4).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(4).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_9_txt.setText(placar);
        }

        if(jogos.get(4).getPlacar_2()!=null) {
            String placar = jogos.get(4).getPlacar_2();
            if(jogos.get(4).getPlacar_2().length()>2){
                chave_10_txt.setTextSize(11);
            }
            if(jogos.get(4).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(4).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_10_txt.setText(placar);
        }


        if(jogos.get(5).getPlacar_1()!=null) {
            String placar = jogos.get(5).getPlacar_1();
            if(jogos.get(5).getPlacar_1().length()>2){
                chave_11_txt.setTextSize(11);
            }
            if(jogos.get(5).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(5).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_11_txt.setText(placar);
        }

        if(jogos.get(5).getPlacar_2()!=null) {
            String placar = jogos.get(5).getPlacar_2();
            if(jogos.get(5).getPlacar_2().length()>2){
                chave_12_txt.setTextSize(11);
            }
            if(jogos.get(5).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(5).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_12_txt.setText(placar);
        }


        if(jogos.get(6).getPlacar_1()!=null) {
            String placar = jogos.get(6).getPlacar_1();
            if(jogos.get(6).getPlacar_1().length()>2){
                chave_13_txt.setTextSize(11);
            }
            if(jogos.get(6).getPlacar_1().contains("(")){
                String[] penaltis = jogos.get(6).getPlacar_1().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_13_txt.setText(placar);
        }

        if(jogos.get(6).getPlacar_2()!=null) {
            String placar = jogos.get(6).getPlacar_2();
            if(jogos.get(6).getPlacar_2().length()>2){
                chave_14_txt.setTextSize(11);
            }
            if(jogos.get(6).getPlacar_2().contains("(")){
                String[] penaltis = jogos.get(6).getPlacar_2().split("[\\(]");
                placar  = penaltis[0]+"\n("+ penaltis[1];
            }
            chave_14_txt.setText(placar);
        }

    }

    private void setDrawable(ImageView imgView, String faculdade){
        switch (faculdade){
            case "1":
                imgView.setImageResource(R.drawable.icon_poli);
                break;
            case "2":
                imgView.setImageResource(R.drawable.icon_fea);
                break;
            case "3":
                imgView.setImageResource(R.drawable.icon_farma);
                break;
            case "4":
                imgView.setImageResource(R.drawable.icon_esalq);
                break;
            case "5":
                imgView.setImageResource(R.drawable.icon_riberao);
                break;
            case "6":
                imgView.setImageResource(R.drawable.icon_sanfran);
                break;
            case "7":
                imgView.setImageResource(R.drawable.icon_odonto);
                break;
            case "8":
                imgView.setImageResource(R.drawable.icon_pinheiros);
                break;
            default:
                break;
        }
    }
}
