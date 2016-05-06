package com.example.mutti.interusp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Locais;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.example.mutti.interusp_android.Utils.StatusBarColor;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class DetalheInformacao extends AppCompatActivity {

    Activity activity = this;
    ImageView imgFoto;
    Button btnJogos, btnMapa;
    TextView txtTitulo, txtInfo, txtModalidades;
    TextView action_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_informacao);

        final Locais locais = getIntent().getParcelableExtra("locais");

        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        setIcon(locais.getTipo(), imgFoto);

        btnJogos = (Button) findViewById(R.id.btnJogos);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        txtModalidades = (TextView) findViewById(R.id.txtModalidades);

        txtTitulo.setText(locais.getNome());
        if(locais.getPrincipaisModalidades()!=null){
            txtModalidades.setVisibility(View.VISIBLE);
            txtModalidades.setText(locais.getPrincipaisModalidades());
        }
        txtInfo.setText(locais.getDescricao());

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP


        ImageLoader.getInstance().displayImage(locais.getFoto(), imgFoto);

        if (btnMapa != null) {
            btnMapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + locais.getNome()
                            + "@" + locais.getCoordenadas()[1] + "," + locais.getCoordenadas()[0]));
                    startActivity(intent);
                }
            });
        }

        if (locais.getTipo() != 1) {
            btnJogos.setVisibility(View.GONE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            params.setMargins(0, 0, 0, 0);
            btnMapa.setPadding(50,0,50,0);
            btnMapa.setLayoutParams(params);
        }
        if (btnJogos != null) {
            btnJogos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, TabsMain.class);
                    intent.putExtra("tab", 3);
                    startActivity(intent);
                }
            });
        }

        //ACTION BAR
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        StatusBarColor.setColorStatusBar(activity,sharedpreferences.getString("cor1", "#000000"));
        action_title = (TextView) findViewById(R.id.txtActionBar);
        action_title.setText("Informações");
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

    public void setIcon(int id, ImageView icon) {

        switch (id) {

            case 1:
                icon.setImageResource(R.drawable.info_ginasios);
                break;
            case 2:
                icon.setImageResource(R.drawable.info_tenda);
                break;
            case 3:
                icon.setImageResource(R.drawable.info_baladas);
                break;
            case 4:
                icon.setImageResource(R.drawable.info_onibus);
                break;
            case 5:
                icon.setImageResource(R.drawable.info_alojamento);
                break;
            case 6:
                icon.setImageResource(R.drawable.info_hospital);
                break;
            case 7:
                icon.setImageResource(R.drawable.info_delegacia);
                break;
            case 8:
                icon.setImageResource(R.drawable.info_restaurantes);
                break;
        }
    }

}
