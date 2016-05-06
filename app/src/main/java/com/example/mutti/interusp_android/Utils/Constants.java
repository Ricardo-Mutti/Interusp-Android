package com.example.mutti.interusp_android.Utils;

import com.example.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mutti on 01/05/16.
 */
public class Constants {

    public static final String kServiceURL = "http://ec2-52-201-135-248.compute-1.amazonaws.com:3000";

    public static final String kServiceGetLocation = "/v1/locais/";
    public static final String kServiceGetOnibus = "/v1/onibus/";
    public static final String kServiceLogin = "/v1/user/login";

    public static final String kServiceUpdateJogos = "/jogo/getTodos";

    //END POINT
    public static final String kGetTorcidaDone = "com.appsimples.interusp.torcidas-done";
    public static final String kServiceGetTorcidas = "/v1/tracking/";

    public static final String kGetModalidadesDone = "com.appsimples.interusp.modalidade-done";
    public static final String kServiceGetModalidades = "/v1/modalidade/";

    public static final String kServiceGetJogos = "/v1/jogo/";
    public static final String kJogosDone = "com.appsimples.interusp.jogos-done";
    public static final String kChaveamentoDone = "com.appsimples.interusp.chaveamento-done";

    public static final String kServiceEditOnibus = "/v1/onibus/";
    public static final String kEditOnibusDone = "com.appsimples.interusp.edit-onibus-done";

    public static final String kServiceUpdateModalidade = "/v1/modalidade/update-modalidade/";
    public static final String kUpdateModalidadeDone = "com.appsimples.interusp.update-modalidade-done";

    public static final String TOKEN_KEY = "x-access-token";






    //Keys de jogo
    public static final String kTipoJogoHorario = "tipo.jogo.horario";
    public static final String kTipoJogoData = "tipo.jogo.data";
    public static final String kTipoJogoDataString = "tipo.jogo.dataString";
    public static final String kTipoJogoLocal = "tipo.jogo.local";
    public static final String kTipoJogoPartipantes = "tipo.jogo.participantes";
    public static final String kTipoJogoTitle = "tipo.jogo.title";
    public static final String kTipoJogoSubtitle = "tipo.jogo.subtitle";
    public static final String kTipoJogoModalidade = "tipo.jogo.modalidade";

    //FILTROS DE JOGOS
    public static final String[] kFiltroJogoDia = {"Todos","Quinta - 26/05","Sexta - 27/05","Sábado - 28/05","Domingo - 29/05"};
    public static final String[] kFiltroJogoAtletica = {"Todos","POLI","FEA","ODONTO","MED RIBEIRÃO","POLI",
            "FEA","ODONTO","MED PINHEIROS"};
    public static final String[] kFiltroJogoLocal = {"G1","G2","G3"};

    //CORES DAS FACULDADES
    public static final String kCorPoli1 = "#171B40";
    public static final String kCorPoli2 = "#fdf105";
    public static final String kCorFarma1 = "#821518";
    public static final String kCorFarma2 = "#ffffff";
    public static final String kCorEsalq1 = "#FF0000";
    public static final String kCorEsalq2 = "#ffffff";
    public static final String kCorRibeirao1 = "#093B24";
    public static final String kCorRibeirao2 = "#ffffff";
    public static final String kCorSanFran1 = "#d4251e";
    public static final String kCorSanFran2 = "#ffffff";
    public static final String kCorMed1 = "#006400";
    public static final String kCorMed2 = "#ffffff";
    public static final String kCorOdonto1 = "#02284e";
    public static final String kCorOdonto2 = "#ffffff";
    public static final String kCorFea1 = "#0000CC";
    public static final String kCorFea2 = "#ffffff";
    public static final String kCorTodos1 = "#000033";
    public static final String kCorTodos2 = "#ffffff";

    //CONSTANTES GLOBAIS

    public static final String MY_PREFS_NAME = "my_prefs";

    //DONE
    public static final String kLoginDone = "com.appsimples.interusp.login-done";
    public static final String kGetOnibusDone = "com.appsimples.interusp.getonibus-done";
    public static final String kProvasNatacaoDone = "com.appsimples.interusp.provasnatacao-done";
    public static final String kProvasAtletismoDone = "com.appsimples.interusp.provasatletismo-done";
    public static final String kModalidadesDone = "com.appsimples.interusp.modalidades-done";
    public static final String kOnibusDone = "com.appsimples.interusp.onibus-done";
    public static final String kProvasDone = "com.appsimples.interusp.provas-done";
    public static final String kGetLocaisDone = "com.appsimples.interusp.login-done";


    //ICONES DAS ATLETICAS

    public static  int poli = R.drawable.icon_sanfran;
    public static  int fea = R.drawable.icon_sanfran;
    public static  int farma = R.drawable.icon_sanfran;
    public static  int esalq = R.drawable.icon_sanfran;
    public static  int riberao = R.drawable.icon_sanfran;
    public static  int sanfra = R.drawable.icon_sanfran;
    public static  int odonto = R.drawable.icon_sanfran;
    public static  int pinheiros = R.drawable.icon_sanfran;
    
}
