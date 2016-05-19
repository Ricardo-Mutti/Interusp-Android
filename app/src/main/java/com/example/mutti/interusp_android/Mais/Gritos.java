package com.example.mutti.interusp_android.Mais;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.StatusBarColor;


public class Gritos extends AppCompatActivity {
    Activity activity = this;
    private boolean a = true;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    ImageView botao;
    ScrollView scroll;

    TextView action_title;

    public void mudaTexto(boolean k, TextView titulo, TextView texto, int x){
        if (k){
            texto.setMaxLines(100);
            if(x==1)
                this.a = false;
            if(x==2) {
                this.b = false;
                if (c && d){
                    scroll.post(new Runnable() {
                        @Override
                        public void run() {
                            scroll.fullScroll(View.FOCUS_DOWN);
                        }
                    });}}
            if(x==3) {
                this.c = false;
                if (d){
                    scroll.post(new Runnable() {
                        @Override
                        public void run() {
                            scroll.fullScroll(View.FOCUS_DOWN);
                        }
                    });}
            }
            if(x==4) {
                this.d = false;
                scroll.post(new Runnable() {
                    @Override
                    public void run() {
                        scroll.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }

        } else{
            texto.setMaxLines(0);
            if(x==1)
                this.a = true;
            if(x==2)
                this.b = true;
            if(x==3)
                this.c = true;
            if(x==4)
                this.d = true;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gritos);

        String atletica = getIntent().getStringExtra("atletica");

        final TextView titulo1 = (TextView) findViewById(R.id.textView);
        final TextView texto1 = (TextView) findViewById(R.id.textView3);
        final TextView titulo2 = (TextView) findViewById(R.id.textView4);
        final TextView texto2 = (TextView) findViewById(R.id.textView5);
        final TextView titulo3 = (TextView) findViewById(R.id.textView6);
        final TextView texto3 = (TextView) findViewById(R.id.textView7);
        final TextView titulo4 = (TextView) findViewById(R.id.textView8);
        final TextView texto4 = (TextView) findViewById(R.id.textView9);;
        scroll = (ScrollView) findViewById(R.id.scrollView);
        botao = (ImageView) findViewById(R.id.button50);
        switch (atletica){
            case "Politécnica":
                titulo1.setText(getResources().getString(R.string.titulo1Poli));
                titulo2.setText(getResources().getString(R.string.titulo2Poli));
                titulo3.setText(getResources().getString(R.string.titulo3Poli));
                titulo4.setText(getResources().getString(R.string.titulo4Poli));
                texto1.setText(getResources().getString(R.string.grito1Poli));
                texto2.setText(getResources().getString(R.string.grito2Poli));
                texto3.setText(getResources().getString(R.string.grito3Poli));
                texto4.setText(getResources().getString(R.string.grito4Poli));
                botao.setImageResource(R.drawable.icon_poli);
                break;
            case "FEA":
                titulo1.setText(getResources().getString(R.string.titulo1Fea));
                titulo2.setText(getResources().getString(R.string.titulo2Fea));
                titulo3.setText(getResources().getString(R.string.titulo3Fea));
                titulo4.setText(getResources().getString(R.string.titulo4Fea));
                texto1.setText(getResources().getString(R.string.texto1Fea));
                texto2.setText(getResources().getString(R.string.texto2Fea));
                texto3.setText(getResources().getString(R.string.texto3Fea));
                texto4.setText(getResources().getString(R.string.texto4Fea));
                botao.setImageResource(R.drawable.icon_fea);

                break;
            case "ESALQ":
                titulo1.setText((getResources().getString(R.string.titulo1Esalq)));
                texto1.setText((getResources().getString(R.string.texto1Esalq)));
                botao.setImageResource(R.drawable.icon_esalq);
                break;
            case "Odontologia":
                titulo1.setText((getResources().getString(R.string.titulo1Odonto)));
                titulo2.setText((getResources().getString(R.string.titulo2Odonto)));
                texto1.setText((getResources().getString(R.string.texto1Odonto)));
                texto2.setText((getResources().getString(R.string.texto2Odonto)));
                botao.setImageResource(R.drawable.icon_odonto);
                break;
            case "Farmácia":
                titulo1.setText((getResources().getString(R.string.titulo1Farma)));
                texto1.setText((getResources().getString(R.string.texto1Farma)));
                botao.setImageResource(R.drawable.icon_farma);
                break;
            case "Medicina - Pinheiros":
                titulo1.setText((getResources().getString(R.string.titulo1Pinheiros)));
                titulo2.setText((getResources().getString(R.string.titulo2Pinheiros)));
                titulo3.setText((getResources().getString(R.string.titulo3Pinheiros)));
                titulo4.setText((getResources().getString(R.string.titulo4Pinheiros)));
                texto1.setText((getResources().getString(R.string.texto1Pinheiros)));
                texto2.setText((getResources().getString(R.string.texto2Pinheiros)));
                texto3.setText((getResources().getString(R.string.texto3Pinheiros)));
                texto4.setText((getResources().getString(R.string.texto4Pinheiros)));
                botao.setImageResource(R.drawable.icon_pinheiros);
                break;
            case "Medicina - Ribeirão Preto":
                titulo1.setText((getResources().getString(R.string.titulo1Ribeirao)));
                titulo2.setText((getResources().getString(R.string.titulo2Ribeirao)));
                titulo3.setText((getResources().getString(R.string.titulo3Ribeirao)));
                titulo4.setText((getResources().getString(R.string.titulo4Ribeirao)));
                texto1.setText((getResources().getString(R.string.texto1Ribeirao)));
                texto2.setText((getResources().getString(R.string.texto2Ribeirao)));
                texto3.setText((getResources().getString(R.string.texto3Ribeirao)));
                texto4.setText((getResources().getString(R.string.texto4Ribeirao)));
                botao.setImageResource(R.drawable.icon_riberao);
                break;
            case "São Francisco":
                titulo1.setText((getResources().getString(R.string.titulo1Sanfran)));
                titulo2.setText((getResources().getString(R.string.titulo2Sanfran)));
                titulo3.setText((getResources().getString(R.string.titulo3Sanfran)));
                titulo4.setText((getResources().getString(R.string.titulo4Sanfran)));
                texto1.setText((getResources().getString(R.string.texto1Sanfran)));
                texto2.setText((getResources().getString(R.string.texto2Sanfran)));
                texto3.setText((getResources().getString(R.string.texto3Sanfran)));
                texto4.setText((getResources().getString(R.string.texto4Sanfran)));
                botao.setImageResource(R.drawable.icon_sanfran);
                break;
        }

        titulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaTexto(a, titulo1, texto1, 1);
            }
        });
        titulo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaTexto(b, titulo2, texto2, 2);
            }
        });
        titulo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaTexto(c, titulo3, texto3, 3);
            }
        });
        titulo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaTexto(d, titulo4, texto4, 4);
            }
        });


        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Gritos");
        LinearLayout action_bar = (LinearLayout) findViewById(R.id.action_bar);
        action_bar.setBackgroundColor(Color.parseColor(sharedpreferences.getString("cor1", "#000000")));
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


}
