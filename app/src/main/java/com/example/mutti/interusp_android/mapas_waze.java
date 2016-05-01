package com.example.mutti.interusp_android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mapas_waze extends AppCompatActivity {
    private double current_lat = 23.868192;
    private double current_longi = -46.7297060;
    private double dest_address = 23.868192;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_waze);

        Button button = (Button) findViewById(R.id.btnAlojamento);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:/a/maps.google.com/maps?"
                        + "saddr="+ current_lat+","+current_longi + "&daddr="+dest_address));

                intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
