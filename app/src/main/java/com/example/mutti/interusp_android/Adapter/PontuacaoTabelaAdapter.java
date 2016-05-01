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
public class PontuacaoTabelaAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Pontuacao> list;

    public PontuacaoTabelaAdapter(Context context, ArrayList<Pontuacao> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pontuacao pontuacao = list.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_pontuacao, null);
        }

        TextView txtPosicao = (TextView) convertView.findViewById(R.id.txtPosicao);
        TextView txtPonto = (TextView) convertView.findViewById(R.id.txtPonto);
        ImageView imgModalidade = (ImageView) convertView.findViewById(R.id.imgModalidade);

        txtPosicao.setText(""+pontuacao.getPosicao());
        txtPonto.setText(""+pontuacao.getPontos());

        switch (pontuacao.getModalidadeId()) {
            case 0:
                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 1:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 2:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 3:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 4:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 5:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 6:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 7:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 8:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 9:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 10:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 11:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 12:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 13:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 14:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 15:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 16:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 17:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 18:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 19:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 20:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 21:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 22:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 23:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 24:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            case 25:

                imgModalidade.getContext().getResources().getDrawable(R.drawable.basquete);
                break;
            default:
                break;
        }

        return convertView;
    }
}
