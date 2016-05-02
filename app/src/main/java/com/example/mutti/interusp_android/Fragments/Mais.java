package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mutti.interusp_android.Historico;
import com.example.mutti.interusp_android.InterUspInfo;
import com.example.mutti.interusp_android.LoginAdm;
import com.example.mutti.interusp_android.PontuacaoGeral;
import com.example.mutti.interusp_android.Gritos;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Torcidometro;

/**
 * Created by Mutti on 30/04/16.
 */
public class Mais extends Fragment {

    Activity activity;
    Context context;

    TextView txtPontuacao, txtAdm, txtInterUsp, gritos, torcidometro, historico;

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
                Intent intent = new Intent(activity, LoginAdm.class);
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
                Intent intent = new Intent(activity, Gritos.class);
                intent.putExtra("atletica", faculdade);
                startActivity(intent);

            }
        });

        torcidometro = (TextView) rootview.findViewById(R.id.torcidometro);
        torcidometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Torcidometro.class);
                startActivity(intent);
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


        return rootview;
    }

}