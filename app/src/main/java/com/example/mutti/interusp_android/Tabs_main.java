package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mutti.interusp_android.Utils.SelectFragment;

public class Tabs_main extends FragmentActivity {

    Activity activity = this;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        ImageView info_tab = (ImageView) findViewById(R.id.tab_info);
        ImageView chaveamento_tab = (ImageView) findViewById(R.id.tab_chaveamento);
        ImageView pontuacao_tab = (ImageView) findViewById(R.id.tab_mapa);
        ImageView jogos_tab = (ImageView) findViewById(R.id.tab_jogos);
        ImageView mais_tab = (ImageView) findViewById(R.id.tab_mais);

        SelectFragment.open(0, fragmentManager, activity);


        info_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectFragment.open(0, fragmentManager, activity);
            }
        });

        chaveamento_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectFragment.open(1, fragmentManager, activity);
            }
        });

        pontuacao_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectFragment.open(2, fragmentManager, activity);
            }
        });


        jogos_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectFragment.open(3, fragmentManager, activity);
            }
        });


        mais_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectFragment.open(4, fragmentManager, activity);
            }
        });

    }
}
