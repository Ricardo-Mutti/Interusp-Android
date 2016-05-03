package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mutti.interusp_android.Utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarJogos extends AppCompatActivity {

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
        setContentView(R.layout.activity_atualizar_jogos);


        EditText placar1_edt = (EditText) findViewById(R.id.atualizar_jogo_placar1);
        EditText placar2_edt = (EditText) findViewById(R.id.atualizar_jogo_placar2);
        EditText local_edt = (EditText) findViewById(R.id.atualizar_jogo_local);
        EditText horario_edt = (EditText) findViewById(R.id.atualizar_jogo_horario);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.datas_jogos)));
        Spinner atualizar_data = (Spinner) findViewById(R.id.atualizar_jogo_data);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atualizar_data.setAdapter(adapter3);

        String data = atualizar_data.getSelectedItem().toString();

        if (placar1_edt.getText() != null) {
            String placar1 = placar1_edt.getText().toString();
        }
        if (placar2_edt.getText() != null) {
            String placar2 = placar2_edt.getText().toString();
        }
        if (local_edt.getText() != null) {
            String local = local_edt.getText().toString();
        }
        if (horario_edt.getText() != null) {
            String horario = horario_edt.getText().toString();
        }


        Button atualizar = (Button) findViewById(R.id.atualizar_jogo_atualizar);
        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Atualizar jogo
            }
        });

    }



    @Override
    protected void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kJogosDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }


}
