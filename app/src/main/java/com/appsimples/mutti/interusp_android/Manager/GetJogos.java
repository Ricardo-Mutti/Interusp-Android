package com.appsimples.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.Jogo;
import com.appsimples.mutti.interusp_android.Model.JogoArray;
import com.appsimples.mutti.interusp_android.Model.ServerResponse;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 01/05/16.
 */
public class GetJogos {

    private WebServiceAPI wsAPI;
    Context context;



    public GetJogos(Context context) {
        this.context = context;
    }

    public void GetJogos() {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getJogos( new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    JogoArray jogoArray = gson.fromJson(serverResponse.getResponse(), JogoArray.class);
                    ArrayList<Jogo> todos_jogos = new ArrayList<>(Arrays.asList(jogoArray.getJogos()));//jogos com o oitavo jogo
                    ArrayList<Jogo> jogos = new ArrayList<>();
                    for(Jogo jogo : todos_jogos){
                        if(!jogo.is_vencedor()){
                         jogos.add(jogo);
                        }
                    }
                    DataHolder.getInstance().setJogos(jogos);

                    Intent intent = new Intent(Constants.kJogosDone);
                    context.sendBroadcast(intent);


                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void GetChaveamento(int chaveamento) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getChaveamento(chaveamento, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    JogoArray jogoArray = gson.fromJson(serverResponse.getResponse(), JogoArray.class);
                    ArrayList<Jogo> jogos = new ArrayList<Jogo>(Arrays.asList(jogoArray.getJogos()));
                    DataHolder.getInstance().setChaveamento(jogos);

                    Intent intent = new Intent(Constants.kChaveamentoDone);
                    context.sendBroadcast(intent);


                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
