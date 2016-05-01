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
import android.widget.Toast;

import com.example.mutti.interusp_android.Model.PontuacaoModalidade;
import com.example.mutti.interusp_android.PontuacaoModalidadeTabela;
import com.example.mutti.interusp_android.PontuacaoTabela;
import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 30/04/16.
 */
public class Mais extends Fragment {

    Activity activity;
    Context context;

    TextView txtPontuacao, txtAdm, txtInterUsp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();

        View rootview =  inflater.inflate(R.layout.fragment_mais, container, false);

        txtPontuacao = (TextView) rootview.findViewById(R.id.txtPontuacao);
        txtPontuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PontuacaoTabela.class);
                startActivity(intent);
            }
        });
        txtAdm = (TextView) rootview.findViewById(R.id.txtAdm);
        txtAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PontuacaoModalidadeTabela.class);
                startActivity(intent);
            }
        });
        txtInterUsp = (TextView) rootview.findViewById(R.id.txtInterUsp);
        txtInterUsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return rootview;
    }

}