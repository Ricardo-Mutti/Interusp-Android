package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Arrays;

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

         String competidor_1 = "---";
         String competidor_2 = "---";
         String dia_semana;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_jogo, null);
        }

        TextView jogos_informacoes = (TextView) convertView.findViewById(R.id.jogos_informacoes);
        TextView jogos_competidores = (TextView) convertView.findViewById(R.id.jogos_competidores);
        TextView jogos_nome = (TextView) convertView.findViewById(R.id.jogos_nome);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(context.getResources().getStringArray(R.array.facul_torcida)));

//        2012-03-18T05:50:34.000Z
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
            if ((Integer.parseInt(jogo.getFaculdade_1())) > 0) {
                competidor_1=list.get(Integer.parseInt(jogo.getFaculdade_1())-1).toString();
            }
        }

        if(jogo.getFaculdade_2().equals("---")){
            competidor_2="---";
        }else{
            if ((Integer.parseInt(jogo.getFaculdade_2())) > 0) {
                competidor_2=list.get(Integer.parseInt(jogo.getFaculdade_2())-1).toString();
            }
        }
        if(jogo.is_prova()){
            jogos_competidores.setText("Todos");
        }else{
            jogos_competidores.setText(competidor_1+" X "+competidor_2);
        }

        jogos_nome.setText(modalidades.get(Integer.parseInt(jogo.getModalidade_id())-1)+" - "+jogo.getNome());

        return convertView;
    }
}
