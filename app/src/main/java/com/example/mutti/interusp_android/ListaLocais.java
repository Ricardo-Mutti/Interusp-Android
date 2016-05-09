package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Atualizar.AtualizarLocal;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaLocais extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    private ArrayList<String> locais_nome = new ArrayList<>();
    private ArrayList<Locais> todos_locais = new ArrayList<>();//Todos os locais do banco
    private ArrayList<Locais> locais = new ArrayList<>();//Todos os locais desse tipo
    private ArrayList<Onibus> onibuses = new ArrayList<>();//Todos os locais desse tipo

    Locais local_selecionado = new Locais();
    TextView action_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);

        todos_locais = DataHolder.getInstance().getLocaisSalvos();
        onibuses = DataHolder.getInstance().getOnibus();

        final boolean edicao = getIntent().getBooleanExtra("edicao", false);

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
            if (local1.getTipo() == info_id) {
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
                        local_selecionado = local;

                    }
                }

                Intent intent;
                if (edicao) {
                    intent = new Intent(activity, AtualizarLocal.class);
                } else {
                    intent = new Intent(activity, DetalheInformacao.class);
                }
                intent.putExtra("locais", local_selecionado);
                startActivity(intent);
            }
        });

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity, sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Informações");
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
        if(edicao){
            StatusBarColor.setColorStatusBar(activity,"#000033");
            action_bar.setBackgroundColor(Color.parseColor("#000033"));
        }
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
