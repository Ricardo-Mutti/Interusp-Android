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

import com.example.mutti.interusp_android.Adapter.PontuacaoFaculdadeAdapter;
import com.example.mutti.interusp_android.Adapter.PontuacaoGeralAdapter;
import com.example.mutti.interusp_android.Manager.GetPontosAtletica;
import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.Model.Modalidade;
import com.example.mutti.interusp_android.Model.ModalidadeFaculdade;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;

public class PontuacaoFaculdade extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    int facul_id;

    ListView listPontuacao_atletica;
    ImageView logo_atletica;
    TextView action_title;
    PontuacaoFaculdadeAdapter adapter;

    ArrayList<ModalidadeFaculdade> modalidades = new ArrayList<>();

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            listPontuacao_atletica = (ListView) findViewById(R.id.listPontuacao_atletica);
            modalidades = DataHolder.getInstance().getModalidadesFaculdade();
            adapter = new PontuacaoFaculdadeAdapter(context, modalidades);
            listPontuacao_atletica.setAdapter(adapter);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_atletica);

        facul_id = getIntent().getIntExtra("facul_id", 0);

        GetPontosAtletica getPontosAtletica = new GetPontosAtletica(context);
        getPontosAtletica.sendRequest(String.valueOf(facul_id));

        logo_atletica = (ImageView) findViewById(R.id.pontuacao_atletica_logo);

        switch (facul_id) {
            case 1:
                logo_atletica.setImageResource(R.drawable.icon_poli);
                break;
            case 2:
                logo_atletica.setImageResource(R.drawable.icon_fea);
                break;
            case 3:
                logo_atletica.setImageResource(R.drawable.icon_farma);
                break;
            case 4:
                logo_atletica.setImageResource(R.drawable.icon_esalq);
                break;
            case 5:
                logo_atletica.setImageResource(R.drawable.icon_riberao);
                break;
            case 6:
                logo_atletica.setImageResource(R.drawable.icon_sanfran);
                break;
            case 7:
                logo_atletica.setImageResource(R.drawable.icon_odonto);
                break;
            case 8:
                logo_atletica.setImageResource(R.drawable.icon_pinheiros);
                break;
        }

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity, sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Pontuação Atlética");
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
        activity.registerReceiver(receiver, new IntentFilter(Constants.kGetPontosFaculdadeDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }

}
