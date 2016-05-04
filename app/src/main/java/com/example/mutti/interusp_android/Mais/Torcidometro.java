package com.example.mutti.interusp_android.Mais;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mutti.interusp_android.Manager.GetTorcida;
import com.example.mutti.interusp_android.Model.Torcida;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.DataHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class Torcidometro extends AppCompatActivity {

    Context context = this;
    Activity activity = this;

    String total;

    String progresso_poli, progresso_pinheiro, progresso_farma, progresso_esalq, progresso_fea,
            progresso_riberao, progresso_sanfran, progresso_odonto;

    TextView torcida_primeira, torcida_segunda, torcida_terceira, torcida_quarta,
            torcida_quinta, torcida_sexta, torcida_setima, torcida_oitava, total_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torcidometro);

        ArrayList<Torcida> torcidas = DataHolder.getInstance().getTorcidas();

        ArrayList facul_name = new ArrayList();
        facul_name.addAll(Arrays.asList(getResources().getStringArray(R.array.facul_torcida)));


        ProgressBar torcida_poli = (ProgressBar) findViewById(R.id.torcida_poli);
        ProgressBar torcida_fea = (ProgressBar) findViewById(R.id.torcida_fea);
        ProgressBar torcida_farma = (ProgressBar) findViewById(R.id.torcida_farma);
        ProgressBar torcida_esalq = (ProgressBar) findViewById(R.id.torcida_esalq);
        ProgressBar torcida_riberao = (ProgressBar) findViewById(R.id.torcida_riberao);
        ProgressBar torcida_sanfran = (ProgressBar) findViewById(R.id.torcida_sanfran);
        ProgressBar torcida_odonto = (ProgressBar) findViewById(R.id.torcida_odonto);
        ProgressBar torcida_pinheiros = (ProgressBar) findViewById(R.id.torcida_pinheiros);

        torcida_primeira = (TextView) findViewById(R.id.torcida_primeira);
        torcida_segunda = (TextView) findViewById(R.id.torcida_segunda);
        torcida_terceira = (TextView) findViewById(R.id.torcida_terceira);
        torcida_quarta = (TextView) findViewById(R.id.torcida_quarta);
        torcida_quinta = (TextView) findViewById(R.id.torcida_quinta);
        torcida_sexta = (TextView) findViewById(R.id.torcida_sexta);
        torcida_setima = (TextView) findViewById(R.id.torcida_setima);
        torcida_oitava = (TextView) findViewById(R.id.torcida_oitava);
        total_txt = (TextView) findViewById(R.id.tvNumeroTotal);

        torcida_poli.setScaleY(2f);
        torcida_fea.setScaleY(2f);
        torcida_farma.setScaleY(2f);
        torcida_esalq.setScaleY(2f);
        torcida_riberao.setScaleY(2f);
        torcida_sanfran.setScaleY(2f);
        torcida_odonto.setScaleY(2f);
        torcida_pinheiros.setScaleY(2f);

        torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(0).getFacul_id())).toString());
        torcida_esalq.getProgressDrawable().setColorFilter(
                getResources().getColor(R.color.azul_tema), android.graphics.PorterDuff.Mode.SRC_IN);

        if (!torcidas.isEmpty()) {

            total = torcidas.get(0).getUsers_count();
            total_txt.setText(total);

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(0).getFacul_id())).toString());
//            torcida_esalq.setProgressTintList(Value);

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(1).getFacul_id())).toString());

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(2).getFacul_id())).toString());

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(3).getFacul_id())).toString());

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(4).getFacul_id())).toString());

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(5).getFacul_id())).toString());

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(6).getFacul_id())).toString());

            progresso_poli = torcidas.get(0).getUsers_count();
            torcida_primeira.setText(facul_name.get(Integer.parseInt(torcidas.get(7).getFacul_id())).toString());

            torcida_poli.setMax(Integer.parseInt(total));
            torcida_poli.setProgress(Integer.parseInt(progresso_poli));

            torcida_fea.setMax(Integer.parseInt(total));
            torcida_fea.setProgress(Integer.parseInt(progresso_fea));

            torcida_farma.setMax(Integer.parseInt(total));
            torcida_farma.setProgress(Integer.parseInt(progresso_farma));

            torcida_riberao.setMax(Integer.parseInt(total));
            torcida_riberao.setProgress(Integer.parseInt(progresso_riberao));

            torcida_sanfran.setMax(Integer.parseInt(total));
            torcida_sanfran.setProgress(Integer.parseInt(progresso_sanfran));

            torcida_odonto.setMax(Integer.parseInt(total));
            torcida_odonto.setProgress(Integer.parseInt(progresso_odonto));

            torcida_pinheiros.setMax(Integer.parseInt(total));
            torcida_pinheiros.setProgress(Integer.parseInt(progresso_pinheiro));

            torcida_esalq.setMax(Integer.parseInt(total));
            torcida_esalq.setProgress(Integer.parseInt(progresso_esalq));

        }

    }
}