package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AtualizarMenu extends AppCompatActivity {

    Activity activity = this;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);

        TextView label = (TextView) findViewById(R.id.txtActionBar);
        label.setText("Edição dos Resultados");

        Button jogos = (Button) findViewById(R.id.btnJogos_adm);
        jogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, AtualizarJogos.class);
                startActivity(intent1);
            }
        });

        Button natacao = (Button) findViewById(R.id.btnNatacao_adm);
        natacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, AtualizarProvas.class);
                startActivity(intent1);
            }
        });
        Button atletismo = (Button) findViewById(R.id.btnAtletismo_adm);
        atletismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(activity, AtualizarProvas.class);
                startActivity(intent1);

            }
        });
        Button modalidade = (Button) findViewById(R.id.btnModalidade);
        modalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, AtualizarModalidade.class);
                startActivity(intent1);

            }
        });
        Button onibus = (Button) findViewById(R.id.btnOnibus_adm);
        onibus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, AtualizarOnibus.class);
                startActivity(intent1);

            }
        });
        Button logout = (Button) findViewById(R.id.btnLogout_adm);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, TabsMain.class);
                startActivity(intent1);

            }
        });

    }


}
