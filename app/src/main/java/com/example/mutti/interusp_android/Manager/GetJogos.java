package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.Model.ServerResponse;
import com.example.mutti.interusp_android.Model.Token;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

/**
 * Created by Mutti on 01/05/16.
 */
public class GetJogos {

    private WebServiceAPI wsAPI;
    Context context;

    Intent intent = new Intent(Constants.kGetJogosDone);

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

                    Jogo jogo = gson.fromJson(response, Jogo.class);//Parse do json segundo o modelo SeverResponse

                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
