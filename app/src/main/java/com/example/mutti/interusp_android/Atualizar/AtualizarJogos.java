package com.example.mutti.interusp_android.Atualizar;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.Utils.SetFaculImage;
import com.example.mutti.interusp_android.Utils.SetListModalidade;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;

public class AtualizarJogos extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;
    CheckBox checkVencedor1;
    CheckBox checkVencedor2;

    boolean check1 = false;
    boolean check2 = false;

    ArrayList<Jogo> jogos = DataHolder.getInstance().getJogos();
    Jogo jogo_selecionado = new Jogo();

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

        boolean isPlacar = getIntent().getBooleanExtra("placar", false);
        String  jogo_id = getIntent().getStringExtra("jogo_id");

        LinearLayout placar = (LinearLayout) findViewById(R.id.placar);
        LinearLayout info = (LinearLayout) findViewById(R.id.info);

        ImageView modalidade = (ImageView) findViewById(R.id.atualizar_jogo_modalidade);
        ImageView competidor_1 = (ImageView) findViewById(R.id.imgTime1);
        ImageView competidor_2 = (ImageView) findViewById(R.id.imgTime2);

        TextView nome_jogo = (TextView) findViewById(R.id.atualizar_jogo_jogo);

        EditText placar1_edt = (EditText) findViewById(R.id.atualizar_jogo_placar1);
        EditText placar2_edt = (EditText) findViewById(R.id.atualizar_jogo_placar2);
        EditText local_edt = (EditText) findViewById(R.id.atualizar_jogo_local);
        EditText horario_edt = (EditText) findViewById(R.id.atualizar_jogo_horario);

        if (!isPlacar) {
            placar.setVisibility(View.GONE);
            info.setVisibility(View.VISIBLE);
        }

        for(Jogo jogo : jogos){
            if(jogo.get_id().equals(jogo_id)){
                jogo_selecionado=jogo;
            }
        }

        nome_jogo.setText(jogo_selecionado.getNome());
        if(jogo_selecionado.getFaculdade_1() != null && jogo_selecionado.getFaculdade_1() !=null) {
            competidor_1.setImageResource(SetFaculImage.Drawable(jogo_selecionado.getFaculdade_1()));
            competidor_2.setImageResource(SetFaculImage.Drawable(jogo_selecionado.getFaculdade_2()));
        }
        modalidade.setImageResource(SetListModalidade.Drawable(jogo_selecionado.getModalidade_id()));

        checkVencedor1 = (CheckBox) findViewById(R.id.checkVencedor1);
        check1 = checkVencedor1.isChecked();
        checkVencedor2 = (CheckBox) findViewById(R.id.checkVencedor2);
        check2 = checkVencedor2.isChecked();
        checkVencedor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!check1 && !check2) {
                    check1 = true;
                    checkVencedor1.setChecked(true);
                } else if (check2) {
                    check2 = false;
                    checkVencedor2.setChecked(false);
                    check1 = true;
                    checkVencedor1.setChecked(true);
                } else {
                    if (check1) {
                        check1 = false;
                        checkVencedor1.setChecked(false);
                    }
                }
            }
        });
        checkVencedor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!check1 && !check2) {
                    check2 = true;
                    checkVencedor2.setChecked(true);
                } else if (check1) {
                    check1 = false;
                    checkVencedor1.setChecked(false);
                    check2 = true;
                    checkVencedor2.setChecked(true);
                } else {
                    if (check2) {
                        check2 = false;
                        checkVencedor2.setChecked(false);
                    }
                }
            }
        });
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

        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity,"#000033");
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Atualizar Jogo");
        final ImageView back_button = (ImageView) findViewById(R.id.btnVoltar);
        back_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
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
