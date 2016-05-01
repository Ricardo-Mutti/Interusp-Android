package com.example.mutti.interusp_android.Model;

import com.example.mutti.interusp_android.Utils.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

/**
 * Created by Gabriel on 5/1/16.
 */
public class TipoJogo {

    private String horario;
    private Date data;
    private String dataString;
    private String local;
    private ArrayList<String> participantes;
    private String title;
    private String subtitle;
    private String modalidade;

    public TipoJogo () {
    }

    public TipoJogo jogoFromDictionary (Dictionary dictionary) {

        TipoJogo jogo = new TipoJogo();

        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);
        jogo.horario = (String) dictionary.get(Constants.kTipoJogoHorario);

        return jogo;
    }

    public String getHorario() {return horario;}
    public void setHorario(String horario) {this.horario = horario;}

    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}

    public String getDataString() {return dataString;}
    public void setDataString(String dataString) {this.dataString = dataString;}

    public String getLocal() {return local;}

    public void setLocal(String local) {this.local = local;}

    public ArrayList<String> getParticipantes() {return participantes;}
    public void setParticipantes(ArrayList<String> participantes) {this.participantes = participantes;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getSubtitle() {return subtitle;}
    public void setSubtitle(String subtitle) {this.subtitle = subtitle;}

    public String getModalidade() {return modalidade;}
    public void setModalidade(String modalidade) {this.modalidade = modalidade;}

    public static ArrayList<TipoJogo> getJogosHardcoded () {
        ArrayList<TipoJogo> jogos = new ArrayList<>();

        TipoJogo jogo1 = new TipoJogo();
        jogo1.setModalidade("FMS");
        jogo1.setTitle("POL X FAR");
        ArrayList<String> par1 = new ArrayList<String>();
        par1.add("POL");
        par1.add("FAR");
        jogo1.setParticipantes(par1);
        jogo1.setSubtitle("quartas-de-final");
        jogo1.setDataString("26/05");
        jogo1.setHorario("8:00");
        jogo1.setLocal("G1");

        TipoJogo jogo2 = new TipoJogo();
        jogo2.setModalidade("HF");
        jogo2.setTitle("FEA X ODONTO");
        ArrayList<String> par2 = new ArrayList<String>();
        par2.add("FEA");
        par2.add("ODONTO");
        jogo2.setParticipantes(par2);
        jogo2.setSubtitle("quartas-de-final");
        jogo2.setDataString("27/05");
        jogo2.setHorario("10:00");
        jogo2.setLocal("G2");

        TipoJogo jogo3 = new TipoJogo();
        jogo3.setModalidade("FMC");
        jogo3.setTitle("FEA X FAR");
        ArrayList<String> par3 = new ArrayList<String>();
        par3.add("FEA");
        par3.add("FAR");
        jogo3.setParticipantes(par3);
        jogo3.setSubtitle("quartas-de-final");
        jogo3.setDataString("28/05");
        jogo3.setHorario("12:00");
        jogo3.setLocal("G1");

        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);
        jogos.add(jogo2);
        jogos.add(jogo1);
        jogos.add(jogo3);
        jogos.add(jogo3);
        jogos.add(jogo1);

        return jogos;
     }




//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"8:00",@"title":@"POL X FAR",@"subtitle":@"quartas-de-final", @"local":@"G1", @"participantes":@[@"POLI",@"FARMA"], @"data":@"26/05", @"modalidade":@"FMS"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"10:00",@"title":@"FEA X ODONTO",@"subtitle":@"quartas-de-final", @"local":@"G1", @"participantes":@[@"FEA",@"ODONTO"], @"data":@"26/05", @"modalidade":@"FFS"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"11:00",@"title":@"POL X FAR",@"subtitle":@"quartas-de-final", @"local":@"G1", @"participantes":@[@"POLI",@"FARMA"], @"data":@"27/05", @"modalidade":@"HF"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"12:00",@"title":@"POL X FEA",@"subtitle":@"quartas-de-final", @"local":@"G1", @"participantes":@[@"POLI",@"FEA"], @"data":@"27/05", @"modalidade":@"FMS"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"8:00",@"title":@"POL X FAR",@"subtitle":@"quartas-de-final", @"local":@"G2", @"participantes":@[@"POLI",@"FARMA"], @"data":@"28/05", @"modalidade":@"HF"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"10:00",@"title":@"FEA X ODONTO",@"subtitle":@"quartas-de-final", @"local":@"G3", @"participantes":@[@"FEA",@"ODONTO"], @"data":@"28/05", @"modalidade":@"FFS"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"11:00",@"title":@"POL X FAR",@"subtitle":@"quartas-de-final", @"local":@"G3", @"participantes":@[@"POLI",@"FARMA"], @"data":@"29/05", @"modalidade":@"FMC"}]];
//    [mArray addObject:[Jogo initWithDictionary:@{@"horario":@"12:00",@"title":@"FEA X ODONTO",@"subtitle":@"quartas-de-final", @"local":@"G2", @"participantes":@[@"FEA",@"ODONTO"], @"data":@"29/05", @"modalidade":@"FMC"}]];
}
