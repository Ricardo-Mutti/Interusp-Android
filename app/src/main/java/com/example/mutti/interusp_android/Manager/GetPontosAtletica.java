package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.ModalidadeFaculdade;
import com.example.mutti.interusp_android.Model.ModalidadeFaculdadeArray;
import com.example.mutti.interusp_android.Model.ServerResponse;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 06/05/16.
 */
public class GetPontosAtletica {

//PEGA AS MODALIDADES PELA FACULDADE PONTO TOTAIS E POSICAO

    private WebServiceAPI wsAPI;
    Context context;

    public GetPontosAtletica(Context context) {
        this.context = context;
    }

    public void sendRequest(String facul_id) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getPontosFaculdades(facul_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    ModalidadeFaculdadeArray modalidadeArray = gson.fromJson(serverResponse.getResponse(), ModalidadeFaculdadeArray.class);
                    ArrayList<ModalidadeFaculdade> modalidades = new ArrayList<>(Arrays.asList(modalidadeArray.getModalidades()));
                    DataHolder.getInstance().setModalidadesFaculdade(modalidades);

                    Intent intent = new Intent(Constants.kGetPontosFaculdadeDone);
                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
