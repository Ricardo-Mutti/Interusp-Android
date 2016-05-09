package com.example.mutti.interusp_android;

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

import com.example.mutti.interusp_android.Adapter.PontuacaoGeralAdapter;
import com.example.mutti.interusp_android.Manager.GetPontuacaoGeral;
import com.example.mutti.interusp_android.Manager.GetModalidades;
import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;

public class PontuacaoGeral extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    ListView listPontuacao;
    TextView action_title;
    PontuacaoGeralAdapter adapter;

    ArrayList<Faculdade> faculdades = new ArrayList<>();

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            listPontuacao = (ListView) findViewById(R.id.listPontuacao);
            faculdades = DataHolder.getInstance().getFaculdades();
            adapter = new PontuacaoGeralAdapter(context, activity, faculdades);
            listPontuacao.setAdapter(adapter);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_geral);

        GetPontuacaoGeral getFaculdades = new GetPontuacaoGeral(context);
        getFaculdades.sendRequest();

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity, sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Pontuação Geral");
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
        activity.registerReceiver(receiver, new IntentFilter(Constants.kGetFaculdadesDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }


}
