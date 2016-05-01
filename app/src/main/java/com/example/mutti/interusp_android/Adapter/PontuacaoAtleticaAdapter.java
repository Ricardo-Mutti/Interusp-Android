package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.PontuacaoAtletica;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoAtleticaAdapter extends ArrayAdapter {

    Context context;
    ArrayList<PontuacaoAtletica> list;

    public PontuacaoAtleticaAdapter(Context context, ArrayList<PontuacaoAtletica> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PontuacaoAtletica pontuacaoAtletica = list.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_pontuacao, null);
        }

        TextView txtPosicao = (TextView) convertView.findViewById(R.id.txtPosicao);
        TextView txtPonto = (TextView) convertView.findViewById(R.id.txtPonto);
        ImageView imgModalidade = (ImageView) convertView.findViewById(R.id.imgModalidade);

        txtPosicao.setText(""+ pontuacaoAtletica.getPosicao());
        txtPonto.setText(""+ pontuacaoAtletica.getPontos());

        switch (pontuacaoAtletica.getModalidadeId()) {
            case 0:
                imgModalidade.setImageResource(R.drawable.modalidade_atletismo);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 1:
                imgModalidade.setImageResource(R.drawable.campo);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 2:
                imgModalidade.setImageResource(R.drawable.modalidade_futsal);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 3:
                imgModalidade.setImageResource(R.drawable.basquete);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 4:
                imgModalidade.setImageResource(R.drawable.modalidade_natacao);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 5:
                imgModalidade.setImageResource(R.drawable.modalidade_handball);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 6:
                imgModalidade.setImageResource(R.drawable.modalidade_judo);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 7:
                imgModalidade.setImageResource(R.drawable.modalidade_karate);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 8:
                imgModalidade.setImageResource(R.drawable.modalidade_polo);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 9:
                imgModalidade.setImageResource(R.drawable.basquete);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 10:
                imgModalidade.setImageResource(R.drawable.modalidade_soft);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 11:
                imgModalidade.setImageResource(R.drawable.modalidade_volei);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 12:
                imgModalidade.setImageResource(R.drawable.modalidade_tenis);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 13:
                imgModalidade.setImageResource(R.drawable.modalidade_tenismesa);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 14:
                imgModalidade.setImageResource(R.drawable.modalidade_xadrez);
                imgModalidade.setBackgroundResource(R.color.transparente);
                break;
            case 15:
                imgModalidade.setImageResource(R.drawable.modalidade_futsal);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 16:
                imgModalidade.setImageResource(R.drawable.basquete);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 17:
                imgModalidade.setImageResource(R.drawable.modalidade_natacao);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 18:
                imgModalidade.setImageResource(R.drawable.modalidade_handball);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 19:
                imgModalidade.setImageResource(R.drawable.basquete);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 20:
                imgModalidade.setImageResource(R.drawable.modalidade_soft);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 21:
                imgModalidade.setImageResource(R.drawable.modalidade_volei);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 22:
                imgModalidade.setImageResource(R.drawable.modalidade_tenis);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            case 23:
                imgModalidade.setImageResource(R.drawable.modalidade_tenismesa);
                imgModalidade.setBackgroundResource(R.color.rosa_tema);
                break;
            default:
                break;
        }

        return convertView;
    }
}
