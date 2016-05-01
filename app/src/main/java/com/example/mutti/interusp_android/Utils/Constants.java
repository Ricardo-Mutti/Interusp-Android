package com.example.mutti.interusp_android.Utils;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mutti on 01/05/16.
 */
public class Constants {

    public static final String kServiceURL = "http://ec2-52-201-135-248.compute-1.amazonaws.com:3000";

    public static final String kServiceGetLocation = "/v1/locais/";
    public static final String kServiceLogin = "/v1/user/login";
    public static final String kServiceGetJogos = "/jogo";
    public static final String kServiceUpdateJogos = "/jogo/getTodos";

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
    public static final String[] kFiltroJogoDia = {"Todos","26/05","27/05","28/05","29/05"};
    public static final String[] kFiltroJogoModalidade = {"Todos","ATL","BQM","BQF","FC","FSM", "FSF", "HM",
            "HF", "JUDO", "KRT", "NTM","NTF","PA","RGF","RGM","SB","TCM","TCF","TMM","TMF","VM","VF","XDZ"};
    public static final String[] kFiltroJogoAtletica = {"Todos","POLI","FEA","ODONTO","MED RIBEIRÃO","POLI",
            "FEA","ODONTO","MED PINHEIROS"};
    public static final String[] kFiltroJogoLocal = {"G1","G2","G3"};

    //CORES DAS FACULDADES
    public static final String kCorPoli1 = "#171B40";
    public static final String kCorPoli2 = "#FDA405";
    public static final String kCorFarma1 = "#A0522D";
    public static final String kCorFarma2 = "#ffffff";
    public static final String kCorEsalq1 = "#FF0000";
    public static final String kCorEsalq2 = "#ffffff";
    public static final String kCorRibeirao1 = "#093B24";
    public static final String kCorRibeirao2 = "#ffffff";
    public static final String kCorSanFran1 = "#d4251e";
    public static final String kCorSanFran2 = "#ffffff";
    public static final String kCorMed1 = "#006400";
    public static final String kCorMed2 = "#ffffff";
    public static final String kCorOdonto1 = "#4682B4";
    public static final String kCorOdonto2 = "#A0522D";
    public static final String kCorFea1 = "#0000CC";
    public static final String kCorFea2 = "#ffffff";
    public static final String kCorTodos1 = "#000033";
    public static final String kCorTodos2 = "#ffffff";

    //CONSTANTES GLOBAIS

    public static final String MY_PREFS_NAME = "my_prefs";

    //DONE

    public static final String kLoginDone = "com.appsimples.interusp.login-done";
    public static final String kGetJogosDone = "com.appsimples.interusp.get.jogos-done";
    public static final String kGetLocaisDone = "com.appsimples.interusp.get.locais-done";

}
