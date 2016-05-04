package com.example.mutti.interusp_android.Atualizar;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;

public class AtualizarModalidade extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    public String colocacao_poli,
            colocacao_fea,
            colocacao_farma,
            colocacao_esalq,
            colocacao_riberao,
            colocacao_sanfran,
            colocacao_odonto,
            colocacao_pinheiros, min_poli,
            min_fea,
            min_farma,
            min_esalq,
            min_riberao,
            min_sanfran,
            min_odonto,
            min_pinheiros, atual_poli,
            atual_fea,
            atual_farma,
            atual_esalq,
            atual_riberao,
            atual_sanfran,
            atual_odonto,
            atual_pinheiros,
            max_poli,
            max_fea,
            max_farma,
            max_esalq,
            max_riberao,
            max_sanfran,
            max_odonto,
            max_pinheiros;

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
        setContentView(R.layout.activity_atualizar_modalidade);

       final EditText colocacao_poli_edt = (EditText) findViewById(R.id.modalidade_colocacao_poli);
       final EditText colocacao_fea_edt = (EditText) findViewById(R.id.modalidade_colocacao_fea);
       final EditText colocacao_farma_edt = (EditText) findViewById(R.id.modalidade_colocacao_farma);
       final EditText colocacao_esalq_edt = (EditText) findViewById(R.id.modalidade_colocacao_esalq);
       final EditText colocacao_riberao_edt = (EditText) findViewById(R.id.modalidade_colocacao_riberao);
       final EditText colocacao_sanfran_edt = (EditText) findViewById(R.id.modalidade_colocacao_san);
       final EditText colocacao_odonto_edt = (EditText) findViewById(R.id.modalidade_colocacao_odonto);
       final EditText colocacao_pinheiros_edt = (EditText) findViewById(R.id.modalidade_colocacao_pinheiros);

       final EditText min_poli_edt = (EditText) findViewById(R.id.modalidade_min_poli);
       final EditText min_fea_edt = (EditText) findViewById(R.id.modalidade_min_fea);
       final EditText min_farma_edt = (EditText) findViewById(R.id.modalidade_min_farma);
       final EditText min_esalq_edt = (EditText) findViewById(R.id.modalidade_min_esalq);
       final EditText min_riberao_edt = (EditText) findViewById(R.id.modalidade_min_riberao);
       final EditText min_sanfran_edt = (EditText) findViewById(R.id.modalidade_min_san);
       final EditText min_odonto_edt = (EditText) findViewById(R.id.modalidade_min_odonto);
       final EditText min_pinheiros_edt = (EditText) findViewById(R.id.modalidade_min_pinheiros);

       final EditText atual_poli_edt = (EditText) findViewById(R.id.modalidade_atual_poli);
       final EditText atual_fea_edt = (EditText) findViewById(R.id.modalidade_atual_fea);
       final EditText atual_farma_edt = (EditText) findViewById(R.id.modalidade_atual_farma);
       final EditText atual_esalq_edt = (EditText) findViewById(R.id.modalidade_atual_esalq);
       final EditText atual_riberao_edt = (EditText) findViewById(R.id.modalidade_atual_riberao);
       final EditText atual_sanfran_edt = (EditText) findViewById(R.id.modalidade_atual_san);
       final EditText atual_odonto_edt = (EditText) findViewById(R.id.modalidade_atual_odonto);
       final EditText atual_pinheiros_edt = (EditText) findViewById(R.id.modalidade_atual_pinheiros);

       final EditText max_poli_edt = (EditText) findViewById(R.id.modalidade_max_poli);
       final EditText max_fea_edt = (EditText) findViewById(R.id.modalidade_max_fea);
       final EditText max_farma_edt = (EditText) findViewById(R.id.modalidade_max_farma);
       final EditText max_esalq_edt = (EditText) findViewById(R.id.modalidade_max_esalq);
       final EditText max_riberao_edt = (EditText) findViewById(R.id.modalidade_max_riberao);
       final EditText max_sanfran_edt = (EditText) findViewById(R.id.modalidade_max_sanfran);
       final EditText max_odonto_edt = (EditText) findViewById(R.id.modalidade_max_odonto);
       final EditText max_pinheiros_edt = (EditText) findViewById(R.id.modalidade_max_pinheiros);

        Button atualizar = (Button) findViewById(R.id.modalidade_atualizar);
        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Requisicao pra atualizar

                max_poli=max_poli_edt.getText().toString();
                max_fea=max_fea_edt.getText().toString();
                max_farma=max_farma_edt.getText().toString();
                max_esalq=max_esalq_edt.getText().toString();
                max_riberao=max_riberao_edt.getText().toString();
                max_sanfran= max_sanfran_edt.getText().toString();
                max_odonto=max_odonto_edt.getText().toString();
                max_pinheiros=max_pinheiros_edt.getText().toString();

                Log.d("Teste",max_pinheiros);

                min_poli=min_poli_edt.getText().toString();
                min_fea=min_fea_edt.getText().toString();
                min_farma= min_farma_edt.getText().toString();
                min_esalq=min_esalq_edt.getText().toString();
                min_riberao=min_riberao_edt.getText().toString();
                min_sanfran=min_sanfran_edt.getText().toString();
                min_odonto=min_odonto_edt.getText().toString();
                min_pinheiros=min_pinheiros_edt.getText().toString();

                atual_poli=atual_poli_edt.getText().toString();
                atual_fea=atual_fea_edt.getText().toString();
                atual_farma=atual_farma_edt.getText().toString();
                atual_esalq= atual_esalq_edt.getText().toString();
                atual_riberao_edt.getText().toString();
                atual_sanfran=atual_sanfran_edt.getText().toString();
                atual_odonto=atual_odonto_edt.getText().toString();
                atual_pinheiros= atual_pinheiros_edt.getText().toString();

                colocacao_poli=colocacao_poli_edt.getText().toString();
                colocacao_fea=colocacao_fea_edt.getText().toString();
                colocacao_farma=colocacao_farma_edt.getText().toString();
                colocacao_esalq=colocacao_esalq_edt.getText().toString();
                colocacao_riberao=colocacao_riberao_edt.getText().toString();
                colocacao_sanfran=colocacao_sanfran_edt.getText().toString();
                colocacao_odonto=colocacao_odonto_edt.getText().toString();
                colocacao_pinheiros=colocacao_pinheiros_edt.getText().toString();


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kModalidadesDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }





}
