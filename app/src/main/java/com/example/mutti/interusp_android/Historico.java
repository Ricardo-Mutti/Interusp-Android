package com.example.mutti.interusp_android;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Historico extends AppCompatActivity {

    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        ListView lv = (ListView)findViewById(R.id.modalidadeTextView);

        lv.setAdapter((new ArrayAdapter<String>(this, R.layout.historico_list_element,
                getResources().getStringArray(R.array.modalidades))));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent vencedores = new Intent(activity, Vencedores.class);
                vencedores.putExtra("Modalidade", ((TextView) view).getText());
                startActivity(vencedores);
            }
        });

        Button bt = (Button) findViewById(R.id.btCampeoes);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vencedores = new Intent(activity, Vencedores.class);
                vencedores.putExtra("Modalidade", "Campeões Gerais");
                startActivity(vencedores);

            }
        });

    }


}
