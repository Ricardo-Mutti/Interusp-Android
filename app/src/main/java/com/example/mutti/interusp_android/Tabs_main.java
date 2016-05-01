package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Utils.SelectFragment;

public class Tabs_main extends FragmentActivity {

    Activity activity = this;
    Context context = this;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String cor1 = "cor1";
    public static final String cor2 = "cor2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        TextView title = (TextView) activity.findViewById(R.id.txtActionBar);
        title.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        LinearLayout actionBar = (LinearLayout) activity.findViewById(R.id.action_bar);
        actionBar.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));

        ImageView info_tab = (ImageView) findViewById(R.id.tab_info);
        ImageView chaveamento_tab = (ImageView) findViewById(R.id.tab_chaveamento);
        ImageView mapa_tab = (ImageView) findViewById(R.id.tab_mapa);
        ImageView jogos_tab = (ImageView) findViewById(R.id.tab_jogos);
        ImageView mais_tab = (ImageView) findViewById(R.id.tab_mais);

        SelectFragment.open(2, fragmentManager, activity);


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

        mapa_tab.setOnClickListener(new View.OnClickListener() {
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
