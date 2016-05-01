package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.ArrayList;

public class Selecionar_Atletica extends AppCompatActivity {
    public int faculdade;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar__atletica);


        Button botaoAtleticaPoli = (Button) findViewById(R.id.botaoPoli);
        Button botaoAtleticaFea = (Button) findViewById(R.id.botaoFea);
        Button botaoAtleticaEsalq = (Button) findViewById(R.id.botaoEsalq);
        Button botaoAtleticaOdonto = (Button) findViewById(R.id.botaoOdonto);
        Button botaoAtleticaFarma = (Button) findViewById(R.id.botaoFarma);
        Button botaoAtleticaPinheiros = (Button) findViewById(R.id.botaoPinheiros);
        Button botaoAtleticaRibeirao = (Button) findViewById(R.id.botaoRibeirao);
        Button botaoAtleticaSanfran = (Button) findViewById(R.id.botaoSanfran);



        botaoAtleticaPoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "poli");
                startActivity(intent);
            }
        });

        botaoAtleticaFea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "fea");
                startActivity(intent);
            }
        });
        botaoAtleticaEsalq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "esalq");
                startActivity(intent);
            }
        });
        botaoAtleticaOdonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "odonto");
                startActivity(intent);
            }
        });
        botaoAtleticaFarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "farma");
                startActivity(intent);
            }
        });
        botaoAtleticaPinheiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "pinheiros");
                startActivity(intent);
            }
        });
        botaoAtleticaRibeirao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "ribeirao");
                startActivity(intent);
            }
        });
        botaoAtleticaSanfran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Gritos.class );
                intent.putExtra("atletica", "sanfran");
                startActivity(intent);
            }
        });


    }

}