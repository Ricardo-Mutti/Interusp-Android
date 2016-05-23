package com.appsimples.mutti.interusp_android.Mais;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.R;
import com.appsimples.mutti.interusp_android.Utils.StatusBarColor;

public class InterUspInfo extends AppCompatActivity {

    Activity activity = this;
    Context context = this;

    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_usp_info);

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Informações Inter Usp");
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
