package com.example.mutti.interusp_android.Mais;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mutti.interusp_android.Adapter.SelecaoAtleticaAdapter;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Arrays;

public class GritosAtletica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_atletica);

        ArrayList atleticaList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.faculdade)));

        if (atleticaList != null) {
            atleticaList.remove(0);

            ListView list = (ListView) findViewById(R.id.listAtletica);
            SelecaoAtleticaAdapter adapter = new SelecaoAtleticaAdapter(this, atleticaList);
            list.setAdapter(adapter);
        }
    }
}
