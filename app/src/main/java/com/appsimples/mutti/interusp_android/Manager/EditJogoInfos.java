package com.appsimples.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.Jogo;
import com.appsimples.mutti.interusp_android.Model.ServerResponse;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

/**
 * Created by Mutti on 09/05/16.
 */
public class EditJogoInfos {

    private WebServiceAPI wsAPI;
    Context context;

    Intent intent = new Intent(Constants.kJogosDone);

    public EditJogoInfos(Context context) {
        this.context = context;
    }

    public void updateJogo(Jogo jogo) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.infos(jogo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {
                    context.sendBroadcast(intent);
                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
