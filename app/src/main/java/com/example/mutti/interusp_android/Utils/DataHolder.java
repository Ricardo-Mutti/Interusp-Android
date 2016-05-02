package com.example.mutti.interusp_android.Utils;

import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.Model.ListaLocais;

import java.util.ArrayList;

/**
 * Created by AppSimples on 01/05/16.
 */
public class DataHolder {

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}

    private ArrayList<ListaLocais>  locaisSalvos = new ArrayList<>();
    public ArrayList<ListaLocais> getLocaisSalvos() {return locaisSalvos;}
    public void setLocaisSalvos(ArrayList<ListaLocais> locaisSalvos) {this.locaisSalvos = locaisSalvos;}

    private ArrayList<Jogo>  jogos = new ArrayList<>();
    public ArrayList<Jogo> getJogos() {return jogos;}
    public void setJogos(ArrayList<Jogo> jogos) {this.jogos = jogos;}





}
