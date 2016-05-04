package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.StatusBarColor;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    Activity activity = this;

    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarColor.setColorStatusBar(activity, "#000033");



        SharedPreferences settings = getSharedPreferences(MyPREFERENCES, 0);
        final boolean selecionado = settings.getBoolean("selecionado", false);//procura na pref variavel se nao tiver o default é false


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (selecionado) {
                    Intent intent1 = new Intent(activity, TabsMain.class);
                    startActivity(intent1);
                } else {
                    Intent intent1 = new Intent(activity, SelecionarAtletica.class);
                    startActivity(intent1);
                }

                activity.finish();

            }
        }, 3000);
    }
}
