package com.example.mutti.interusp_android.Utils;

import android.widget.ArrayAdapter;

import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.Modalidade;
import com.example.mutti.interusp_android.Model.ModalidadeFaculdade;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.Model.OnibusArray;
import com.example.mutti.interusp_android.Model.Torcida;

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

    private ArrayList<Jogo>  chaveamento = new ArrayList<>();
    public ArrayList<Jogo> getChaveamento() {return chaveamento;}
    public void setChaveamento(ArrayList<Jogo> chaveamento) {this.chaveamento = chaveamento;}

    private ArrayList<Onibus>  onibus = new ArrayList<>();
    public ArrayList<Onibus> getOnibus() {
        return onibus;
    }
    public void setOnibus(ArrayList<Onibus> onibus) {
        this.onibus = onibus;
    }

    private ArrayList<Torcida>  torcidas = new ArrayList<>();
    public ArrayList<Torcida> getTorcidas() {
        return torcidas;
    }
    public void setTorcidas(ArrayList<Torcida> torcidas) {
        this.torcidas = torcidas;
    }

    private  ArrayList<Faculdade> faculdades = new ArrayList<>();
    public ArrayList<Faculdade> getFaculdades() {
        return faculdades;
    }
    public void setFaculdades(ArrayList<Faculdade> faculdades) {
        this.faculdades = faculdades;
    }

    private ArrayList<ModalidadeFaculdade> modalidadesFaculdade = new ArrayList<>();
    public ArrayList<ModalidadeFaculdade> getModalidadesFaculdade() {
        return modalidadesFaculdade;
    }
    public void setModalidadesFaculdade(ArrayList<ModalidadeFaculdade> modalidadesFaculdade) {
        this.modalidadesFaculdade = modalidadesFaculdade;
    }

    private  Modalidade modalidade = new Modalidade();
    public Modalidade getModalidade() {
        return modalidade;
    }
    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

}
