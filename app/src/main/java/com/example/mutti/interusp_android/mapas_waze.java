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

        Button btnCampo1 = (Button) findViewById(R.id.btnCampo1);
        btnCampo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = getResources().getString(R.string.latCampo1);
                longi = getResources().getString(R.string.longCampo1);
                label = "Campo";

                openMap(lat, longi, label);
            }
        });

        Button btnCampo2 = (Button) findViewById(R.id.btnCampo2);
        btnCampo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = getResources().getString(R.string.latCampo2);
                longi = getResources().getString(R.string.longCampo2);
                label = "Campo de Futebol";

                openMap(lat, longi, label);
            }
        });

        Button btnG1 = (Button) findViewById(R.id.btnG1);
        btnG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = getResources().getString(R.string.latG1);
                longi = getResources().getString(R.string.longG1);
                label = "G1";

                openMap(lat, longi, label);
            }
        });

        Button btnG2 = (Button) findViewById(R.id.btnG2);
        btnG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = getResources().getString(R.string.latG2);
                longi = getResources().getString(R.string.longG2);
                label = "G2";

                openMap(lat, longi, label);
            }
        });
    }

    public void openMap(String lat, String longi, String label){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + label + "@" + lat + "," + longi));
        startActivity(intent);
    }
}
