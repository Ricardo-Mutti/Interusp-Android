package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Torcidometro extends AppCompatActivity {

    String total = "100";

    String progresso_poli,progresso_pinheiro,progresso_farma,progresso_esalq,progresso_fea,
            progresso_riberao,progresso_sanfran,progresso_odonto ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torcidometro);

        ProgressBar torcida_poli = (ProgressBar) findViewById(R.id.torcida_poli);
        ProgressBar torcida_fea = (ProgressBar) findViewById(R.id.torcida_fea);
        ProgressBar torcida_farma = (ProgressBar) findViewById(R.id.torcida_farma);
        ProgressBar torcida_esalq = (ProgressBar) findViewById(R.id.torcida_esalq);
        ProgressBar torcida_riberao = (ProgressBar) findViewById(R.id.torcida_riberao);
        ProgressBar torcida_sanfran = (ProgressBar) findViewById(R.id.torcida_sanfran);
        ProgressBar torcida_odonto = (ProgressBar) findViewById(R.id.torcida_odonto);
        ProgressBar torcida_pinheiros = (ProgressBar) findViewById(R.id.torcida_pinheiros);

        torcida_poli.setScaleY(2f);
        torcida_fea.setScaleY(2f);
        torcida_farma.setScaleY(2f);
        torcida_esalq.setScaleY(2f);
        torcida_riberao.setScaleY(2f);
        torcida_sanfran.setScaleY(2f);
        torcida_odonto.setScaleY(2f);
        torcida_pinheiros.setScaleY(2f);

        progresso_poli = "34";
        progresso_pinheiro = "34";
        progresso_farma = "34";
        progresso_esalq = "34";
        progresso_fea = "34";
        progresso_riberao = "34";
        progresso_sanfran = "34";
        progresso_odonto = "34";

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