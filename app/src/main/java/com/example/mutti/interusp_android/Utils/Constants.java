package com.example.mutti.interusp_android.Utils;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mutti on 01/05/16.
 */
public class Constants {

    public static final String kServiceURL = "http://ec2-54-210-71-210.compute-1.amazonaws.com:3000";

    public static final String kServiceGetLocation = "/api/getLocation/";

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
    public static final String[] kFiltroJogoDia = {"26/05","27/05","28/05","29/05"};
    public static final String[] kFiltroJogoModalidade = {"ATL","BQM","BQF","FC","FSM", "FSF", "HM",
            "HF", "JUDO", "KRT", "NTM","NTF","PA","RGF","RGM","SB","TCM","TCF","TMM","TMF","VM","VF","XDZ"};
    public static final String[] kFiltroJogoAtletica = {"POLI","FEA","ODONTO","MED RIBEIRÃO","POLI",
            "FEA","ODONTO","MED RIBEIRÃO"};
    public static final String[] kFiltroJogoLocal = {"G1","G2","G3"};

}
