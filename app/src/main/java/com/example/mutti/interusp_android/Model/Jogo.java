package com.example.mutti.interusp_android.Model;

/**
 * Created by Mutti on 01/05/16.
 */
public class Jogo {

    String modalidade_id;
    String nome;
    boolean is_prova;
    String data;
    String local;
    String mandante;
    String faculdade_1;
    String faculdade_2;
    String placar_1;
    String placar_2;
    String chaveamento;//posicao na chave
    boolean is_vencendor;
    int dia;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getModalidade_id() {
        return modalidade_id;
    }

    public void setModalidade_id(String modalidade_id) {
        this.modalidade_id = modalidade_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean is_prova() {
        return is_prova;
    }

    public void setIs_prova(boolean is_prova) {
        this.is_prova = is_prova;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getFaculdade_1() {
        return faculdade_1;
    }

    public void setFaculdade_1(String faculdade_1) {
        this.faculdade_1 = faculdade_1;
    }

    public String getFaculdade_2() {
        return faculdade_2;
    }

    public void setFaculdade_2(String faculdade_2) {
        this.faculdade_2 = faculdade_2;
    }

    public String getPlacar_1() {return placar_1;}

    public void setPlacar_1(String placar_1) {this.placar_1 = placar_1;}

    public String getPlacar_2() {return placar_2;}

    public void setPlacar_2(String placar_2) {this.placar_2 = placar_2;}

    public String getChaveamento() {
        return chaveamento;
    }

    public void setChaveamento(String chaveamento) {
        this.chaveamento = chaveamento;
    }

    public boolean is_vencendor() {
        return is_vencendor;
    }

    public void setIs_vencendor(boolean is_vencendor) {
        this.is_vencendor = is_vencendor;
    }

}
