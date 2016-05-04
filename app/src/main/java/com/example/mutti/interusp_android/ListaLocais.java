package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.Utils.DataHolder;

import java.util.ArrayList;

public class ListaLocais extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    private ArrayList<String> locais_nome = new ArrayList<>();
    private ArrayList<Locais> todos_locais = new ArrayList<>();//Todos os locais do banco
    private ArrayList<Locais> locais = new ArrayList<>();//Todos os locais desse tipo
    private ArrayList<Onibus> onibuses = new ArrayList<>();//Todos os locais desse tipo

    Locais local_selecionado = new Locais();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);

        todos_locais = DataHolder.getInstance().getLocaisSalvos();
        onibuses=DataHolder.getInstance().getOnibus();



        final TextView local = (TextView) findViewById(R.id.local_title);
        ImageView info_icon = (ImageView) findViewById(R.id.icon_info);
        ListView list_info = (ListView) findViewById(R.id.lista_infos);

        String titulo = getIntent().getStringExtra("nome");
        final int info_id = getIntent().getIntExtra("tipo", 0);

        setIcon(info_id, info_icon);

        if (local != null) {
            local.setText(titulo);
        }

        locais.clear();
        locais_nome.clear();


            //Procura todos os locais desse tipo
            for (Locais local1 : todos_locais) {
                if  ( local1.getTipo() == info_id) {
                    locais.add(local1);
                    locais_nome.add(local1.getNome());
                }
            }


        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.item_locais, locais_nome);
        list_info.setAdapter(adapter3);

        list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Procura o local selecionado na lista de locais
                    for (Locais local : locais) {
                        if (local.getNome().equals(locais_nome.get(position))) {
                            local_selecionado=local;

                        }
                    }
                    Intent intent = new Intent(activity, DetalheInformacao.class);
                    intent.putExtra("locais", local_selecionado);
                    startActivity(intent);
            }
        });
    }

    public void setIcon(int id, ImageView icon) {

        switch (id) {

            case 1:
                icon.setImageResource(R.drawable.info_ginasios);
                break;
            case 2:
                icon.setImageResource(R.drawable.info_tenda);
                break;
            case 3:
                icon.setImageResource(R.drawable.info_baladas);
                break;
            case 4:
                icon.setImageResource(R.drawable.info_onibus);
                break;
            case 5:
                icon.setImageResource(R.drawable.info_alojamento);
                break;
            case 6:
                icon.setImageResource(R.drawable.info_hospital);
                break;
            case 7:
                icon.setImageResource(R.drawable.info_delegacia);
                break;
            case 8:
                icon.setImageResource(R.drawable.info_restaurantes);
                break;
        }
    }
}
