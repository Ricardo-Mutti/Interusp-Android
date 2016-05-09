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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mutti.interusp_android.Manager.UpdateModalidade;
import com.example.mutti.interusp_android.Model.FaculdadePontuacao;
import com.example.mutti.interusp_android.Model.FaculdadePosicaoPontuacao;
import com.example.mutti.interusp_android.Model.Modalidade;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.SetListModalidade;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

public class AtualizarModalidade extends AppCompatActivity {

    Activity activity = this;
    Context context = this;
    boolean btn_pressed;

    public String colocacao_poli, colocacao_fea, colocacao_farma, colocacao_esalq, colocacao_riberao, colocacao_sanfran, colocacao_odonto, colocacao_pinheiros,
            min_poli, min_fea, min_farma, min_esalq, min_riberao, min_sanfran, min_odonto, min_pinheiros,
            final_poli, final_fea, final_farma, final_esalq, final_riberao, final_sanfran, final_odonto, final_pinheiros,
            max_poli, max_fea, max_farma, max_esalq, max_riberao, max_sanfran, max_odonto, max_pinheiros;

    TextView action_title;

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

        final int modalidade_id = getIntent().getIntExtra("modalidade_id",0);

        ImageView icon = (ImageView) findViewById(R.id.atualizar_modalidade_icon);
        icon.setImageResource( SetListModalidade.Drawable(String.valueOf(modalidade_id)));

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

        final EditText final_poli_edt = (EditText) findViewById(R.id.modalidade_atual_poli);
        final EditText final_fea_edt = (EditText) findViewById(R.id.modalidade_atual_fea);
        final EditText final_farma_edt = (EditText) findViewById(R.id.modalidade_atual_farma);
        final EditText final_esalq_edt = (EditText) findViewById(R.id.modalidade_atual_esalq);
        final EditText final_riberao_edt = (EditText) findViewById(R.id.modalidade_atual_riberao);
        final EditText final_sanfran_edt = (EditText) findViewById(R.id.modalidade_atual_san);
        final EditText final_odonto_edt = (EditText) findViewById(R.id.modalidade_atual_odonto);
        final EditText final_pinheiros_edt = (EditText) findViewById(R.id.modalidade_atual_pinheiros);

        final EditText max_poli_edt = (EditText) findViewById(R.id.modalidade_max_poli);
        final EditText max_fea_edt = (EditText) findViewById(R.id.modalidade_max_fea);
        final EditText max_farma_edt = (EditText) findViewById(R.id.modalidade_max_farma);
        final EditText max_esalq_edt = (EditText) findViewById(R.id.modalidade_max_esalq);
        final EditText max_riberao_edt = (EditText) findViewById(R.id.modalidade_max_riberao);
        final EditText max_sanfran_edt = (EditText) findViewById(R.id.modalidade_max_sanfran);
        final EditText max_odonto_edt = (EditText) findViewById(R.id.modalidade_max_odonto);
        final EditText max_pinheiros_edt = (EditText) findViewById(R.id.modalidade_max_pinheiros);


        final LinearLayout ll_final_poli = (LinearLayout) findViewById(R.id.modalidade_final_poli);
        final LinearLayout ll_final_fea = (LinearLayout) findViewById(R.id.modalidade_final_fea);
        final LinearLayout ll_final_farma = (LinearLayout) findViewById(R.id.modalidade_final_farma);
        final LinearLayout ll_final_esalq = (LinearLayout) findViewById(R.id.modalidade_final_esalq);
        final LinearLayout ll_final_riberao = (LinearLayout) findViewById(R.id.modalidade_final_riberao);
        final LinearLayout ll_final_sanfran = (LinearLayout) findViewById(R.id.modalidade_final_sanfran);
        final LinearLayout ll_final_odonto = (LinearLayout) findViewById(R.id.modalidade_final_odonto);
        final LinearLayout ll_final_pinheiro = (LinearLayout) findViewById(R.id.modalidade_final_pinheiro);

        final LinearLayout ll_colocacao_poli = (LinearLayout) findViewById(R.id.modalidade_colocao_poli_ll);
        final LinearLayout ll_colocacao_fea = (LinearLayout) findViewById(R.id.modalidade_colocao_fea_ll);
        final LinearLayout ll_colocacao_farma = (LinearLayout) findViewById(R.id.modalidade_colocao_farma_ll);
        final LinearLayout ll_colocacao_esalq = (LinearLayout) findViewById(R.id.modalidade_colocao_esalq_ll);
        final LinearLayout ll_colocacao_riberao = (LinearLayout) findViewById(R.id.modalidade_colocao_riberao_ll);
        final LinearLayout ll_colocacao_sanfran = (LinearLayout) findViewById(R.id.modalidade_colocao_sanfran_ll);
        final LinearLayout ll_colocacao_odonto = (LinearLayout) findViewById(R.id.modalidade_colocao_odonto_ll);
        final LinearLayout ll_colocacao_pinheiros = (LinearLayout) findViewById(R.id.modalidade_colocao_pinheiros_ll);

        ll_final_poli.setVisibility(View.GONE);
        ll_final_fea.setVisibility(View.GONE);
        ll_final_farma.setVisibility(View.GONE);
        ll_final_esalq.setVisibility(View.GONE);
        ll_final_riberao.setVisibility(View.GONE);
        ll_final_sanfran.setVisibility(View.GONE);
        ll_final_odonto.setVisibility(View.GONE);
        ll_final_pinheiro.setVisibility(View.GONE);
        ll_colocacao_poli.setVisibility(View.GONE);
        ll_colocacao_fea.setVisibility(View.GONE);
        ll_colocacao_farma.setVisibility(View.GONE);
        ll_colocacao_esalq.setVisibility(View.GONE);
        ll_colocacao_riberao.setVisibility(View.GONE);
        ll_colocacao_sanfran.setVisibility(View.GONE);
        ll_colocacao_odonto.setVisibility(View.GONE);
        ll_colocacao_pinheiros.setVisibility(View.GONE);

        final TextView modalidade_status = (TextView) findViewById(R.id.modalidade_status);
        final TextView modalidade_finalizada = (TextView) findViewById(R.id.modalidade_finalizada_btn);
        modalidade_finalizada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn_pressed=!btn_pressed;

                if (btn_pressed) {
                    ll_final_poli.setVisibility(View.VISIBLE);
                    ll_final_fea.setVisibility(View.VISIBLE);
                    ll_final_farma.setVisibility(View.VISIBLE);
                    ll_final_esalq.setVisibility(View.VISIBLE);
                    ll_final_riberao.setVisibility(View.VISIBLE);
                    ll_final_sanfran.setVisibility(View.VISIBLE);
                    ll_final_odonto.setVisibility(View.VISIBLE);
                    ll_final_pinheiro.setVisibility(View.VISIBLE);
                    ll_colocacao_poli.setVisibility(View.VISIBLE);
                    ll_colocacao_fea.setVisibility(View.VISIBLE);
                    ll_colocacao_farma.setVisibility(View.VISIBLE);
                    ll_colocacao_esalq.setVisibility(View.VISIBLE);
                    ll_colocacao_riberao.setVisibility(View.VISIBLE);
                    ll_colocacao_sanfran.setVisibility(View.VISIBLE);
                    ll_colocacao_odonto.setVisibility(View.VISIBLE);
                    ll_colocacao_pinheiros.setVisibility(View.VISIBLE);
                    modalidade_status.setText("Modalidade Encerrada!");
                    modalidade_finalizada.setBackground(activity.getResources().getDrawable(R.drawable.borda_chaveamento));
                    modalidade_finalizada.setTextColor(activity.getResources().getColor(R.color.azul_tema));

                }
                else{
                    ll_final_poli.setVisibility(View.GONE);
                    ll_final_fea.setVisibility(View.GONE);
                    ll_final_farma.setVisibility(View.GONE);
                    ll_final_esalq.setVisibility(View.GONE);
                    ll_final_riberao.setVisibility(View.GONE);
                    ll_final_sanfran.setVisibility(View.GONE);
                    ll_final_odonto.setVisibility(View.GONE);
                    ll_final_pinheiro.setVisibility(View.GONE);
                    ll_colocacao_poli.setVisibility(View.GONE);
                    ll_colocacao_fea.setVisibility(View.GONE);
                    ll_colocacao_farma.setVisibility(View.GONE);
                    ll_colocacao_esalq.setVisibility(View.GONE);
                    ll_colocacao_riberao.setVisibility(View.GONE);
                    ll_colocacao_sanfran.setVisibility(View.GONE);
                    ll_colocacao_odonto.setVisibility(View.GONE);
                    ll_colocacao_pinheiros.setVisibility(View.GONE);
                    modalidade_status.setText("Modalidade em Andamento");
                    modalidade_finalizada.setBackgroundColor(activity.getResources().getColor(R.color.azul_tema));
                    modalidade_finalizada.setTextColor(activity.getResources().getColor(R.color.branco));
                }


            }
        });

        Button atualizar = (Button) findViewById(R.id.modalidade_atualizar);
        if(atualizar!=null) {
            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Requisicao pra atualizar
                    Modalidade modalidade = new Modalidade();
                    modalidade.setId(modalidade_id);

                    FaculdadePontuacao[] max = new FaculdadePontuacao[8];
                    FaculdadePontuacao[] min = new FaculdadePontuacao[8];
                    FaculdadePosicaoPontuacao[] total = new FaculdadePosicaoPontuacao[8];

//                    Maximos
                    max_poli = max_poli_edt.getText().toString();
                    FaculdadePontuacao maxPoli = new FaculdadePontuacao();
                    maxPoli.setFaculdade(1);
                    maxPoli.setPontuacao(Integer.valueOf(max_poli));
                    max[0] = maxPoli;

                    max_fea = max_fea_edt.getText().toString();
                    FaculdadePontuacao maxFea = new FaculdadePontuacao();
                    maxFea.setFaculdade(2);
                    maxFea.setPontuacao(Integer.valueOf(max_fea));
                    max[1] = maxFea;

                    max_farma = max_farma_edt.getText().toString();
                    FaculdadePontuacao maxFarma = new FaculdadePontuacao();
                    maxFarma.setFaculdade(3);
                    maxFarma.setPontuacao(Integer.valueOf(max_farma));
                    max[2] = maxFarma;

                    max_esalq = max_esalq_edt.getText().toString();
                    FaculdadePontuacao maxEsalq = new FaculdadePontuacao();
                    maxEsalq.setFaculdade(4);
                    maxEsalq.setPontuacao(Integer.valueOf(max_esalq));
                    max[3] = maxEsalq;

                    max_riberao = max_riberao_edt.getText().toString();
                    FaculdadePontuacao maxRibeirao = new FaculdadePontuacao();
                    maxRibeirao.setFaculdade(5);
                    maxRibeirao.setPontuacao(Integer.valueOf(max_riberao));
                    max[4] = maxRibeirao;

                    max_sanfran = max_sanfran_edt.getText().toString();
                    FaculdadePontuacao maxSanfran = new FaculdadePontuacao();
                    maxSanfran.setFaculdade(6);
                    maxSanfran.setPontuacao(Integer.valueOf(max_sanfran));
                    max[5] = maxSanfran;

                    max_odonto = max_odonto_edt.getText().toString();
                    FaculdadePontuacao maxOdonto = new FaculdadePontuacao();
                    maxOdonto.setFaculdade(7);
                    maxOdonto.setPontuacao(Integer.valueOf(max_odonto));
                    max[6] = maxOdonto;

                    max_pinheiros = max_pinheiros_edt.getText().toString();
                    FaculdadePontuacao maxPinheiros = new FaculdadePontuacao();
                    maxPinheiros.setFaculdade(8);
                    maxPinheiros.setPontuacao(Integer.valueOf(max_pinheiros));
                    max[7] = maxPinheiros;

                    modalidade.setPontuacao_max(max);

//                    Minimo
                    min_poli = min_poli_edt.getText().toString();
                    FaculdadePontuacao minPoli = new FaculdadePontuacao();
                    minPoli.setFaculdade(1);
                    minPoli.setPontuacao(Integer.valueOf(min_poli));
                    min[0] = minPoli;

                    min_fea = min_fea_edt.getText().toString();
                    FaculdadePontuacao minFea = new FaculdadePontuacao();
                    minFea.setFaculdade(2);
                    minFea.setPontuacao(Integer.valueOf(min_fea));
                    min[1] = minFea;

                    min_farma = min_farma_edt.getText().toString();
                    FaculdadePontuacao minFarma = new FaculdadePontuacao();
                    minFarma.setFaculdade(3);
                    minFarma.setPontuacao(Integer.valueOf(min_farma));
                    min[2] = minPoli;

                    min_esalq = min_esalq_edt.getText().toString();
                    FaculdadePontuacao minEsalq = new FaculdadePontuacao();
                    minEsalq.setFaculdade(4);
                    minEsalq.setPontuacao(Integer.valueOf(min_esalq));
                    min[3] = minEsalq;

                    min_riberao = min_riberao_edt.getText().toString();
                    FaculdadePontuacao minRiberao = new FaculdadePontuacao();
                    minRiberao.setFaculdade(5);
                    minRiberao.setPontuacao(Integer.valueOf(min_riberao));
                    min[4] = minRiberao;

                    min_sanfran = min_sanfran_edt.getText().toString();
                    FaculdadePontuacao minSanfran = new FaculdadePontuacao();
                    minSanfran.setFaculdade(6);
                    minSanfran.setPontuacao(Integer.valueOf(min_sanfran));
                    min[5] = minSanfran;

                    min_odonto = min_odonto_edt.getText().toString();
                    FaculdadePontuacao minOdonto = new FaculdadePontuacao();
                    minOdonto.setFaculdade(7);
                    minOdonto.setPontuacao(Integer.valueOf(min_odonto));
                    min[6] = minOdonto;

                    min_pinheiros = min_pinheiros_edt.getText().toString();
                    FaculdadePontuacao minPinheiros = new FaculdadePontuacao();
                    minPinheiros.setFaculdade(8);
                    minPinheiros.setPontuacao(Integer.valueOf(min_poli));
                    min[7] = minPinheiros;

                    modalidade.setPontuacao_min(min);

//                    Total
                    if (btn_pressed) {
                        final_poli = final_poli_edt.getText().toString();
                        final_fea = final_fea_edt.getText().toString();
                        final_farma = final_farma_edt.getText().toString();
                        final_esalq = final_esalq_edt.getText().toString();
                        final_riberao = final_riberao_edt.getText().toString();
                        final_sanfran = final_sanfran_edt.getText().toString();
                        final_odonto = final_odonto_edt.getText().toString();
                        final_pinheiros = final_pinheiros_edt.getText().toString();

                        colocacao_poli = colocacao_poli_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalPoli = new FaculdadePosicaoPontuacao();
                        totalPoli.setFaculdade(1);
                        totalPoli.setPontuacao(Integer.valueOf(final_poli));
                        totalPoli.setPosicao(Integer.valueOf(colocacao_poli));
                        total[0] = totalPoli;

                        colocacao_fea = colocacao_fea_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalFea = new FaculdadePosicaoPontuacao();
                        totalFea.setFaculdade(2);
                        totalFea.setPontuacao(Integer.valueOf(final_fea));
                        totalFea.setPosicao(Integer.valueOf(colocacao_fea));
                        total[1] = totalFea;

                        colocacao_farma = colocacao_farma_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalFarma = new FaculdadePosicaoPontuacao();
                        totalFarma.setFaculdade(3);
                        totalFarma.setPontuacao(Integer.valueOf(final_farma));
                        totalFarma.setPosicao(Integer.valueOf(colocacao_farma));
                        total[2] = totalFarma;

                        colocacao_esalq = colocacao_esalq_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalEsalq = new FaculdadePosicaoPontuacao();
                        totalEsalq.setFaculdade(4);
                        totalEsalq.setPontuacao(Integer.valueOf(final_esalq));
                        totalEsalq.setPosicao(Integer.valueOf(colocacao_esalq));
                        total[3] = totalEsalq;

                        colocacao_riberao = colocacao_riberao_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalRiberao = new FaculdadePosicaoPontuacao();
                        totalRiberao.setFaculdade(5);
                        totalRiberao.setPontuacao(Integer.valueOf(final_riberao));
                        totalRiberao.setPosicao(Integer.valueOf(colocacao_riberao));
                        total[4] = totalRiberao;

                        colocacao_sanfran = colocacao_sanfran_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalSanfran = new FaculdadePosicaoPontuacao();
                        totalSanfran.setFaculdade(6);
                        totalSanfran.setPontuacao(Integer.valueOf(final_sanfran));
                        totalSanfran.setPosicao(Integer.valueOf(colocacao_sanfran));
                        total[5] = totalSanfran;

                        colocacao_odonto = colocacao_odonto_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalOdonto = new FaculdadePosicaoPontuacao();
                        totalOdonto.setFaculdade(7);
                        totalOdonto.setPontuacao(Integer.valueOf(final_odonto));
                        totalOdonto.setPosicao(Integer.valueOf(colocacao_odonto));
                        total[6] = totalOdonto;

                        colocacao_pinheiros = colocacao_pinheiros_edt.getText().toString();
                        FaculdadePosicaoPontuacao totalPinheiros = new FaculdadePosicaoPontuacao();
                        totalPinheiros.setFaculdade(8);
                        totalPinheiros.setPontuacao(Integer.valueOf(final_pinheiros));
                        totalPinheiros.setPosicao(Integer.valueOf(colocacao_pinheiros));
                        total[7] = totalPinheiros;

                        modalidade.setPontuacao_total(total);


                    }

                    UpdateModalidade update = new UpdateModalidade(context);
                    update.UpdateModalidade(modalidade);
                }
            });
        }

        //ACTION BAR
        StatusBarColor.setColorStatusBar(activity,"#000033");
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Atualizar Modalidade");
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
        activity.registerReceiver(receiver, new IntentFilter(Constants.kUpdateModalidadeDone));
    }

    @Override
    public void onStop() {
        super.onStop();
        activity.unregisterReceiver(receiver);
    }


}
