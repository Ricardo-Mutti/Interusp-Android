package com.appsimples.mutti.interusp_android.Atualizar;

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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Manager.EditOnibus;
import com.appsimples.mutti.interusp_android.Model.Onibus;
import com.appsimples.mutti.interusp_android.R;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarOnibus extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    Onibus onibus_selecionado = new Onibus();

    TextView action_title;
    String info1;
    Button atualizar;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            activity.finish();
            atualizar.setEnabled(true);
            Intent intent1 = new Intent(activity, AtualizarMenu.class);
            startActivity(intent1);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_onibus);

        String placa = getIntent().getStringExtra("placa");
        ArrayList<Onibus> onibuses = DataHolder.getInstance().getOnibus();


        final EditText info_edt = (EditText) findViewById(R.id.onibus_info);
        final EditText placa_edt = (EditText) findViewById(R.id.onibus_placa);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.faculdade)));
        final Spinner onibus_facul = (Spinner) findViewById(R.id.onibus_facul_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        onibus_facul.setAdapter(adapter);

        ArrayList datas = new ArrayList();
        datas.addAll(Arrays.asList(getResources().getStringArray(R.array.datas_jogos)));
        final Spinner atualizar_data = (Spinner) findViewById(R.id.onibus_data);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datas);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atualizar_data.setAdapter(adapter3);


        if (!placa.equals("Novo onibus")) {
            for (Onibus onibus : onibuses) {
                if (onibus.getPlaca().equals(placa)) {
                    onibus_selecionado = onibus;
                }
            }
            placa_edt.setText(onibus_selecionado.getPlaca());

            onibus_facul.setSelection(Integer.parseInt(onibus_selecionado.getFacul_id()));
            String[] infos = onibus_selecionado.getInformacoes().split("\n");
            String data = infos[0];
            info1 = infos[2];
            info_edt.setText(info1);
            int position=0;
            switch (data) {

                case "Quinta-feira":
                    position = 1;
                    break;
                case "Sexta-feira":
                    position = 2;
                    break;
                case "Sábado":
                    position = 3;
                    break;
                case "Domingo":
                    position = 4;
                    break;
            }

            atualizar_data.setSelection(position);

        }


       atualizar = (Button) findViewById(R.id.onibus_atualizar);
        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Atualizar onibus

                final String placa = placa_edt.getText().toString();
                final String info = info_edt.getText().toString();

                final String data = atualizar_data.getSelectedItem().toString();
                final String facul = String.valueOf(onibus_facul.getSelectedItemPosition());

                EditOnibus editOnibus = new EditOnibus(context);
                editOnibus.sendRequest(facul, data + "\n\n" + info, placa);

                atualizar.setEnabled(false);
            }
        });

        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity, "#000033");
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Atualizar Ônibus");
        final ImageView back_button = (ImageView) findViewById(R.id.btnVoltar);
        back_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, AtualizarMenu.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        activity.finish();
        Intent intent1 = new Intent(activity, AtualizarSelecionarJogo.class);
        startActivity(intent1);
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
