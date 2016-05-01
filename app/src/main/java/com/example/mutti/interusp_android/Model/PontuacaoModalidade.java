package com.example.mutti.interusp_android.Model;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoModalidade {

    private int posicao;
    private int atleticaId;
    private int pontos;

    public PontuacaoModalidade(int posicao, int atleticaId, int pontos) {
        this.posicao = posicao;
        this.atleticaId = atleticaId;
        this.pontos = pontos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getAtleticaId() {
        return atleticaId;
    }

    public void setAtleticaId(int atleticaId) {
        this.atleticaId = atleticaId;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
