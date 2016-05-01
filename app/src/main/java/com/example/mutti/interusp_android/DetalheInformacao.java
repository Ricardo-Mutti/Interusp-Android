package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.*;

public class DetalheInformacao extends AppCompatActivity {

    ImageView imgFoto;
    Button btnJogos, btnMapa;
    TextView txtTitulo, txtInfo, txtEnderecos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_informacao);

        com.example.mutti.interusp_android.Model.Local local = getIntent().getParcelableExtra("local");

        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        btnJogos = (Button) findViewById(R.id.btnJogos);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        txtEnderecos = (TextView) findViewById(R.id.txtEndereco);

        txtTitulo.setText(local.getNome());
        txtInfo.setText(local.getPrincipaisModalidades());
        txtEnderecos.setText(local.getEndereco());
    }
}
