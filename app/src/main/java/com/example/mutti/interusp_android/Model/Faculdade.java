package com.example.mutti.interusp_android.Model;

/**
 * Created by Victor on 01/05/2016.
 */
public class Faculdade {

    private int id;
    private String nome;
    private int pontuacao_atual;
    private int pontuacao_max;
    private int pontuacao_min;

    public Faculdade(int id, int pontuacao_atual, int pontuacao_max, int pontuacao_min) {
        this.id = id;
        this.pontuacao_atual = pontuacao_atual;
        this.pontuacao_max = pontuacao_max;
        this.pontuacao_min = pontuacao_min;
    }

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

    public int getPontuacao_atual() {
        return pontuacao_atual;
    }

    public void setPontuacao_atual(int pontuacao_atual) {
        this.pontuacao_atual = pontuacao_atual;
    }

    public int getPontuacao_max() {
        return pontuacao_max;
    }

    public void setPontuacao_max(int pontuacao_max) {
        this.pontuacao_max = pontuacao_max;
    }

    public int getPontuacao_min() {
        return pontuacao_min;
    }

    public void setPontuacao_min(int pontuacao_min) {
        this.pontuacao_min = pontuacao_min;
    }
}
