package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.PontuacaoGeralAdapter;
import com.example.mutti.interusp_android.Manager.GetModalidades;
import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PontuacaoGeral extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    ListView listPontuacao;
    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_geral);

        listPontuacao = (ListView) findViewById(R.id.listPontuacao);

        GetModalidades getModalidades = new GetModalidades(context);
        getModalidades.getModalidades();

        ArrayList<Faculdade> list = new ArrayList<>();

        list.add(new Faculdade(0, 130, 140, 180));
        list.add(new Faculdade(1, 110, 120, 160));
        list.add(new Faculdade(2, 100, 120, 160));
        list.add(new Faculdade(3, 97, 100, 120));
        list.add(new Faculdade(4, 87, 90, 119));
        list.add(new Faculdade(5, 70, 87, 100));
        list.add(new Faculdade(6, 60, 68, 99));
        list.add(new Faculdade(7, 50, 56, 99));

        PontuacaoGeralAdapter adapter = new PontuacaoGeralAdapter(context,activity, list);
        listPontuacao.setAdapter(adapter);

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Pontuação Geral");
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
