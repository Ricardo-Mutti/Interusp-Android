package com.example.mutti.interusp_android.Utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.PontuacaoFaculdade;
import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 01/05/16.
 */
public class SetListAtletica {

    public static void setCell(View convertView, final Context context, com.example.mutti.interusp_android.Model.Pontuacao pontuacao){

        TextView txtPontoAtual = (TextView) convertView.findViewById(R.id.txtPontoAtual);
        TextView txtPontoMin = (TextView) convertView.findViewById(R.id.txtPontoMin);
        TextView txtPontoMax = (TextView) convertView.findViewById(R.id.txtPontoMax);
        ImageView imgAtletica = (ImageView) convertView.findViewById(R.id.imgAtletica);

        txtPontoAtual.setText("" + pontuacao.getPontoAtual());
        txtPontoMin.setText("" + pontuacao.getPontoMin());
        txtPontoMax.setText("" + pontuacao.getPontoMax());

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



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Fazer a requisao pra chamar os pontos da atletica selecionada
                Intent intent = new Intent(context, PontuacaoFaculdade.class);
                context.startActivity(intent);
            }
        });

    }

}
