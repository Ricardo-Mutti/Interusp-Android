package com.example.mutti.interusp_android.Atualizar;

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

import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarOnibus extends AppCompatActivity {

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
        setContentView(R.layout.activity_atualizar_onibus);

        EditText placa_edt = (EditText) findViewById(R.id.onibus_placa);
        EditText info_edt = (EditText) findViewById(R.id.onibus_info);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.faculdade)));
        Spinner onibus_facul = (Spinner) findViewById(R.id.onibus_facul_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        onibus_facul.setAdapter(adapter);

        ArrayList datas = new ArrayList();
        datas.addAll(Arrays.asList(getResources().getStringArray(R.array.datas_jogos)));
        Spinner atualizar_data = (Spinner) findViewById(R.id.onibus_data);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datas);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atualizar_data.setAdapter(adapter3);

        String placa = placa_edt.getText().toString();
        String info = info_edt.getText().toString();

        String data = atualizar_data.getSelectedItem().toString();
        String facul = onibus_facul.getSelectedItem().toString();


        Button atualizar = (Button) findViewById(R.id.onibus_atualizar);
        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Atualizar onibus
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kOnibusDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }
}
