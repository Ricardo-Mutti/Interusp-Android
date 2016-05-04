package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Gabriel on 5/1/16.
 */
public class JogoAdapter extends BaseAdapter{

    Context context;
    public ArrayList<Jogo> jogos;

    public JogoAdapter (Context context, ArrayList<Jogo> jogos) {
        this.context = context;
        this.jogos = jogos;
    }

    @Override
    public int getCount() {
        return this.jogos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.jogos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Jogo jogo = (Jogo) getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_jogo, null);
        }

        TextView jogos_informacoes = (TextView) convertView.findViewById(R.id.jogos_informacoes);
        TextView jogos_competidores = (TextView) convertView.findViewById(R.id.jogos_competidores);
        TextView jogos_nome = (TextView) convertView.findViewById(R.id.jogos_nome);

        jogos_informacoes.setText(jogo.getId_modalidade());
        jogos_competidores.setText(jogo.getParticipantes());
        jogos_nome.setText(jogo.getNome());

        return convertView;
    }
}
