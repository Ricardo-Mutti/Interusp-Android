package com.appsimples.mutti.interusp_android;

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

import com.appsimples.mutti.interusp_android.Adapter.OnibusAdapter;
import com.appsimples.mutti.interusp_android.Model.Onibus;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;

public class DetalheOnibus extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_onibus);

        int facul_id = getIntent().getIntExtra("facul_id", 0);

        ImageView onibus_facul = (ImageView) findViewById(R.id.onibus_facul);
        ListView onibus_list = (ListView) findViewById(R.id.lista_de_onibus);

        ArrayList<Onibus> onibuses = DataHolder.getInstance().getOnibus(); //Todos os locais desse tipo
        ArrayList<Onibus> onibuses_dessa_facul = new ArrayList<>();//Todos os locais desse tipo


        onibuses_dessa_facul.clear();
        //Procura todos os locais desse tipo
        for (Onibus onibus : onibuses) {
            if (onibus.getFacul_id().equals(String.valueOf(facul_id))) {
                onibuses_dessa_facul.add(onibus);
            }
        }

        OnibusAdapter onibusAdapter = new OnibusAdapter(context,onibuses_dessa_facul);
        onibus_list.setAdapter(onibusAdapter);


        switch (facul_id){

            case 1:
                onibus_facul.setImageResource(R.drawable.icon_poli);
                break;
            case 2:
                onibus_facul.setImageResource(R.drawable.icon_fea);
                break;
            case 3:
                onibus_facul.setImageResource(R.drawable.icon_farma);
                break;
            case 4:
                onibus_facul.setImageResource(R.drawable.icon_esalq);
                break;
            case 5:
                onibus_facul.setImageResource(R.drawable.icon_riberao);
                break;
            case 6:
                onibus_facul.setImageResource(R.drawable.icon_sanfran);
                break;
            case 7:
                onibus_facul.setImageResource(R.drawable.icon_odonto);
                break;
            case 8:
                onibus_facul.setImageResource(R.drawable.icon_pinheiros);
                break;
        }


        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity, sharedpreferences.getString("cor1", "#000000"));
        LinearLayout action_bar = (LinearLayout) findViewById(R.id.action_bar);
        action_bar.setBackgroundColor(Color.parseColor(sharedpreferences.getString("cor1", "#000000")));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Atualizar Ônibus");
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
