package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Fragments.Jogos;
import com.example.mutti.interusp_android.Model.*;
import com.nostra13.universalimageloader.core.ImageLoader;

public class DetalheInformacao extends AppCompatActivity {

    Activity activity = this;
    ImageView imgFoto;
    Button btnJogos, btnMapa;
    TextView txtTitulo, txtInfo, txtEnderecos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_informacao);

        final com.example.mutti.interusp_android.Model.Local local = getIntent().getParcelableExtra("local");

        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        btnJogos = (Button) findViewById(R.id.btnJogos);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        txtEnderecos = (TextView) findViewById(R.id.txtEndereco);

        txtTitulo.setText(local.getNome());
        txtInfo.setText(local.getPrincipaisModalidades());
        txtEnderecos.setText(local.getEndereco());
        ImageLoader.getInstance().displayImage(local.getFoto(), imgFoto);

        if(btnMapa!=null){
            btnMapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + local.getNome()
                            + "@" + local.getCoordenadas()[1] + "," + local.getCoordenadas()[0]));
                    startActivity(intent);
                }
            });
        }
        if(btnJogos!=null){
            btnJogos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, Tabs_main.class);
                    intent.putExtra("tab", 3);
                    startActivity(intent);
                }
            });
        }
    }
}
