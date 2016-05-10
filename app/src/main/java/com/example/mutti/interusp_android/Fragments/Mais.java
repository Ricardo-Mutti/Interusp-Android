package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mutti.interusp_android.DetalheOnibus;
import com.example.mutti.interusp_android.GritosAtletica;
import com.example.mutti.interusp_android.Mais.Historico;
import com.example.mutti.interusp_android.Mais.InterUspInfo;
import com.example.mutti.interusp_android.Atualizar.AtualizarLogin;
import com.example.mutti.interusp_android.Manager.GetTorcida;
import com.example.mutti.interusp_android.PontuacaoGeral;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Mais.Torcidometro;
import com.example.mutti.interusp_android.SelecionarAtletica;
import com.example.mutti.interusp_android.Sobre;
import com.example.mutti.interusp_android.Utils.Constants;

/**
 * Created by Mutti on 30/04/16.
 */
public class Mais extends Fragment {

    Activity activity;
    Context context;

    TextView txtPontuacao, txtAdm, txtInterUsp, gritos, torcidometro, historico, trocarAtletica, sobre;


    private BroadcastReceiver receiver_torcidas = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent intent1 = new Intent(activity, Torcidometro.class);
            activity.startActivity(intent1);
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();
       final String faculdade = "poli";
        View rootview =  inflater.inflate(R.layout.fragment_mais, container, false);

        txtPontuacao = (TextView) rootview.findViewById(R.id.txtPontuacao);
        txtPontuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PontuacaoGeral.class);
                startActivity(intent);
            }
        });
        txtAdm = (TextView) rootview.findViewById(R.id.txtAdm);
        txtAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AtualizarLogin.class);
                startActivity(intent);

            }
        });
        txtInterUsp = (TextView) rootview.findViewById(R.id.txtInterUsp);
        txtInterUsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, InterUspInfo.class);
                startActivity(intent);
            }
        });

        gritos = (TextView) rootview.findViewById(R.id.gritos);
        gritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, GritosAtletica.class);
                startActivity(intent);

            }
        });

        torcidometro = (TextView) rootview.findViewById(R.id.torcidometro);
        torcidometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTorcida getTorcida = new GetTorcida(context);
                getTorcida.getTrocida();
            }
        });


        historico = (TextView) rootview.findViewById(R.id.historico);
        historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Historico.class);
                startActivity(intent);

            }
        });

        trocarAtletica = (TextView) rootview.findViewById(R.id.txtAtletica);
        trocarAtletica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SelecionarAtletica.class);
                intent.putExtra("isChanging", true);
                startActivity(intent);
            }
        });


        sobre = (TextView) rootview.findViewById(R.id.txtSobre);
        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Sobre.class);
                startActivity(intent);
            }
        });

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.registerReceiver(receiver_torcidas, new IntentFilter(Constants.kGetTorcidaDone));
    }

    @Override
    public void onPause() {
        super.onPause();
        activity.unregisterReceiver(receiver_torcidas);
    }

}