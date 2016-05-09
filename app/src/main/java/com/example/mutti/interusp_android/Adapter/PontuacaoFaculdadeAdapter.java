package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Modalidade;
import com.example.mutti.interusp_android.Model.ModalidadeFaculdade;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoFaculdadeAdapter extends ArrayAdapter {


    //ADAPTER DA TELA DA FACULDADE COM AS MODALIDADES


    Context context;
    ArrayList<ModalidadeFaculdade> faculdades;

    public PontuacaoFaculdadeAdapter(Context context, ArrayList<ModalidadeFaculdade> list) {
        super(context, 0, list);
        this.context = context;
        this.faculdades = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ModalidadeFaculdade modalidade = faculdades.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_pontuacao_faculdade, null);
        }

        TextView txtPosicao = (TextView) convertView.findViewById(R.id.txtPosicao);
        TextView txtPonto = (TextView) convertView.findViewById(R.id.txtPonto);
        ImageView imgModalidade = (ImageView) convertView.findViewById(R.id.imgModalidade);

        txtPosicao.setText("" + modalidade.getPosicao());
        txtPonto.setText("" + modalidade.getPontuacao_total());

        switch (Integer.parseInt(modalidade.getId())) {
            case 1:
                imgModalidade.setImageResource(R.drawable.modalidade_atletismo_fem);
                break;
            case 2:
                imgModalidade.setImageResource(R.drawable.modalidade_atletismo);
                break;
            case 3:
                imgModalidade.setImageResource(R.drawable.modalidade_basquete_fem);
                break;
            case 4:
                imgModalidade.setImageResource(R.drawable.modalidade_basquete);
                break;
            case 5:
                imgModalidade.setImageResource(R.drawable.modalidade_beisebol);
                break;
            case 6:
                imgModalidade.setImageResource(R.drawable.modalidade_campo);
                break;
            case 7:
                imgModalidade.setImageResource(R.drawable.modalidade_futsal_fem);
                break;
            case 8:
                imgModalidade.setImageResource(R.drawable.modalidade_futsal);
                break;
            case 9:
                imgModalidade.setImageResource(R.drawable.modalidade_handball_fem);
                break;
            case 10:
                imgModalidade.setImageResource(R.drawable.modalidade_handball);
                break;
            case 11:
                imgModalidade.setImageResource(R.drawable.modalidade_judo);
                break;
            case 12:
                imgModalidade.setImageResource(R.drawable.modalidade_karate);
                break;
            case 13:
                imgModalidade.setImageResource(R.drawable.modalidade_natacao_fem);
                break;
            case 14:
                imgModalidade.setImageResource(R.drawable.modalidade_natacao);
                break;
            case 15:
                imgModalidade.setImageResource(R.drawable.modalidade_polo);
                break;
            case 16:
                imgModalidade.setImageResource(R.drawable.modalidade_rugby);
                break;
            case 17:
                imgModalidade.setImageResource(R.drawable.modalidade_soft);
                break;
            case 18:
                imgModalidade.setImageResource(R.drawable.modalidade_tenis_fem);
                break;
            case 19:
                imgModalidade.setImageResource(R.drawable.modalidade_tenis);
                break;
            case 20:
                imgModalidade.setImageResource(R.drawable.modalidade_tenismesa_fem);
                break;
            case 21:
                imgModalidade.setImageResource(R.drawable.modalidade_tenismesa);
                break;
            case 22:
                imgModalidade.setImageResource(R.drawable.modalidade_volei_fem);
                break;
            case 23:
                imgModalidade.setImageResource(R.drawable.modalidade_volei);
                break;
            case 24:
                imgModalidade.setImageResource(R.drawable.modalidade_xadrez);
                break;
            case 25:
                imgModalidade.setImageResource(R.drawable.modalidade_rugby_fem);
                break;
            default:
                break;
        }
        return convertView;
    }
}
