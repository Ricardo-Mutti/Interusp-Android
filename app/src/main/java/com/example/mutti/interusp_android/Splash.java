package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                    activity.finish();
                    Intent intent1 = new Intent(activity, Selecionar_Atletica.class);
                    intent1.putExtra("Nome", "WendlerEis");
                startActivity(intent1);

            }
        }, 3000);
    }
}
