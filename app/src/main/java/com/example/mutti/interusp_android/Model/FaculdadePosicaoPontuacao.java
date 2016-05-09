package com.example.mutti.interusp_android.Model;

/**
 * Created by Mutti on 03/05/16.
 */
public class FaculdadePosicaoPontuacao {

    int faculdade;
    int posicao;
    int pontuacao;

    public FaculdadePosicaoPontuacao(int faculdade, int posicao, int pontuacao) {
        this.faculdade = faculdade;
        this.posicao = posicao;
        this.pontuacao = pontuacao;
    }

    public FaculdadePosicaoPontuacao(){

    }

    public int getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(int faculdade) {
        this.faculdade = faculdade;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
