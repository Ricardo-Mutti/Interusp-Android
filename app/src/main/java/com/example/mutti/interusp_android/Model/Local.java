package com.example.mutti.interusp_android.Model;

/**
 * Created by AppSimples on 01/05/16.
 */
public class Local {
    private String id;
    private String nome;
    private String foto;
    private String endereco;
    private double coordenadas[];
    private String telefone;
    private int tipo;
    private String principaisModalidades;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getFoto() {return foto;}
    public void setFoto(String foto) {this.foto = foto;}

    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public double[] getCoordenadas() {return coordenadas;}
    public void setCoordenadas(double[] coordenadas) {this.coordenadas = coordenadas;}

    public int getTipo() {return tipo;}
    public void setTipo(int tipo) {this.tipo = tipo;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getPrincipaisModalidades() {return principaisModalidades;}
    public void setPrincipaisModalidades(String principaisModalidades) {
        this.principaisModalidades = principaisModalidades;}

}
