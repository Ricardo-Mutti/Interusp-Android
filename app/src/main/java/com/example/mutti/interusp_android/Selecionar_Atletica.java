package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Manager.GetLocal;

public class Selecionar_Atletica extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar__atletica);

        ImageView atletica_poli = (ImageView) findViewById(R.id.atletica_poli);
        ImageView atletica_farma = (ImageView) findViewById(R.id.atletica_farma);
        ImageView atletica_fea = (ImageView) findViewById(R.id.atletica_fea);
        ImageView atletica_sanfran = (ImageView) findViewById(R.id.atletica_sanfran);
        ImageView atletica_esalq = (ImageView) findViewById(R.id.atletica_esalq);
        ImageView atletica_riberao = (ImageView) findViewById(R.id.atletica_riberao);
        ImageView atletica_odonto = (ImageView) findViewById(R.id.atletica_odonto);
        ImageView atletica_pinheiros = (ImageView) findViewById(R.id.atletica_pinheiros);
        TextView atletica_todos = (TextView) findViewById(R.id.atletica_todos);

        atletica_esalq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_poli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetLocal getLocation = new GetLocal(context);
                getLocation.getLocais();
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_fea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_farma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_sanfran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_odonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_riberao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_pinheiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });

        atletica_todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, Tabs_main.class);
                startActivity(intent);
            }
        });


    }
}
