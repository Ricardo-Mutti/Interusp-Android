package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Adapter.SelecaoAtleticaAdapter;
import com.example.mutti.interusp_android.Utils.StatusBarColor;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class GritosAtletica extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_atletica);

        ArrayList atleticaList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.faculdade)));

        if (atleticaList != null) {
            atleticaList.remove(0);

            ListView list = (ListView) findViewById(R.id.listAtletica);
            SelecaoAtleticaAdapter adapter = new SelecaoAtleticaAdapter(this, atleticaList);
            list.setAdapter(adapter);
        }

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Selecione uma atlética");
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
