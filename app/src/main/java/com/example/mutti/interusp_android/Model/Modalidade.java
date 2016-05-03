package com.example.mutti.interusp_android.Model;

/**
 * Created by Mutti on 03/05/16.
 */
public class Modalidade {

    int id;
    String nome;
    FaculdadePosicaoPontuacao[] pontuacao_total;
    FaculdadePontuacao[] pontuacao_max;
    FaculdadePontuacao[] pontuacao_min;
    boolean is_chaveamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FaculdadePosicaoPontuacao[] getPontuacao_total() {
        return pontuacao_total;
    }

    public void setPontuacao_total(FaculdadePosicaoPontuacao[] pontuacao_total) {
        this.pontuacao_total = pontuacao_total;
    }

    public FaculdadePontuacao[] getPontuacao_max() {
        return pontuacao_max;
    }

    public void setPontuacao_max(FaculdadePontuacao[] pontuacao_max) {
        this.pontuacao_max = pontuacao_max;
    }

    public FaculdadePontuacao[] getPontuacao_min() {
        return pontuacao_min;
    }

    public void setPontuacao_min(FaculdadePontuacao[] pontuacao_min) {
        this.pontuacao_min = pontuacao_min;
    }

    public boolean is_chaveamento() {
        return is_chaveamento;
    }

    public void setIs_chaveamento(boolean is_chaveamento) {
        this.is_chaveamento = is_chaveamento;
    }

}
