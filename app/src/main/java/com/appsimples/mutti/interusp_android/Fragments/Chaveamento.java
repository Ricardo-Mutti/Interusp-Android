package com.appsimples.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.appsimples.mutti.interusp_android.ChaveamentoModalidade;
import com.appsimples.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 30/04/16.
 */
public class Chaveamento extends Fragment {

    Activity activity;
    Context context;

    ArrayList list = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.modalidades_com_chaveamento)));

        View rootview = inflater.inflate(R.layout.fragment_chaveamento, container, false);

        final ListView list_info = (ListView) rootview.findViewById(R.id.chaveamento_modalidade);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, list);
        list_info.setAdapter(adapter3);

        list_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(activity, ChaveamentoModalidade.class);
                int modalidade;
                if(position<9) modalidade = position + 3;
                else modalidade = position + 6;
                intent.putExtra("modalidade", modalidade );
                intent.putExtra("nomeModalidade", String.valueOf(list.get(position)));
                startActivity(intent);
            }
        });


        return rootview;
    }

}