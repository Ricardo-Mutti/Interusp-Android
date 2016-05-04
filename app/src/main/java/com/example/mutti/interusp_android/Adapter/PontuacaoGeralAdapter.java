package com.example.mutti.interusp_android.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.PontuacaoModalidade;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.SetListAtletica;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoGeralAdapter extends ArrayAdapter<Faculdade> {

    Context context;
    Activity activity;
    ArrayList<Faculdade> list;

    public PontuacaoGeralAdapter(Context context, Activity activity, ArrayList<Faculdade> list) {
        super(context, 0, list);
        this.context = context;
        this.activity = activity;
        this.list = list;
    }

    //Logica pra retornar o layout
    @Override
    public int getItemViewType(int position) {
        int type = 0;
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

        Faculdade pontuacao = list.get(position);
        int type = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (type == 0) {//Placar Geral

                convertView = inflater.inflate(R.layout.item_pontuacao_geral, null);
                SetListAtletica.setCell(convertView, context, pontuacao);

            } else {//Modalidades

                convertView = inflater.inflate(R.layout.layout_modalidades_placar, null);

                ImageView atletismo_feminino = (ImageView) convertView.findViewById(R.id.atletismo_feminino);
                ImageView atletismo = (ImageView) convertView.findViewById(R.id.atletismo);
                ImageView basquete_feminino = (ImageView) convertView.findViewById(R.id.basquete_feminino);
                ImageView basquete = (ImageView) convertView.findViewById(R.id.basquete);
                ImageView softbol = (ImageView) convertView.findViewById(R.id.softbol);
                ImageView beisebol = (ImageView) convertView.findViewById(R.id.beisebol);
                ImageView campo = (ImageView) convertView.findViewById(R.id.campo);
                ImageView futsal_feminino = (ImageView) convertView.findViewById(R.id.futsal_feminino);
                ImageView futsal = (ImageView) convertView.findViewById(R.id.futsal);
                ImageView handebol_feminino = (ImageView) convertView.findViewById(R.id.handebol_feminino);
                ImageView handebol = (ImageView) convertView.findViewById(R.id.handebol);
                ImageView judo = (ImageView) convertView.findViewById(R.id.judo);
                ImageView karate = (ImageView) convertView.findViewById(R.id.karate);
                ImageView natacao_feminino = (ImageView) convertView.findViewById(R.id.natacao_feminino);
                ImageView natacao = (ImageView) convertView.findViewById(R.id.natacao);
                ImageView polo = (ImageView) convertView.findViewById(R.id.polo);
                ImageView rugby_feminino = (ImageView) convertView.findViewById(R.id.rugby_feminino);
                ImageView rugby = (ImageView) convertView.findViewById(R.id.rugby);
                ImageView tenis_feminino = (ImageView) convertView.findViewById(R.id.tenis_feminino);
                ImageView tenis = (ImageView) convertView.findViewById(R.id.tenis);
                ImageView tenis_mesa_feminino = (ImageView) convertView.findViewById(R.id.tenis_mesa_feminino);
                ImageView tenis_mesa = (ImageView) convertView.findViewById(R.id.tenis_mesa);
                ImageView volei_feminino = (ImageView) convertView.findViewById(R.id.volei_feminino);
                ImageView volei = (ImageView) convertView.findViewById(R.id.volei);
                ImageView xadrez = (ImageView) convertView.findViewById(R.id.xadrez);

                atletismo_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "atletismo");
                        activity.startActivity(intent);
                    }
                });
                atletismo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "atletismo");
                        activity.startActivity(intent);
                    }
                });
                basquete_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "basquete");
                        activity.startActivity(intent);
                    }
                });
                basquete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "basquete");
                        activity.startActivity(intent);
                    }
                });
                softbol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "softbol");
                        activity.startActivity(intent);
                    }
                });
                beisebol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "beisebol");
                        activity.startActivity(intent);
                    }
                });
                campo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "futebol de campo");
                        activity.startActivity(intent);
                    }
                });
                futsal_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "futsal");
                        activity.startActivity(intent);
                    }
                });
                futsal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "futsal");
                        activity.startActivity(intent);
                    }
                });
                handebol_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "handebol");
                        activity.startActivity(intent);
                    }
                });
                handebol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "handebol");
                        activity.startActivity(intent);
                    }
                });
                judo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "judô");
                        activity.startActivity(intent);
                    }
                });
                karate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "karatê");
                        activity.startActivity(intent);
                    }
                });
                natacao_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "natação");
                        activity.startActivity(intent);
                    }
                });
                natacao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "natação");
                        activity.startActivity(intent);
                    }
                });
                polo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "pólo");
                        activity.startActivity(intent);
                    }
                });
                rugby_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "rugby");
                        activity.startActivity(intent);
                    }
                });
                rugby.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "rugby");
                        activity.startActivity(intent);
                    }
                });
                tenis_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "tênis");
                        activity.startActivity(intent);
                    }
                });
                tenis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "tênis");
                        activity.startActivity(intent);
                    }
                });
                tenis_mesa_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "tênis de mesa");
                        activity.startActivity(intent);
                    }
                });
                tenis_mesa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "tênis de mesa");
                        activity.startActivity(intent);
                    }
                });
                volei_feminino.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", true);
                        intent.putExtra("modalidade", "vôlei");
                        activity.startActivity(intent);
                    }
                });
                volei.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "vôlei");
                        activity.startActivity(intent);
                    }
                });
                xadrez.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, PontuacaoModalidade.class);
                        intent.putExtra("feminino", false);
                        intent.putExtra("modalidade", "xadrez");
                        activity.startActivity(intent);
                    }
                });
            }

        }

        return convertView;
    }
}
