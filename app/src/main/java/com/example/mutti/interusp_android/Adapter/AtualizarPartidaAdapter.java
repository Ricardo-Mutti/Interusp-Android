package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Victor on 06/05/2016.
 */
public class AtualizarPartidaAdapter extends ArrayAdapter<Jogo> {

    Context context;
    ArrayList<Jogo>  list;

    String competidor_1;
    String competidor_2;
    String dia_semana;


    public AtualizarPartidaAdapter(Context context, ArrayList<Jogo>  list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Jogo getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Jogo jogo = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_jogo, null);
        }

        TextView jogos_informacoes = (TextView) convertView.findViewById(R.id.jogos_informacoes);
        TextView jogos_competidores = (TextView) convertView.findViewById(R.id.jogos_competidores);
        TextView jogos_nome = (TextView) convertView.findViewById(R.id.jogos_nome);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(context.getResources().getStringArray(R.array.facul_torcida)));

        String[] parts = jogo.getData().split("-");
        String aux = parts[2];
        String[] aux1 = aux.split("T");
        String dia = aux1[0];
        String aux2[] = aux1[1].split(":");
        String horario = aux2[0] +":"+ aux2[1];

        switch (dia){

            case "26":
                dia_semana="Quinta-feira";
                break;
            case "27":
                dia_semana="Sexta-feira";
                break;
            case "28":
                dia_semana="Sábado";
                break;
            case "29":
                dia_semana="Domingo";
                break;
            default:
                dia_semana="Domingo";
                break;
        }

        ArrayList modalidades = new ArrayList();
        modalidades.addAll(Arrays.asList(context.getResources().getStringArray(R.array.modalidades)));

        jogos_informacoes.setText(dia_semana+" - "+dia+"/05"+" - "+horario+" - "+jogo.getLocal());


        if(jogo.getFaculdade_1().equals("---")){
            competidor_1="---";
        }else{
            competidor_1=list.get(Integer.parseInt(jogo.getFaculdade_1())-1).toString();
        }

        if(jogo.getFaculdade_2().equals("---")){
            competidor_2="---";
        }else{
            competidor_2=list.get(Integer.parseInt(jogo.getFaculdade_2())-1).toString();
        }
        jogos_competidores.setText(competidor_1+" X "+competidor_2);
        jogos_nome.setText(modalidades.get(Integer.parseInt(jogo.getModalidade_id()))+" - "+jogo.getNome());

        return convertView;
    }
}
