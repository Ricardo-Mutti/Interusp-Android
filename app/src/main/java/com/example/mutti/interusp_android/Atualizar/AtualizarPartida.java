package com.example.mutti.interusp_android.Atualizar;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mutti.interusp_android.Adapter.AtualizarPartidaAdapter;
import com.example.mutti.interusp_android.Adapter.FilterAdapter;
import com.example.mutti.interusp_android.Adapter.JogoAdapter;
import com.example.mutti.interusp_android.Manager.GetJogos;
import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarPartida extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    FilterAdapter filterAdapter;
    ListView filterListView;
    ListView listView;
    AtualizarPartidaAdapter adapter;

    Button filtroDia;
    Button filtroModalidade;
    Button filtroAtletica;
    Button filtroLocal;

    int DiaToFilter;
    String stringModalidadeToFilter = null;
    int AtleticaToFilter = 0;
    String stringLocalToFilter = null;

    RelativeLayout containerFilter;

    ArrayList<Jogo> aux = new ArrayList<>();
    final ArrayList<String> filters_lugar = new ArrayList<>();

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String cor1 = "cor1";
    public static final String cor2 = "cor2";

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            setData();
            aux.clear();
            aux.addAll(DataHolder.getInstance().getJogos());
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_partida);


        GetJogos getJogos = new GetJogos(context);
        getJogos.GetJogos();

        containerFilter = (RelativeLayout) findViewById(R.id.containerFilter);
        containerFilter.setVisibility(View.GONE);
        containerFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerFilter.setVisibility(View.GONE);
            }
        });

        filtroDia = (Button) findViewById(R.id.jogos_btn_dia);
        filtroDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroDia();
            }
        });

        filtroModalidade = (Button) findViewById(R.id.jogos_btn_modalidade);
        filtroModalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroModalidade();
            }
        });

        filtroAtletica = (Button) findViewById(R.id.jogos_btn_atletica);
        filtroAtletica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroAtletica();
            }
        });

        filtroLocal = (Button) findViewById(R.id.jogos_btn_local);
        filtroLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroLocal();
            }
        });

        filterListView = (ListView) findViewById(R.id.listFilter);
        listView = (ListView) findViewById(R.id.list);
        adapter = new AtualizarPartidaAdapter(context, aux);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                final Jogo object = (Jogo) parent.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Selecione uma opção");
                builder.setItems(new CharSequence[]
                                {"Placar", "Informações"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                switch (which) {
                                    case 0:
                                        Intent intent = new Intent(context, AtualizarJogos.class);
                                        intent.putExtra("placar", true);
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        Intent intent1 = new Intent(context, AtualizarJogos.class);
                                        intent1.putExtra("placar", false);
                                        startActivity(intent1);
                                        break;
                                }
                            }
                        });
                builder.create().show();
            }
        });

        SharedPreferences sharedpreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        filtroDia.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroDia.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        filtroModalidade.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroModalidade.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        filtroAtletica.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroAtletica.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        filtroLocal.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroLocal.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
    }

    public void showFiltroDia() {

        final ArrayList<String> filters = new ArrayList<>(Arrays.asList(Constants.kFiltroJogoDia));
        filterAdapter = new FilterAdapter(activity, filters);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters.get(position);
                if (chosen.equals("Todos")) {
                    filtroDia.setText("Dia");
                    DiaToFilter = 0;
                } else {
                    filtroDia.setText(chosen);
                    DiaToFilter = position;
                }
                filterList();
            }
        });

    }

    public void showFiltroModalidade() {
        final ArrayList<String> filters = new ArrayList<>();
        filters.add("Todos");
        filters.addAll(Arrays.asList(getResources().getStringArray(R.array.modalidades)));
        filterAdapter = new FilterAdapter(activity, filters);

        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = String.valueOf(position - 1);
                String label = filters.get(position);
                if (label.equals("Todos")) {
                    filtroModalidade.setText("Modalidade");
                    stringModalidadeToFilter = null;
                } else {
                    filtroModalidade.setText(label);
                    stringModalidadeToFilter = chosen;
                }
                filterList();
            }
        });

    }

    public void showFiltroAtletica() {
        final ArrayList<String> filters = new ArrayList<>();
        filters.add("Todos");
        filters.addAll(Arrays.asList(getResources().getStringArray(R.array.facul_torcida)));
        filterAdapter = new FilterAdapter(activity, filters);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters.get(position);
                if (chosen.equals("Todos")) {
                    filtroAtletica.setText("Atlética");
                    AtleticaToFilter = 0;
                } else {
                    filtroAtletica.setText(chosen);
                    AtleticaToFilter = position - 1;
                }
                filterList();
            }
        });

    }

    public void showFiltroLocal() {
        filterAdapter = new FilterAdapter(activity, filters_lugar);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters_lugar.get(position);
                if (chosen.equals("Todos")) {
                    filtroLocal.setText("Locais");
                    stringLocalToFilter = null;
                } else {
                    filtroLocal.setText(chosen);
                    stringLocalToFilter = chosen;
                }
                filterList();
            }
        });

    }

    public void filterList() {
        aux.clear();
        aux.addAll(DataHolder.getInstance().getJogos());

        if (DiaToFilter != 0) {
            for (int i = aux.size() - 1; i >= 0; i--) {
                Jogo jogo = aux.get(i);
                if (jogo.getDia() != DiaToFilter) {
                    aux.remove(jogo);
                }
            }
        }

        if (stringModalidadeToFilter != null) {
            for (int i = aux.size() - 1; i >= 0; i--) {
                Jogo jogo = aux.get(i);
                if (!jogo.getModalidade_id().equals(stringModalidadeToFilter)) {
                    aux.remove(jogo);
                }
            }
        }


        if (stringModalidadeToFilter != null) {
            for (int i = aux.size() - 1; i >= 0; i--) {
                Jogo jogo = aux.get(i);

                if (!jogo.getFaculdade_1().equals(String.valueOf(AtleticaToFilter)) && !jogo.getFaculdade_2().equals(String.valueOf(AtleticaToFilter)) ) {
                    aux.remove(jogo);
                }
            }
        }

        if (stringLocalToFilter != null) {
            for (int i = aux.size() - 1; i >= 0; i--) {
                Jogo jogo = aux.get(i);
                if (!jogo.getLocal().equals(stringLocalToFilter)) {
                    aux.remove(jogo);
                }
            }
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kJogosDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }

    public void setData() {

        filters_lugar.add(0, "Todos");

        for (Jogo jogo : DataHolder.getInstance().getJogos()) {

            //        2012-03-18T05:50:34.000Z
            String[] parts = jogo.getData().split("-");
            String aux = parts[2];
            String[] aux1 = aux.split("T");
            String dia = aux1[0];

            switch (dia) {
                case "26":
                    jogo.setDia(1);
                    break;
                case "27":
                    jogo.setDia(2);
                    break;
                case "28":
                    jogo.setDia(3);
                    break;
                case "29":
                    jogo.setDia(4);
                    break;
                default:
                    jogo.setDia(4);
                    break;
            }

            if(jogo.getFaculdade_1()==null){
                jogo.setFaculdade_1("---");
            }

            if(jogo.getFaculdade_2()==null){
                jogo.setFaculdade_2("---");
            }

            boolean novo_lugar = true;
            for (int i = 0; i < filters_lugar.size(); i++) {
                String lugar = filters_lugar.get(i);
                if (lugar.equals(jogo.getLocal())) {
                    novo_lugar = false;
                }
            }
            if (novo_lugar) {
                filters_lugar.add(jogo.getLocal());
            }
        }
    }
}
