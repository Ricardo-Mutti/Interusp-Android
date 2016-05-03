package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.mutti.interusp_android.Model.Pontuacao;
import com.example.mutti.interusp_android.Model.PontuacaoModalidade;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.SetListAtletica;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoAdapter extends ArrayAdapter<Pontuacao> {

    Context context;
    ArrayList<Pontuacao> list;

    public PontuacaoAdapter(Context context, ArrayList<Pontuacao> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    //Logica pra retornar o layout
    @Override
    public int getItemViewType(int position) {
        int type=0;
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

        Pontuacao pontuacao = list.get(position);
        int type = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(type==1){
                convertView = inflater.inflate(R.layout.layout_modalidades_placar, null);

                ImageView pontuacao1 = (ImageView) convertView.findViewById(R.id.pontuacao_atletismo);


                pontuacao1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, com.example.mutti.interusp_android.PontuacaoModalidade.class);
                        context.startActivity(intent);
                    }
                });



            }else{
                convertView = inflater.inflate(R.layout.item_placar, null);
                SetListAtletica.setCell(convertView,context,pontuacao);
            }

        }

        return convertView;
    }
}
