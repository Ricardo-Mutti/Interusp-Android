package com.example.mutti.interusp_android.Atualizar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.TabsMain;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

public class AtualizarMenu extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);

        Button jogos = (Button) findViewById(R.id.btnJogos_adm);
        jogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, AtualizarPartida.class);
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
        Button locais = (Button) findViewById(R.id.btnLocais);
        locais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, AtualizarLocal.class);
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


        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Menu Administrador");
        action_title.setTextColor(Color.parseColor(sharedpreferences.getString("cor2", "#000000")));
        final ImageView back_button = (ImageView) findViewById(R.id.btnVoltar);
        back_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title.setTextColor(Color.parseColor(sharedpreferences.getString("cor2", "#000000")));
    }
}
