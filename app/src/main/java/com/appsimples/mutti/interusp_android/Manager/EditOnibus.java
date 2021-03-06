package com.appsimples.mutti.interusp_android.Manager;


import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.ServerResponse;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

/**
 * Created by Mutti on 04/05/16.
 */
public class EditOnibus {

    private WebServiceAPI wsAPI;
    Context context;



    public EditOnibus(Context context) {
        this.context = context;
    }

    public void sendRequest(String facul_id, String informacoes, String placa) {

        wsAPI = new WebServiceAPI(context);
        wsAPI.editOnibus(facul_id, placa, informacoes,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    Intent intent = new Intent(Constants.kOnibusDone);
                    context.sendBroadcast(intent);


                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
