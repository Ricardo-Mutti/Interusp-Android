package com.example.mutti.interusp_android.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by AppSimples on 01/05/16.
 */
public class Local implements Parcelable {

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

    public Local() {

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
    public static final Parcelable.Creator<Local> CREATOR = new Parcelable.Creator<Local>() {
        public Local createFromParcel(Parcel in) {
            return new Local(in);
        }

        public Local[] newArray(int size) {
            return new Local[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Local(Parcel in) {
        id = in.readString();
        nome = in.readString();
        foto = in.readString();
        endereco = in.readString();
        coordenadas = in.createDoubleArray();
        telefone = in.readString();
        tipo = in.readInt();
        principaisModalidades = in.readString();
    }

    //Locais HardCoded
    public static ArrayList<Local> getLocaisProvisorios() {
        ArrayList<Local> locais = new ArrayList<>();

        Local local1 = new Local();
        local1.id = "abc";
        local1.nome = "Hospital";
        local1.foto = "http://www.avarenetvirtual.com.br/agendaonline/agendaonline/img/34.jpg";
        local1.endereco = "Rua teste, 000";
        double[] pontos1 = {-23.1075, -48.9346};
        local1.coordenadas = pontos1;
        local1.telefone = "5554444";
        local1.tipo = 1;
        local1.principaisModalidades = "";

        Local local2 = new Local();
        local2.id = "def";
        local2.nome = "Ginasio";
        local2.foto = "http://avareurgente.com/wp-content/uploads/2016/03/af6b0a450c72c85ebd3d1310e8c97b9d.jpg";
        local2.endereco = "Rua teste, 150";
        double[] pontos2 = {-23.1072, -48.9255};
        local2.coordenadas = pontos2;
        local2.telefone = "5554444";
        local2.tipo = 2;
        local2.principaisModalidades = "Futsal";

        Local local3 = new Local();
        local3.id = "ghi";
        local3.nome = "Alojamento Poli";
        local3.foto = "http://ipmo.ourinhos.sp.gov.br/img/noticias/sede_IPMO2.jpg";
        local3.endereco = "Rua teste, 300";
        double[] pontos3 = {-23.1100, -48.9257};
        local3.coordenadas = pontos3;
        local3.telefone = "5554444";
        local3.tipo = 3;
        local3.principaisModalidades = "Alojamento";

        locais.add(local1);
        locais.add(local2);
        locais.add(local3);

        return locais;
    }
}
