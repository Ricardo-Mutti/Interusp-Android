package com.example.mutti.interusp_android.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.PontuacaoModalidade;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.SetListAtletica;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoGeralAdapter extends ArrayAdapter<Faculdade> {

    Context context;
    Activity activity;
    ArrayList<Faculdade> list;

    public PontuacaoGeralAdapter(Context context, Activity activity, ArrayList<Faculdade> list) {
        super(context, 0, list);
        this.context = context;
        this.activity = activity;
        this.list = list;
    }

    //Logica pra retornar o layout
    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position == 7) {
            type = 1;
        }

        return type;
    }

    //Precisa dar override no getViewTypeCount pq se nao ele nao retorna os layouts direito
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Faculdade pontuacao = list.get(position);
        int type = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (type == 0) {//Placar Geral

                convertView = inflater.inflate(R.layout.item_pontuacao_geral, null);
                SetListAtletica.setCell(convertView, context, pontuacao);

            } else {//Modalidades


                convertView = inflater.inflate(R.layout.layout_modalidades_placar, null);

                ImageView pontuacao1 = (ImageView) convertView.findViewById(R.id.pontuacao_atletismo);


                pontuacao1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        activity.startActivity(intent);
                    }
                });

            }

        }

        return convertView;
    }
}
