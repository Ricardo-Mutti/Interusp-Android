package com.example.mutti.interusp_android.Atualizar;

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

import com.example.mutti.interusp_android.ChaveamentoModalidade;
import com.example.mutti.interusp_android.ListaLocais;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AtualizarListaEdicao extends AppCompatActivity {

    Context context = this;
    Activity activity = this;

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_lista_edicao);

        String tipo_edicao = getIntent().getStringExtra("tipo_edicao");
        final ListView list_info = (ListView) findViewById(R.id.chaveamento_modalidade);

        final TextView nome_edicao = (TextView) findViewById(R.id.tipo_modalidade);

        switch (tipo_edicao) {

            case "Natacao":
                list.addAll(Arrays.asList(getResources().getStringArray(R.array.provas_natacao)));
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, list);
                list_info.setAdapter(adapter1);
                nome_edicao.setText("Provas de Natação");
                list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(activity, AtualizarProvas.class);
                        intent.putExtra("nomeModalidade", String.valueOf(list.get(position)));
                        startActivity(intent);
                    }
                });
                break;

            case "Atletismo":
                list.addAll(Arrays.asList(getResources().getStringArray(R.array.provas_atletismo)));
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, list);
                list_info.setAdapter(adapter2);

                list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(activity, AtualizarProvas.class);
                        intent.putExtra("nomeModalidade", String.valueOf(list.get(position)));
                        startActivity(intent);
                    }
                });
                break;

            case "Onibus":
                ArrayList<Onibus> onibuses = DataHolder.getInstance().getOnibus();
                nome_edicao.setText("Edição do onibus da sua faculdade");
                for (Onibus onibus : onibuses) {
                    list.add(onibus.getPlaca());
                }
                Collections.sort(list);
                ArrayAdapter<String> adapter3 = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_dropdown_item, list);
                list_info.setAdapter(adapter3);

                list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(activity, AtualizarOnibus.class);
                        intent.putExtra("placa", list.get(position));
                        startActivity(intent);
                    }
                });
                break;

            case "Locais":
                list.addAll(Arrays.asList(getResources().getStringArray(R.array.tipo_locais)));
                ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, list);
                list_info.setAdapter(adapter4);
                nome_edicao.setText("Edição de locais");

                list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Intent intent = new Intent(activity, AtualizarLocal.class);
                            intent.putExtra("tipo", position);
                            intent.putExtra("edicao", true);
                            intent.putExtra("novo_lugar", true);
                            intent.putExtra("nome", list.get(position));
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(activity, ListaLocais.class);
                            intent.putExtra("tipo", position);
                            intent.putExtra("edicao", true);
                            intent.putExtra("nome", list.get(position));
                            startActivity(intent);
                        }

                    }
                });
                break;

            case "Modalidades":
                list.addAll(Arrays.asList(getResources().getStringArray(R.array.modalidades)));
                ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, list);
                list_info.setAdapter(adapter5);
                nome_edicao.setText("Edição de modalidades");

                list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(activity, AtualizarModalidade.class);
                        intent.putExtra("nomeModalidade", String.valueOf(list.get(position)));
                        intent.putExtra("modalidade_id", position+1);
                        startActivity(intent);
                    }
                });
                break;

        }


        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity, "#000033");
        TextView action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Atualiza Local");
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
