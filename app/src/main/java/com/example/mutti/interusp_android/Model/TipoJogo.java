package com.example.mutti.interusp_android.Model;

import com.example.mutti.interusp_android.Utils.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

/**
 * Created by Gabriel on 5/1/16.
 */
public class TipoJogo {

    private String horario;
    private Date data;
    private String dataString;
    private String local;
    private ArrayList<String> participantes;
    private String title;
    private String subtitle;
    private String modalidade;

    public TipoJogo () {
    }

    public TipoJogo jogoFromDictionary (Dictionary dictionary) {

        TipoJogo jogo = new TipoJogo();

        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);

        return jogo;
    }


}
