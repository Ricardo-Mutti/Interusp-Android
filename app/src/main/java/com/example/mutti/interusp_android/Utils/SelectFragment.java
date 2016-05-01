package  com.example.mutti.interusp_android.Utils;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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


    public static void open(int i, FragmentManager fragmentManager, Activity activity) {

        ImageView informacoes_tab, chaveamento_tab, pontuacao_tab, jogos_tab, mais_tab;

        informacoes_tab = (ImageView) activity.findViewById(R.id.tab_info);
        chaveamento_tab = (ImageView) activity.findViewById(R.id.tab_chaveamento);
        pontuacao_tab = (ImageView) activity.findViewById(R.id.tab_pontuacao);
        jogos_tab = (ImageView) activity.findViewById(R.id.tab_jogos);
        mais_tab = (ImageView) activity.findViewById(R.id.tab_mais);

        Fragment fragment = new Fragment();

        switch (i) {

            case 0:
                informacoes_tab.setBackgroundColor(activity.getResources().getColor(R.color.preto));
                fragment = new Informacoes();
                break;

            case 1:
                chaveamento_tab.setBackgroundColor(activity.getResources().getColor(R.color.preto));
                fragment = new Chaveamento();
                break;

            case 2:
                pontuacao_tab.setBackgroundColor(activity.getResources().getColor(R.color.preto));
                fragment = new Mapa();
                break;

            case 3:
                jogos_tab.setBackgroundColor(activity.getResources().getColor(R.color.preto));
                fragment = new Jogos();
                break;

            case 4:
                mais_tab.setBackgroundColor(activity.getResources().getColor(R.color.preto));
                fragment = new Mais();
                break;

        }

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
                .replace(R.id.content_tabs_main, fragment, "Tab_open")
                .commit();
    }



}
