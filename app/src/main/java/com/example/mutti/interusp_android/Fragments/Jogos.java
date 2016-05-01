package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.FilterAdapter;
import com.example.mutti.interusp_android.Adapter.JogoAdapter;
import com.example.mutti.interusp_android.Model.TipoJogo;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 30/04/16.
 */
public class Jogos extends Fragment {

    Activity activity;
    Context context;

    FilterAdapter filterAdapter;
    ListView filterListView;

    JogoAdapter jogoAdapter;
    ListView listView;

    Button filtroDia;
    Button filtroModalidade;
    Button filtroAtletica;
    Button filtroLocal;

    String stringDiaToFilter;
    String stringModalidadeToFilter;
    String stringAtleticaToFilter;
    String stringLocalToFilter;

    RelativeLayout containerFilter;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String cor1 = "cor1";
    public static final String cor2 = "cor2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();

        View rootview =  inflater.inflate(R.layout.fragment_jogos, container, false);

        containerFilter = (RelativeLayout) rootview.findViewById(R.id.containerFilter);
        containerFilter.setVisibility(View.GONE);
        containerFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerFilter.setVisibility(View.GONE);
            }
        });

        filtroDia = (Button) rootview.findViewById(R.id.jogos_btn_dia);
        filtroDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroDia();
            }
        });

        filtroModalidade = (Button) rootview.findViewById(R.id.jogos_btn_modalidade);
        filtroModalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroModalidade();
            }
        });

        filtroAtletica = (Button) rootview.findViewById(R.id.jogos_btn_atletica);
        filtroAtletica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroAtletica();
            }
        });

        filtroLocal = (Button) rootview.findViewById(R.id.jogos_btn_local);
        filtroLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFiltroLocal();
            }
        });

        filterListView = (ListView) rootview.findViewById(R.id.listFilter);
        listView = (ListView) rootview.findViewById(R.id.list);
        jogoAdapter = new JogoAdapter(getActivity(), TipoJogo.getJogosHardcoded());
        listView.setAdapter(jogoAdapter);

        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        filtroDia.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroDia.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        filtroModalidade.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroModalidade.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        filtroAtletica.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroAtletica.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));
        filtroLocal.setTextColor(Color.parseColor(sharedpreferences.getString(cor2, "#000000")));
        filtroLocal.setBackgroundColor(Color.parseColor(sharedpreferences.getString(cor1, "#000000")));

        return rootview;
    }

    public void showFiltroDia () {

        final ArrayList<String> filters = new ArrayList<String>(Arrays.asList(Constants.kFiltroJogoDia));
        filters.add("Todos");
        filterAdapter = new FilterAdapter(getActivity(), filters);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters.get(position);
                if (chosen.equals("Todos")) {
                    filtroDia.setText("Dia");
                    stringDiaToFilter = null;
                } else {
                    filtroDia.setText(chosen);
                    stringDiaToFilter = chosen;
                }
                filterList();
            }
        });

    }

    public void showFiltroModalidade () {

        final ArrayList<String> filters = new ArrayList<String>(Arrays.asList(Constants.kFiltroJogoModalidade));
        filters.add("Todos");
        filterAdapter = new FilterAdapter(getActivity(), filters);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters.get(position);
                if (chosen.equals("Todos")) {
                    filtroModalidade.setText("Modalidade");
                    stringModalidadeToFilter = null;
                } else {
                    filtroModalidade.setText(chosen);
                    stringModalidadeToFilter = chosen;
                }
                filterList();
            }
        });

    }

    public void showFiltroAtletica () {

        final ArrayList<String> filters = new ArrayList<String>(Arrays.asList(Constants.kFiltroJogoAtletica));
        filters.add("Todos");
        filterAdapter = new FilterAdapter(getActivity(), filters);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters.get(position);
                if (chosen.equals("Todos")) {
                    filtroAtletica.setText("Atletica");
                    stringAtleticaToFilter = null;
                } else {
                    filtroAtletica.setText(chosen);
                    stringAtleticaToFilter = chosen;
                }
                filterList();
            }
        });

    }

    public void showFiltroLocal () {

        final ArrayList<String> filters = new ArrayList<String>(Arrays.asList(Constants.kFiltroJogoLocal));
        filters.add("Todos");
        filterAdapter = new FilterAdapter(getActivity(), filters);
        filterListView.setAdapter(filterAdapter);
        containerFilter.setVisibility(View.VISIBLE);
        filterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                containerFilter.setVisibility(View.GONE);
                String chosen = filters.get(position);
                if (chosen.equals("Todos")) {
                    filtroLocal.setText("Local");
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
        ArrayList<TipoJogo> listToFilter = TipoJogo.getJogosHardcoded();
        ArrayList<TipoJogo> listFinal = new ArrayList<>();

        if (stringDiaToFilter != null) {
            for (TipoJogo jogo : listToFilter) {
                if (jogo.getDataString().equals(stringDiaToFilter)) {
                    listFinal.add(jogo);
                }
            }
            listToFilter = listFinal;
        }

        if (stringModalidadeToFilter != null) {
            for (TipoJogo jogo : listToFilter) {
                if (jogo.getModalidade().equals(stringModalidadeToFilter)) {
                    listFinal.add(jogo);
                }
            }
            listToFilter = listFinal;
        }

        if (stringAtleticaToFilter != null) {
            for (TipoJogo jogo : listToFilter) {
                for (String participant : jogo.getParticipantes()) {
                    if (participant.equals(stringAtleticaToFilter)) {
                        listFinal.add(jogo);
                    }
                }
            }
            listToFilter = listFinal;
        }

        if (stringLocalToFilter != null) {
            for (TipoJogo jogo : listToFilter) {
                if (jogo.getLocal().equals(stringLocalToFilter)) {
                    listFinal.add(jogo);
                }
            }
            listToFilter = listFinal;
        }

        jogoAdapter.jogos = listToFilter;
        jogoAdapter.notifyDataSetChanged();

    }

}