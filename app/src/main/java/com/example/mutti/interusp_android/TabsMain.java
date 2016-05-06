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

import com.example.mutti.interusp_android.Manager.GetJogos;
import com.example.mutti.interusp_android.Utils.SelectFragment;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

public class TabsMain extends FragmentActivity {

    Activity activity = this;
    Context context = this;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String cor1 = "cor1";
    public static final String cor2 = "cor2";

    SharedPreferences sharedpreferences;
    TextView title;
    LinearLayout actionBar;

    ImageView info_tab;
    ImageView chaveamento_tab;
    ImageView mapa_tab;
    ImageView jogos_tab;
    ImageView mais_tab;
    ImageView volta_btn;

    FragmentManager fragmentManager;
    int tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);

        fragmentManager = getSupportFragmentManager();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        title = (TextView) activity.findViewById(R.id.txtActionBar);
        title.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        actionBar = (LinearLayout) activity.findViewById(R.id.action_bar);
        actionBar.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString(cor1, "#000000"));

        info_tab = (ImageView) findViewById(R.id.tab_info);
        chaveamento_tab = (ImageView) findViewById(R.id.tab_chaveamento);
        mapa_tab = (ImageView) findViewById(R.id.tab_mapa);
        jogos_tab = (ImageView) findViewById(R.id.tab_jogos);
        mais_tab = (ImageView) findViewById(R.id.tab_mais);
        volta_btn = (ImageView) findViewById(R.id.btnVoltar);
        volta_btn.setVisibility(View.INVISIBLE);

        tab = getIntent().getIntExtra("tab", 2);

        SelectFragment.open(tab, fragmentManager, activity);

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

    @Override
    protected void onResume() {
        super.onResume();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        title.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        actionBar.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString(cor1, "#000000"));
        SelectFragment.open(tab, fragmentManager, activity);
    }
}
