package com.appsimples.mutti.interusp_android.Mais;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Adapter.TorcidometroAdapter;
import com.appsimples.mutti.interusp_android.Model.Torcida;
import com.appsimples.mutti.interusp_android.R;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;

public class Torcidometro extends AppCompatActivity {

    Context context = this;
    Activity activity = this;

    String total;

    String progresso_poli, progresso_pinheiro, progresso_farma, progresso_esalq, progresso_fea,
            progresso_riberao, progresso_sanfran, progresso_odonto;

    TextView torcida_primeira, torcida_segunda, torcida_terceira, torcida_quarta,
            torcida_quinta, torcida_sexta, torcida_setima, torcida_oitava, total_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torcidometro);

        ArrayList<Torcida> torcidas = DataHolder.getInstance().getTorcidas();

        ArrayList facul_name = new ArrayList();
        facul_name.addAll(Arrays.asList(getResources().getStringArray(R.array.facul_torcida)));


        total_txt = (TextView) findViewById(R.id.tvNumeroTotal);
        ListView listview = (ListView) findViewById(R.id.torcidas);



        int totalInt = 0;
        for (Torcida torcida : torcidas) {
            totalInt += Integer.parseInt(torcida.getUsers_count());
        }

        TorcidometroAdapter torcidometroAdapter = new TorcidometroAdapter(context, torcidas, totalInt);

        listview.setAdapter(torcidometroAdapter);

        total = String.valueOf(totalInt);
        total_txt.setText(total);

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity, sharedpreferences.getString("cor1", "#000000"));
        LinearLayout action_bar = (LinearLayout) findViewById(R.id.action_bar);
        action_bar.setBackgroundColor(Color.parseColor(sharedpreferences.getString("cor1", "#000000")));
        TextView action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Torcidômetro");
        action_title.setTextColor(Color.parseColor(sharedpreferences.getString("cor2", "#000000")));
        final ImageView back_button = (ImageView) findViewById(R.id.btnVoltar);
        back_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });


    }
}