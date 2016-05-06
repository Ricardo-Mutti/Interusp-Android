package com.example.mutti.interusp_android.Model;

/**
 * Created by Mutti on 06/05/16.
 */
public class ModalidadeFaculdade {
    //CLASSE QUE RETORNA AS MODALIDADES PELA FACULDADE SELECIONADA

    String posicao;
    String pontuacao_total;
    String id;
    String nome;

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getPontuacao_total() {
        return pontuacao_total;
    }

    public void setPontuacao_total(String pontuacao_total) {
        this.pontuacao_total = pontuacao_total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
