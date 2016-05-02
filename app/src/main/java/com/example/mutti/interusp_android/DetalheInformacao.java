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

        final com.example.mutti.interusp_android.Model.ListaLocais listaLocais = getIntent().getParcelableExtra("listaLocais");

        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        btnJogos = (Button) findViewById(R.id.btnJogos);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        txtEnderecos = (TextView) findViewById(R.id.txtEndereco);

        txtTitulo.setText(listaLocais.getNome());
        txtInfo.setText(listaLocais.getPrincipaisModalidades());
        txtEnderecos.setText(listaLocais.getEndereco());
        ImageLoader.getInstance().displayImage(listaLocais.getFoto(), imgFoto);

        if(btnMapa!=null){
            btnMapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + listaLocais.getNome()
                            + "@" + listaLocais.getCoordenadas()[1] + "," + listaLocais.getCoordenadas()[0]));
                    startActivity(intent);
                }
            });
        }
        if(btnJogos!=null){
            btnJogos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, TabsMain.class);
                    intent.putExtra("tab", 3);
                    startActivity(intent);
                }
            });
        }
    }
}
