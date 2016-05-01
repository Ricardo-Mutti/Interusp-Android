package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mutti.interusp_android.Utils.SelectFragment;

public class Tabs_main extends FragmentActivity {

    Activity activity = this;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        SelectFragment.open(0, fragmentManager, activity);


    }
}
