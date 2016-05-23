package com.appsimples.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

import java.util.HashMap;

public class Vencedores extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        HashMap<String, String[]> mapaModalidades = new HashMap<>();
        String[] modalidades = getResources().getStringArray(R.array.modalidades);
        mapaModalidades.put(modalidades[0], new String[] {"2015: POLI", "2014: RIBEIRAO", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[1], new String[] {"2015: FEA", "2014: FEA", "2013: POLI"} );
        mapaModalidades.put(modalidades[2], new String[] {"2015: POLI", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[3], new String[] {"2015: POLI", "2014: POLI", "2013: POLI"} );
        mapaModalidades.put(modalidades[4], new String[] {"2015: FEA", "2014: FEA", "2013: POLI"} );
        mapaModalidades.put(modalidades[5], new String[] {"2015: RIBEIRAO", "2014: RIBEIRAO", "2013: ESALQ"} );
        mapaModalidades.put(modalidades[6], new String[] {"2015: PINHEIROS", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[7], new String[] {"2015: RIBEIRAO", "2014: FEA", "2013: POLI"} );
        mapaModalidades.put(modalidades[8], new String[] {"2015: FEA", "2014: FEA", "2013: POLI"} );
        mapaModalidades.put(modalidades[9], new String[] {"2015: POLI", "2014: FEA", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[10], new String[] {"2015: PINHEIROS", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put("Karatê Kata", new String[] {"2015: POLI", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put("Karatê Kumite", new String[] {"2015: PINHEIROS", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[12], new String[] {"2015: PINHEIROS", "2014: POLI", "2013: POLI"} );
        mapaModalidades.put(modalidades[13], new String[] {"2015: POLI", "2014: POLI", "2013: POLI"} );
        mapaModalidades.put(modalidades[14], new String[] {"2015: POLI", "2014: POLI", "2013: POLI"} );
        mapaModalidades.put(modalidades[15], new String[] {"2015: PINHEIROS", "2014: POLI", "2013: FEA"} );
        mapaModalidades.put(modalidades[16], new String[] {"2015: PINHEIROS", "2014: FEA", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[17], new String[] {"2015: PINHEIROS", "2014: FEA", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[18], new String[] {"2015: POLI", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[19], new String[] {"2015: PINHEIROS", "2014: POLI", "2013: PINHEIROS"} );
        mapaModalidades.put(modalidades[20], new String[] {"2015: POLI", "2014: POLI", "2013: SANFRAN"} );
        mapaModalidades.put(modalidades[21], new String[] {"2015: POLI", "2014: SANFRAN", "2013: POLI"} );
        mapaModalidades.put(modalidades[22], new String[] {"2015: POLI", "2014: POLI", "2013: FEA"} );
        mapaModalidades.put(modalidades[23], new String[] {"2015: FEA", "2014: POLI", "2013: FEA"} );
        mapaModalidades.put(modalidades[24], new String[] {"2015: FEA", "2014: -", "2013: -", "OBS: As competições foram iniciadas em 2015"} );
        mapaModalidades.put("Campeões Gerais", new String[] {"2015: PINHEIROS","2014: POLI","2013: PINHEIROS","2012: PINHEIROS","2011: POLI","2010: PINHEIROS","2009: POLI","2008: POLI","2007: PINHEIROS","2006: POLI"});

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vencedores);

        Intent intent = getIntent();
        String modalidade = intent.getStringExtra("Modalidade");

        TextView tvModalidade = (TextView)findViewById(R.id.modalidadeTextView);
        tvModalidade.setText(modalidade);

        ListView lv = (ListView)findViewById(R.id.vencedoresListView);
        if(!modalidade.equals("Karatê")) {
            lv.setAdapter(new ArrayAdapter<>(this, R.layout.historico_list_element, mapaModalidades.get(modalidade)));
        }else{
            String[] karate = new String[] {"Karatê Kata","2015: POLI", "2014: POLI", "2013: PINHEIROS","","Karatê Kumite","2015: PINHEIROS", "2014: POLI", "2013: PINHEIROS" };
            lv.setAdapter(new ArrayAdapter<>(this, R.layout.historico_list_element, karate));
        }

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Campeões Anteriores");
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
