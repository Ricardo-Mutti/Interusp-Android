package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

public class SelecionarAtletica extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String cor1 = "cor1";
    public static final String cor2 = "cor2";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar__atletica);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

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
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorEsalq1);
                editor.putString(cor2, Constants.kCorEsalq2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_poli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorPoli1);
                editor.putString(cor2, Constants.kCorPoli2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_fea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorFea1);
                editor.putString(cor2, Constants.kCorFea2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_farma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorFarma1);
                editor.putBoolean("selecionado", true);
                editor.putString(cor2, Constants.kCorFarma2);
                editor.commit();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_sanfran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorSanFran1);
                editor.putString(cor2, Constants.kCorSanFran2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_odonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorOdonto1);
                editor.putString(cor2, Constants.kCorOdonto2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_riberao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorRibeirao1);
                editor.putString(cor2, Constants.kCorRibeirao2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_pinheiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorMed1);
                editor.putString(cor2, Constants.kCorMed2);
                editor.putBoolean("selecionado", true);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });

        atletica_todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(cor1, Constants.kCorTodos1);
                editor.putBoolean("selecionado", true);
                editor.putString(cor2, Constants.kCorTodos2);
                editor.commit();
                activity.finish();
                Intent intent = new Intent(activity, TabsMain.class);
                startActivity(intent);
            }
        });


    }
}
