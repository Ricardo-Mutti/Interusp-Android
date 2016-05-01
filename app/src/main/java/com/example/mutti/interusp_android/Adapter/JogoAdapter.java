package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.TipoJogo;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Gabriel on 5/1/16.
 */
public class JogoAdapter extends BaseAdapter{

    Context context;
    public ArrayList<TipoJogo> jogos;

    public JogoAdapter (Context context, ArrayList<TipoJogo> jogos) {
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

        TipoJogo jogo = (TipoJogo) getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_jogo, null);
        }

        TextView modalidade = (TextView) convertView.findViewById(R.id.cell_jogo_modalidade);
        TextView title = (TextView) convertView.findViewById(R.id.cell_jogo_title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.cell_jogo_subtitle);
        TextView data = (TextView) convertView.findViewById(R.id.cell_jogo_data);
        TextView horario = (TextView) convertView.findViewById(R.id.cell_jogo_horario);
        TextView local = (TextView) convertView.findViewById(R.id.cell_jogo_local);

        modalidade.setText(jogo.getModalidade());
        title.setText(jogo.getTitle());
        subtitle.setText(jogo.getSubtitle());
        data.setText(jogo.getDataString());
        horario.setText(jogo.getHorario());
        local.setText(jogo.getLocal());

        return convertView;
    }
}
