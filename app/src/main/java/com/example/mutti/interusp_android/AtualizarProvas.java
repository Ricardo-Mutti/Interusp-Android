package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mutti.interusp_android.Utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarProvas extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            activity.finish();
            Intent intent1 = new Intent(activity, AtualizarMenu.class);
            startActivity(intent1);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_colocacao_jogos);

        EditText local_edt = (EditText) findViewById(R.id.prova_local);
        EditText horario_edt = (EditText) findViewById(R.id.prova_horario);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.faculdade)));

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);

        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);

        Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter8);

        ArrayList datas = new ArrayList();
        datas.addAll(Arrays.asList(getResources().getStringArray(R.array.datas_jogos)));
        Spinner atualizar_data = (Spinner) findViewById(R.id.prova_data);
        ArrayAdapter<String> adapter_datas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datas);
        adapter_datas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atualizar_data.setAdapter(adapter_datas);

        if (local_edt.getText() != null) {
            String local = local_edt.getText().toString();
        }
        if (horario_edt.getText() != null) {
            String horario = horario_edt.getText().toString();
        }

        String data = atualizar_data.getSelectedItem().toString();

        String posicao_1 = spinner.getSelectedItem().toString();
        String posicao_2 = spinner2.getSelectedItem().toString();
        String posicao_3 = spinner3.getSelectedItem().toString();
        String posicao_4 = spinner4.getSelectedItem().toString();
        String posicao_5 = spinner5.getSelectedItem().toString();
        String posicao_6 = spinner6.getSelectedItem().toString();
        String posicao_7 = spinner7.getSelectedItem().toString();
        String posicao_8 = spinner8.getSelectedItem().toString();



        Button atualizar = (Button) findViewById(R.id.atualizar_prova);
        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Atualizar prova
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kProvasDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }

}
