package com.example.mutti.interusp_android.Utils;

import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.Model.Locais;

import java.util.ArrayList;

/**
 * Created by AppSimples on 01/05/16.
 */
public class DataHolder {

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}

    private ArrayList<Locais>  locaisSalvos = new ArrayList<>();
    public ArrayList<Locais> getLocaisSalvos() {return locaisSalvos;}
    public void setLocaisSalvos(ArrayList<Locais> locaisSalvos) {this.locaisSalvos = locaisSalvos;}

    private ArrayList<Jogo>  jogos = new ArrayList<>();
    public ArrayList<Jogo> getJogos() {return jogos;}
    public void setJogos(ArrayList<Jogo> jogos) {this.jogos = jogos;}





}
