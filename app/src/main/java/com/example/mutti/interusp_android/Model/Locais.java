package com.example.mutti.interusp_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AppSimples on 01/05/16.
 */
public class Locais implements Parcelable {

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

    public Locais() {

    }

    //Funções de parcialização
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nome);
        dest.writeString(foto);
        dest.writeString(endereco);
        dest.writeDoubleArray(coordenadas);
        dest.writeString(telefone);
        dest.writeInt(tipo);
        dest.writeString(principaisModalidades);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Locais> CREATOR = new Parcelable.Creator<Locais>() {
        public Locais createFromParcel(Parcel in) {
            return new Locais(in);
        }

        public Locais[] newArray(int size) {
            return new Locais[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Locais(Parcel in) {
        id = in.readString();
        nome = in.readString();
        foto = in.readString();
        endereco = in.readString();
        coordenadas = in.createDoubleArray();
        telefone = in.readString();
        tipo = in.readInt();
        principaisModalidades = in.readString();
    }
}
