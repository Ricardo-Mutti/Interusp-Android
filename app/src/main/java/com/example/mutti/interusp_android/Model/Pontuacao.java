package com.example.mutti.interusp_android.Model;

/**
 * Created by Victor on 01/05/2016.
 */
public class Pontuacao {

    private int atleticaId;
    private int pontoAtual;
    private int pontoMin;
    private int pontoMax;

    public Pontuacao(int atleticaId, int pontoAtual, int pontoMin, int pontoMax) {
        this.atleticaId = atleticaId;
        this.pontoAtual = pontoAtual;
        this.pontoMin = pontoMin;
        this.pontoMax = pontoMax;
    }

    public int getAtleticaId() {
        return atleticaId;
    }

    public void setAtleticaId(int atleticaId) {
        this.atleticaId = atleticaId;
    }

    public int getPontoAtual() {
        return pontoAtual;
    }

    public void setPontoAtual(int pontoAtual) {
        this.pontoAtual = pontoAtual;
    }

    public int getPontoMin() {
        return pontoMin;
    }

    public void setPontoMin(int pontoMin) {
        this.pontoMin = pontoMin;
    }

    public int getPontoMax() {
        return pontoMax;
    }

    public void setPontoMax(int pontoMax) {
        this.pontoMax = pontoMax;
    }
}
