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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Manager.EditJogoInfos;
import com.appsimples.mutti.interusp_android.Manager.EditJogoPlacar;
import com.appsimples.mutti.interusp_android.Model.FaculdadePosicaoPontuacao;
import com.appsimples.mutti.interusp_android.Model.Jogo;
import com.appsimples.mutti.interusp_android.Model.Locais;
import com.appsimples.mutti.interusp_android.R;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.Utils.SetFaculImage;
import com.appsimples.mutti.interusp_android.Utils.SetListModalidade;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AtualizarJogos extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;
    CheckBox checkVencedor1;
    CheckBox checkVencedor2;

    boolean check1 = false;
    boolean check2 = false;

    String placar1 = "---";
    String placar2 = "---";
    String local = "---";
    String horario = "---";

    ArrayList<Jogo> jogos = DataHolder.getInstance().getJogos();
    Jogo jogo_selecionado = new Jogo();

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            activity.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_jogos);

        final boolean isPlacar = getIntent().getBooleanExtra("placar", false);
        String jogo_id = getIntent().getStringExtra("jogo_id");

        final LinearLayout placar = (LinearLayout) findViewById(R.id.placar);
        LinearLayout info = (LinearLayout) findViewById(R.id.info);

        ImageView modalidade = (ImageView) findViewById(R.id.atualizar_jogo_modalidade);
        ImageView competidor_1 = (ImageView) findViewById(R.id.imgTime1);
        ImageView competidor_2 = (ImageView) findViewById(R.id.imgTime2);

        TextView nome_jogo = (TextView) findViewById(R.id.atualizar_jogo_jogo);

        final EditText placar1_edt = (EditText) findViewById(R.id.atualizar_jogo_placar1);
        final EditText placar2_edt = (EditText) findViewById(R.id.atualizar_jogo_placar2);
        final EditText horario_edt = (EditText) findViewById(R.id.atualizar_jogo_horario);


        TextView placar_tv = (TextView) findViewById(R.id.placar_label);
        TextView vencendor = (TextView) findViewById(R.id.vencedor);

        checkVencedor1 = (CheckBox) findViewById(R.id.checkVencedor1);
        checkVencedor2 = (CheckBox) findViewById(R.id.checkVencedor2);


        if (isPlacar) {
            placar.setVisibility(View.VISIBLE);
            info.setVisibility(View.GONE);
            placar1_edt.setVisibility(View.VISIBLE);
            placar1_edt.setLeft(15);
            placar2_edt.setVisibility(View.VISIBLE);
            placar2_edt.setLeft(15);
            placar_tv.setVisibility(View.VISIBLE);
            checkVencedor1.setVisibility(View.VISIBLE);
            checkVencedor2.setVisibility(View.VISIBLE);
            vencendor.setVisibility(View.VISIBLE);
            competidor_1.setVisibility(View.VISIBLE);
            competidor_2.setVisibility(View.VISIBLE);
        } else {
            placar1_edt.setVisibility(View.GONE);
            placar2_edt.setVisibility(View.GONE);
            placar_tv.setVisibility(View.GONE);
            checkVencedor1.setVisibility(View.GONE);
            checkVencedor2.setVisibility(View.GONE);
            vencendor.setVisibility(View.GONE);
            competidor_1.setVisibility(View.GONE);
            competidor_2.setVisibility(View.GONE);
        }


        for (Jogo jogo : jogos) {
            if (jogo.get_id().equals(jogo_id)) {
                jogo_selecionado.set_id(jogo.get_id());
                jogo_selecionado.setModalidade_id(jogo.getModalidade_id());
                jogo_selecionado.setNome(jogo.getNome());
                jogo_selecionado.setIs_prova(jogo.is_prova());
                jogo_selecionado.setData(jogo.getData());
                jogo_selecionado.setLocal(jogo.getLocal());
                jogo_selecionado.setChaveamento(jogo.getChaveamento());
                jogo_selecionado.setFaculdade_1(jogo.getFaculdade_1());
                jogo_selecionado.setFaculdade_2(jogo.getFaculdade_2());
                jogo_selecionado.setPlacar_1(jogo.getPlacar_1());
                jogo_selecionado.setPlacar_2(jogo.getPlacar_2());
                jogo_selecionado.setGanhador(jogo.getGanhador());
                jogo_selecionado.setDia(jogo.getDia());
            }
        }

        //Sun, 18 Mar 2012 05:51:34 GMT
        String[] parts = jogo_selecionado.getData().split("-");
        String aux = parts[2];
        String[] aux1 = aux.split("T");
        String aux2[] = aux1[1].split(":");
        String horario1 = aux2[0] + ":" + aux2[1];

        nome_jogo.setText(jogo_selecionado.getNome());
        horario_edt.setText(horario1);

        if (jogo_selecionado.getFaculdade_1() != null && jogo_selecionado.getFaculdade_1() != null) {
            competidor_1.setImageResource(SetFaculImage.Drawable(jogo_selecionado.getFaculdade_1()));
            competidor_2.setImageResource(SetFaculImage.Drawable(jogo_selecionado.getFaculdade_2()));
        }
        modalidade.setImageResource(SetListModalidade.Drawable(jogo_selecionado.getModalidade_id()));

        check1 = checkVencedor1.isChecked();
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

        if(jogo_selecionado.getPlacar_1()!=null){
            placar1_edt.setText(jogo_selecionado.getPlacar_1());
        }
        if(jogo_selecionado.getPlacar_2()!=null){
            placar2_edt.setText(jogo_selecionado.getPlacar_2());
        }

        //spinner dos locais
        ArrayList<String> locais = new ArrayList<>();
        for (Locais lugarDeJogos : DataHolder.getInstance().getLocaisSalvos()) {
            if (lugarDeJogos.getTipo() == 1 || lugarDeJogos.getTipo() == 9 ) {
                locais.add(lugarDeJogos.getNome());
            }
        }
        final Spinner atualizar_local = (Spinner) findViewById(R.id.atualizar_jogo_local);
        Collections.sort(locais, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, locais);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atualizar_local.setAdapter(adapter3);

        //spinner da data
        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.datas_jogos)));
        final Spinner atualizar_data = (Spinner) findViewById(R.id.atualizar_jogo_data);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atualizar_data.setAdapter(adapter1);


        String dia = aux1[0];
        int position = 0;

        switch (dia) {

            case "26":
                position = 1;
                break;
            case "27":
                position = 2;
                break;
            case "28":
                position = 3;
                break;
            case "29":
                position = 4;
                break;
        }

        atualizar_data.setSelection(position);

        Button atualizar = (Button) findViewById(R.id.atualizar_jogo_atualizar);
        if (atualizar != null) {
            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final String data = atualizar_data.getSelectedItem().toString();
                    final String local = atualizar_local.getSelectedItem().toString();

                    if (placar1_edt.getText() != null) {
                        placar1 = placar1_edt.getText().toString();
                    }
                    if (placar2_edt.getText() != null) {
                        placar2 = placar2_edt.getText().toString();
                    }
                    if (horario_edt.getText() != null) {
                        horario = horario_edt.getText().toString();
                    }

                    //Atualizar jogo
                    if (isPlacar) {
                        jogo_selecionado.setPlacar_1(placar1);
                        jogo_selecionado.setPlacar_2(placar2);
                        if (checkVencedor1.isChecked()) {
                            jogo_selecionado.setGanhador(Integer.parseInt(jogo_selecionado.getFaculdade_1()));
                        } else {
                            jogo_selecionado.setGanhador(Integer.parseInt(jogo_selecionado.getFaculdade_2()));
                        }
                        EditJogoPlacar editJogoPlacar = new EditJogoPlacar(context);
                        editJogoPlacar.updateJogo(jogo_selecionado);
                    } else {
                        jogo_selecionado.setLocal(local);
                        String dataStr = jogo_selecionado.getData();
                        //Sun, 18 Mar 2012 05:51:34 GMT
                        switch (data) {
                            case "Quinta-feira":
                                dataStr = "Thu, 26 May 2016 " + horario + ":00 GMT";
                                break;
                            case "Sexta-feira":
                                dataStr = "Fri, 27 May 2016 " + horario + ":00 GMT";
                                break;
                            case "Sábado":
                                dataStr = "Sat, 28 May 2016 " + horario + ":00 GMT";
                                break;
                            case "Domingo":
                                dataStr = "Sun, 29 May 2016 " + horario + ":00 GMT";
                                break;
                        }
                        jogo_selecionado.setData(dataStr);
                        EditJogoInfos editJogoInfos = new EditJogoInfos(context);
                        editJogoInfos.updateJogo(jogo_selecionado);

                    }

                }
            });
        }

        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity, "#000033");
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
    public void onBackPressed() {
        activity.finish();
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
