package com.example.mutti.interusp_android.Mais;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.StatusBarColor;
import com.example.mutti.interusp_android.Vencedores;


public class Historico extends AppCompatActivity {

    Activity activity = this;

    TextView action_title;

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

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Histórico");
        LinearLayout action_bar = (LinearLayout) findViewById(R.id.action_bar);
        action_bar.setBackgroundColor(Color.parseColor(sharedpreferences.getString("cor1", "#000000")));
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
