package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mutti.interusp_android.Utils.StatusBarColor;

import java.util.ArrayList;
import java.util.Arrays;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        StatusBarColor.setColorStatusBar(this, "#000033");

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.colaboradores)));

        ListView list_colaboradores = (ListView) findViewById(R.id.list_colaboradores);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.item_colaboradores, list);
        list_colaboradores.setAdapter(adapter3);


    }
}
