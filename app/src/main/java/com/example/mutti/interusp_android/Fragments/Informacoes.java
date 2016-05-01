package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mutti.interusp_android.Local;
import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 30/04/16.
 */
public class Informacoes extends Fragment {

    Activity activity;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();

        View rootview =  inflater.inflate(R.layout.fragment_informacoes, container, false);

        ImageView imgGinasio = (ImageView) rootview.findViewById(R.id.imgGinasio);
        imgGinasio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Ginásios");
                startActivity(intent);
            }
        });

        ImageView imgTenda = (ImageView) rootview.findViewById(R.id.imgTenda);
        imgTenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Tenda");
                startActivity(intent);

            }
        });

        ImageView imgBalada = (ImageView) rootview.findViewById(R.id.imgBalada);
        imgBalada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Baladas");
                startActivity(intent);
            }
        });

        ImageView imgOnibus = (ImageView) rootview.findViewById(R.id.imgOnibus);
        imgOnibus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Ônibus");
                startActivity(intent);
            }
        });

        ImageView imgAlojamento = (ImageView) rootview.findViewById(R.id.imgAlojamento);
        imgAlojamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Alojamentos");
                startActivity(intent);

            }
        });

        ImageView imgHospital = (ImageView) rootview.findViewById(R.id.imgHospital);
        imgHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Hospital");
                startActivity(intent);
            }
        });

        ImageView imgDelegacia = (ImageView) rootview.findViewById(R.id.imgDelegacia);
        imgDelegacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Delegacia");
                startActivity(intent);
            }
        });

        ImageView imgRestaurante = (ImageView) rootview.findViewById(R.id.imgRestaurante);
        imgRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Local.class);
                intent.putExtra("nome","Restaurantes");
                startActivity(intent);
            }
        });

        return rootview;
    }
}
