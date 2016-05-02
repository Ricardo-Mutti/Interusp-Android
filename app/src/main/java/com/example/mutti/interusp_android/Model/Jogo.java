package com.example.mutti.interusp_android.Model;

/**
 * Created by Mutti on 01/05/16.
 */
public class Jogo {

    String id_modalidade;
    String nome;
    String participantes;
    boolean isProva;
    String colocacao;//1 ganhou 2 perdeu
    String placar;
    String data;
    String hora;
    String local_id;
    String chaveamento;//posicao na chave

    public String getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(String id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public boolean isProva() {
        return isProva;
    }

    public void setProva(boolean prova) {
        isProva = prova;
    }

    public String getColocacao() {
        return colocacao;
    }

    public void setColocacao(String colocacao) {
        this.colocacao = colocacao;
    }

    public String getPlacar() {
        return placar;
    }

    public void setPlacar(String placar) {
        this.placar = placar;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public String getChaveamento() {
        return chaveamento;
    }

    public void setChaveamento(String chaveamento) {
        this.chaveamento = chaveamento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
