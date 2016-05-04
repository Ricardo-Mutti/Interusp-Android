package com.example.mutti.interusp_android.Utils;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.OnibusAdapter;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

public class DetalheOnibus extends AppCompatActivity {

    Context context = this;

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



    }
}
