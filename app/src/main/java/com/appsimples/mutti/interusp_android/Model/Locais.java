package com.appsimples.mutti.interusp_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AppSimples on 01/05/16.
 */
public class Locais implements Parcelable {

    private String _id;
    private String nome;
    private String descricao;
    private String foto;
    private double coordenadas[];
    private int tipo;
    private String principaisModalidades;

    public String getId() {return _id;}
    public void setId(String id) {this._id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getFoto() {return foto;}
    public void setFoto(String foto) {this.foto = foto;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public double[] getCoordenadas() {return coordenadas;}
    public void setCoordenadas(double[] coordenadas) {this.coordenadas = coordenadas;}

    public int getTipo() {return tipo;}
    public void setTipo(int tipo) {this.tipo = tipo;}

    public String getPrincipaisModalidades() {return principaisModalidades;}
    public void setPrincipaisModalidades(String principaisModalidades) {
        this.principaisModalidades = principaisModalidades;}

    public Locais() {

    }

    public Locais(String nome, String descricao, String foto, double[] coordenadas, int tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.coordenadas = coordenadas;
        this.tipo = tipo;
    }

    //Funções de parcialização
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(nome);
        dest.writeString(foto);
        dest.writeString(descricao);
        dest.writeDoubleArray(coordenadas);
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
        _id = in.readString();
        nome = in.readString();
        foto = in.readString();
        descricao = in.readString();
        coordenadas = in.createDoubleArray();
        tipo = in.readInt();
        principaisModalidades = in.readString();
    }
}
