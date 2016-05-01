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

import com.example.mutti.interusp_android.Pontuacao;
import com.example.mutti.interusp_android.PontuacaoAtletica;
import com.example.mutti.interusp_android.Gritos;
import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 30/04/16.
 */
public class Mais extends Fragment {

    Activity activity;
    Context context;

    TextView txtPontuacao, txtAdm, txtInterUsp, gritos;

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
                Intent intent = new Intent(context, PontuacaoAtletica.class);
                startActivity(intent);
            }
        });
        txtAdm = (TextView) rootview.findViewById(R.id.txtAdm);
        txtAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        txtInterUsp = (TextView) rootview.findViewById(R.id.txtInterUsp);
        txtInterUsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


        return rootview;
    }

}