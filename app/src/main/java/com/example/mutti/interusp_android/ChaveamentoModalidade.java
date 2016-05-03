package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Utils.StatusBarColor;

public class ChaveamentoModalidade extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    ImageView chave_1, chave_2, chave_3, chave_4, chave_5, chave_6, chave_7, chave_8,
            chave_9, chave_10, chave_11, chave_12, chave_13, chave_14, chave_15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaveamento_modalidade);


        chave_1 = (ImageView) findViewById(R.id.chave_1);
        chave_2 = (ImageView) findViewById(R.id.chave_2);
        chave_3 = (ImageView) findViewById(R.id.chave_3);
        chave_4 = (ImageView) findViewById(R.id.chave_4);
        chave_5 = (ImageView) findViewById(R.id.chave_5);
        chave_6 = (ImageView) findViewById(R.id.chave_6);
        chave_7 = (ImageView) findViewById(R.id.chave_7);
        chave_8 = (ImageView) findViewById(R.id.chave_8);
        chave_9 = (ImageView) findViewById(R.id.chave_9);
        chave_10 = (ImageView) findViewById(R.id.chave_10);
        chave_11 = (ImageView) findViewById(R.id.chave_11);
        chave_12 = (ImageView) findViewById(R.id.chave_12);
        chave_13 = (ImageView) findViewById(R.id.chave_13);
        chave_14 = (ImageView) findViewById(R.id.chave_14);
        chave_15 = (ImageView) findViewById(R.id.chave_15);

        chave_1.setImageResource(R.drawable.icon_sanfran);
        chave_2.setImageResource(R.drawable.icon_sanfran);
        chave_3.setImageResource(R.drawable.icon_sanfran);
        chave_4.setImageResource(R.drawable.icon_sanfran);
        chave_5.setImageResource(R.drawable.icon_sanfran);
        chave_6.setImageResource(R.drawable.icon_sanfran);
        chave_7.setImageResource(R.drawable.icon_sanfran);
        chave_8.setImageResource(R.drawable.icon_sanfran);
        chave_9.setImageResource(R.drawable.icon_sanfran);
        chave_10.setImageResource(R.drawable.icon_sanfran);
        chave_11.setImageResource(R.drawable.icon_sanfran);
        chave_12.setImageResource(R.drawable.icon_sanfran);
        chave_13.setImageResource(R.drawable.icon_sanfran);
        chave_14.setImageResource(R.drawable.icon_sanfran);
        chave_15.setImageResource(R.drawable.icon_sanfran);

        //TODO if resultado maior que 99 diminuir a fonte para 11sp





        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        TextView action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Chave da Modalidade");
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
