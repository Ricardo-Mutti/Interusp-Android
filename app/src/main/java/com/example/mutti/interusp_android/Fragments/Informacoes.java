package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mutti.interusp_android.Manager.GetLocal;
import com.example.mutti.interusp_android.Model.ListaLocais;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;

import java.util.ArrayList;

/**
 * Created by Mutti on 30/04/16.
 */
public class Informacoes extends Fragment {

    Activity activity;
    Context context;
    private ArrayList<ListaLocais> locais = new ArrayList<>();
    private boolean locaisReady = false;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            locais = DataHolder.getInstance().getLocaisSalvos();
            locaisReady = true;

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

        locais = DataHolder.getInstance().getLocaisSalvos();
        if(locais.size()==0){
            GetLocal getLocal = new GetLocal(context);
            getLocal.getLocais();
        }
        else{
            locaisReady = true;
        }

        View rootview =  inflater.inflate(R.layout.fragment_informacoes, container, false);

        ImageView imgGinasio = (ImageView) rootview.findViewById(R.id.imgGinasio);
        imgGinasio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Ginásios");
                    intent.putExtra("tipo", 1);
                    startActivity(intent);
                }
            }
        });

        ImageView imgTenda = (ImageView) rootview.findViewById(R.id.imgTenda);
        imgTenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Tenda");
                    intent.putExtra("tipo", 2);
                    startActivity(intent);
                }
            }
        });

        ImageView imgBalada = (ImageView) rootview.findViewById(R.id.imgBalada);
        imgBalada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Baladas");
                    intent.putExtra("tipo", 3);
                    startActivity(intent);
                }
            }
        });

        ImageView imgOnibus = (ImageView) rootview.findViewById(R.id.imgOnibus);
        imgOnibus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Ônibus");
                    intent.putExtra("tipo", 4);
                    startActivity(intent);
                }
            }
        });

        ImageView imgAlojamento = (ImageView) rootview.findViewById(R.id.imgAlojamento);
        imgAlojamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Alojamentos");
                    intent.putExtra("tipo", 5);
                    startActivity(intent);
                }

            }
        });

        ImageView imgHospital = (ImageView) rootview.findViewById(R.id.imgHospital);
        imgHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Hospital");
                    intent.putExtra("tipo", 6);
                    startActivity(intent);
                }
            }
        });

        ImageView imgDelegacia = (ImageView) rootview.findViewById(R.id.imgDelegacia);
        imgDelegacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Delegacia");
                    intent.putExtra("tipo", 7);
                    startActivity(intent);
                }
            }
        });

        ImageView imgRestaurante = (ImageView) rootview.findViewById(R.id.imgRestaurante);
        imgRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locaisReady) {
                    Intent intent = new Intent(activity, ListaLocais.class);
                    intent.putExtra("nome", "Restaurantes");
                    intent.putExtra("tipo", 8);
                    startActivity(intent);
                }
            }
        });

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kGetLocaisDone));
    }

    @Override
    public void onPause() {
        super.onPause();
        activity.unregisterReceiver(receiver);
    }
}
