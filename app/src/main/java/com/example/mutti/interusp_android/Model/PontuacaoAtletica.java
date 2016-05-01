package com.example.mutti.interusp_android.Model;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoAtletica {

    private int modalidadeId;
    private String nome;
    private int posicao;
    private int pontos;

    public PontuacaoAtletica(int modalidadeId, String nome, int posicao, int pontos) {
        this.modalidadeId = modalidadeId;
        this.nome = nome;
        this.posicao = posicao;
        this.pontos = pontos;
    }

    public int getModalidadeId() {
        return modalidadeId;
    }

    public void setModalidadeId(int modalidadeId) {
        this.modalidadeId = modalidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
