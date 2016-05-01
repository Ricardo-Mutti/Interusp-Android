package com.example.mutti.interusp_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Torcidometro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torcidometro);

        int total = 160;
        TreeMap<String, Integer> mapaTorcida = new TreeMap<>();
        mapaTorcida.put("POLI", 50);
        mapaTorcida.put("FEA", 40);
        mapaTorcida.put("FARMA", 30);
        mapaTorcida.put("ESALQ", 20);
        mapaTorcida.put("RIBEIRAO",10);
        mapaTorcida.put("SANFRAN", 5);
        mapaTorcida.put("ODONTO", 3);
        mapaTorcida.put("PINHEIROS", 2);

        Set<Map.Entry<String, Integer>> set = mapaTorcida.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );


        HashMap<String, Integer> coresEquipes = new HashMap<>();
        coresEquipes.put("POLI", R.color.POLI);
        coresEquipes.put("FEA", R.color.FEA);
        coresEquipes.put("FARMA", R.color.FARMA);
        coresEquipes.put("ESALQ", R.color.ESALQ);
        coresEquipes.put("RIBEIRAO", R.color.RIBEIRAO);
        coresEquipes.put("SANFRAN", R.color.SANFRAN);
        coresEquipes.put("ODONTO", R.color.ODONTO);
        coresEquipes.put("PINHEIROS", R.color.PINHEIROS);

        TextView tvNumeroTotal = (TextView)findViewById(R.id.tvNumeroTotal);
        tvNumeroTotal.setText(Integer.toString(total));

        LinearLayout llTorcida = (LinearLayout)findViewById(R.id.llTorcida);
        LayoutInflater inflater =  (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        List views = new ArrayList();

        for(TreeMap.Entry<String,Integer> entrada :list){
            System.out.println(entrada);
            LinearLayout llLinha = (LinearLayout) inflater.inflate(R.layout.torcidometro_linhas, null);
            ProgressBar pb = (ProgressBar)llLinha.findViewById(R.id.progressBar);
            pb.setProgress(entrada.getValue());
            pb.setMax(total);
            pb.getProgressDrawable().setColorFilter(getResources().getColor(coresEquipes.get(entrada.getKey())), android.graphics.PorterDuff.Mode.SRC_IN);
            TextView tv = (TextView)llLinha.findViewById(R.id.tvFaculdade);
            tv.setText(entrada.getKey()+": "+entrada.getValue());
            tv.setTextColor(getResources().getColor(coresEquipes.get(entrada.getKey())));
            views.add(llLinha);
        }
        for(int i=0; i<views.size(); i++){
            llTorcida.addView((View)views.get(i));
        }
    }
}
