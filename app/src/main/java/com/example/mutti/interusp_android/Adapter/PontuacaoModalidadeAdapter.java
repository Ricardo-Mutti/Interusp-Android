package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.PontuacaoModalidade;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoModalidadeAdapter extends ArrayAdapter<PontuacaoModalidade> {

    Context context;
    ArrayList<PontuacaoModalidade> list;

    public PontuacaoModalidadeAdapter(Context context, ArrayList<PontuacaoModalidade> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PontuacaoModalidade modalidade = list.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_modalidade, null);
        }

        TextView txtPosicao = (TextView) convertView.findViewById(R.id.txtPosicao);
        TextView txtPonto = (TextView) convertView.findViewById(R.id.txtPonto);
        ImageView imgAtletica = (ImageView) convertView.findViewById(R.id.imgAtletica);

        txtPosicao.setText(""+modalidade.getPosicao());
        txtPonto.setText(""+modalidade.getPontos());

        switch (modalidade.getAtleticaId()) {
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
