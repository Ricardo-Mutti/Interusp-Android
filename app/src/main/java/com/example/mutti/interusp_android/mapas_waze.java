package com.example.mutti.interusp_android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class mapas_waze extends AppCompatActivity {
    private String lat;
    private String longi;
    private String label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_waze);

        Button btnAlojamento = (Button) findViewById(R.id.btnAlojamento);
        btnAlojamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnGinasio1 = (Button) findViewById(R.id.btnGinasio1);
        btnGinasio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = getResources().getString(R.string.latG1);
                longi = getResources().getString(R.string.longG1);
                label = "G1";

                openMap(lat, longi, label);
            }
        });
    }

    public void openMap(String lat, String longi, String label){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + label + "@" + lat + "," + longi));
        startActivity(intent);
    }
}
