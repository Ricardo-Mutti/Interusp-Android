package com.example.mutti.interusp_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Informacoes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);
    }

    public void abrirginasio(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Ginásios");
        startActivity(intent);

    }

    public void abrirtenda(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Tenda");
        startActivity(intent);

    }

    public void abrirbalada(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Baladas");
        startActivity(intent);

    }

    public void abrironibus(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Ônibus");
        startActivity(intent);

    }

    public void abriralojamentos(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Alojamentos");
        startActivity(intent);

    }

    public void abrirhospital(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Hospital");
        startActivity(intent);

    }

    public void abrirdelegacia(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Delegacia");
        startActivity(intent);

    }

    public void abrirrestaurantes(View view) {
        Intent intent = new Intent(this, Local.class);
        intent.putExtra("nome","Restaurantes");
        startActivity(intent);

    }
}



