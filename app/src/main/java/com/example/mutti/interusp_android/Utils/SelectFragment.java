package  com.example.mutti.interusp_android.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mutti.interusp_android.Fragments.Chaveamento;
import com.example.mutti.interusp_android.Fragments.Informacoes;
import com.example.mutti.interusp_android.Fragments.Jogos;
import com.example.mutti.interusp_android.Fragments.Mais;
import com.example.mutti.interusp_android.Fragments.Mapa;
import com.example.mutti.interusp_android.R;


/**
 * Created by Mutti on 18/04/16.
 */
public class SelectFragment {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String cor1 = "cor1";
    public static final String cor2 = "cor2";


    public static void open(int i, FragmentManager fragmentManager, Activity activity) {

        ImageView informacoes_tab, chaveamento_tab, mapa_tab, jogos_tab, mais_tab;

        informacoes_tab = (ImageView) activity.findViewById(R.id.tab_info);
        chaveamento_tab = (ImageView) activity.findViewById(R.id.tab_chaveamento);
        mapa_tab = (ImageView) activity.findViewById(R.id.tab_mapa);
        jogos_tab = (ImageView) activity.findViewById(R.id.tab_jogos);
        mais_tab = (ImageView) activity.findViewById(R.id.tab_mais);

        TextView title = (TextView) activity.findViewById(R.id.txtActionBar);

        SharedPreferences sharedpreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //String backgroundColor = sharedpreferences.getString(cor1, "#000000");
        int backgroundColor = Color.parseColor(sharedpreferences.getString(cor1, "#000000"));

        Fragment fragment = new Fragment();

        switch (i) {

            case 0:
                fragment = new Informacoes();

                title.setText("Informações");

                informacoes_tab.setImageResource(R.drawable.tabicon_branco_info);
                chaveamento_tab.setImageResource(R.drawable.tabicon_azul_chave);
                mapa_tab.setImageResource(R.drawable.tabicon_azul_mapa);
                jogos_tab.setImageResource(R.drawable.tabicon_azul_jogos);
                mais_tab.setImageResource(R.drawable.tabicon_azul_mais);

                informacoes_tab.setBackgroundColor(backgroundColor);
                chaveamento_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mapa_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                jogos_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mais_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));

                break;

            case 1:
                fragment = new Chaveamento();

                title.setText("Chaveamento");

                informacoes_tab.setImageResource(R.drawable.tabicon_azul_info);
                chaveamento_tab.setImageResource(R.drawable.tabicon_branco_chave);
                mapa_tab.setImageResource(R.drawable.tabicon_azul_mapa);
                jogos_tab.setImageResource(R.drawable.tabicon_azul_jogos);
                mais_tab.setImageResource(R.drawable.tabicon_azul_mais);

                informacoes_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                chaveamento_tab.setBackgroundColor(backgroundColor);
                mapa_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                jogos_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mais_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));

                break;

            case 2:
                fragment = new Mapa();

                title.setText("Mapa");

                informacoes_tab.setImageResource(R.drawable.tabicon_azul_info);
                chaveamento_tab.setImageResource(R.drawable.tabicon_azul_chave);
                mapa_tab.setImageResource(R.drawable.tabicon_branco_mapa);
                jogos_tab.setImageResource(R.drawable.tabicon_azul_jogos);
                mais_tab.setImageResource(R.drawable.tabicon_azul_mais);

                informacoes_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                chaveamento_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mapa_tab.setBackgroundColor(backgroundColor);
                jogos_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mais_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                break;

            case 3:
                fragment = new Jogos();

                title.setText("Jogos");

                informacoes_tab.setImageResource(R.drawable.tabicon_azul_info);
                chaveamento_tab.setImageResource(R.drawable.tabicon_azul_chave);
                mapa_tab.setImageResource(R.drawable.tabicon_azul_mapa);
                jogos_tab.setImageResource(R.drawable.tabicon_branco_jogos);
                mais_tab.setImageResource(R.drawable.tabicon_azul_mais);

                informacoes_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                chaveamento_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mapa_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                jogos_tab.setBackgroundColor(backgroundColor);
                mais_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                break;

            case 4:
                fragment = new Mais();

                title.setText("Mais");

                informacoes_tab.setImageResource(R.drawable.tabicon_azul_info);
                chaveamento_tab.setImageResource(R.drawable.tabicon_azul_chave);
                mapa_tab.setImageResource(R.drawable.tabicon_azul_mapa);
                jogos_tab.setImageResource(R.drawable.tabicon_azul_jogos);
                mais_tab.setImageResource(R.drawable.tabicon_branco_mais);

                informacoes_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                chaveamento_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mapa_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                jogos_tab.setBackgroundColor(activity.getResources().getColor(R.color.branco));
                mais_tab.setBackgroundColor(backgroundColor);
                break;

        }

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
                .replace(R.id.content_tabs_main, fragment, "Tab_open")
                .commit();
    }
}
