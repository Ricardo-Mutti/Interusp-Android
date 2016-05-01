package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return rootview;
    }

    public void abrirginasio(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Ginásios");
        startActivity(intent);

    }

    public void abrirtenda(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Tenda");
        startActivity(intent);

    }

    public void abrirbalada(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Baladas");
        startActivity(intent);

    }

    public void abrironibus(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Ônibus");
        startActivity(intent);

    }

    public void abriralojamentos(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Alojamentos");
        startActivity(intent);

    }

    public void abrirhospital(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Hospital");
        startActivity(intent);

    }

    public void abrirdelegacia(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Delegacia");
        startActivity(intent);

    }

    public void abrirrestaurantes(View view) {
        Intent intent = new Intent(activity, Local.class);
        intent.putExtra("nome","Restaurantes");
        startActivity(intent);

    }

}
