package com.appsimples.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.Modalidade;
import com.appsimples.mutti.interusp_android.Model.ServerResponse;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

/**
 * Created by AppSimples on 06/05/16.
 */
public class UpdateModalidade {

    private WebServiceAPI wsAPI;
    Context context;

    public UpdateModalidade(Context context) {
        this.context = context;
    }

    public void UpdateModalidade(Modalidade modalidade) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.updateModalidade(modalidade, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {
                    Intent intent = new Intent(Constants.kUpdateModalidadeDone);
                    context.sendBroadcast(intent);
                }
                else{
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}