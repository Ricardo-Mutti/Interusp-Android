package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Pontuacao;
import com.example.mutti.interusp_android.R;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pontuacao pontuacao = list.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_placar, null);
        }

        TextView txtPontoAtual = (TextView) convertView.findViewById(R.id.txtPontoAtual);
        TextView txtPontoMin = (TextView) convertView.findViewById(R.id.txtPontoMin);
        TextView txtPontoMax = (TextView) convertView.findViewById(R.id.txtPontoMax);
        ImageView imgAtletica = (ImageView) convertView.findViewById(R.id.imgAtletica);

        txtPontoAtual.setText(""+pontuacao.getPontoAtual());
        txtPontoMin.setText(""+pontuacao.getPontoMin());
        txtPontoMax.setText(""+pontuacao.getPontoMax());

        switch (pontuacao.getAtleticaId()) {
            case 0:
                imgAtletica.setImageResource(R.drawable.icon_poli);
                break;
            case 1:
                imgAtletica.setImageResource(R.drawable.icon_esalq);
                break;
            case 2:
                imgAtletica.setImageResource(R.drawable.icon_farma);
                break;
            case 3:
                imgAtletica.setImageResource(R.drawable.icon_riberao);
                break;
            case 4:
                imgAtletica.setImageResource(R.drawable.icon_odonto);
                break;
            case 5:
                imgAtletica.setImageResource(R.drawable.icon_fea);
                break;
            case 6:
                imgAtletica.setImageResource(R.drawable.icon_sanfran);
                break;
            case 7:
                imgAtletica.setImageResource(R.drawable.icon_pinheiros);
                break;
        }

        return convertView;
    }
}
