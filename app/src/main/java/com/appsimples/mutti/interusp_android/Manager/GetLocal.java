package com.appsimples.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.Locais;
import com.appsimples.mutti.interusp_android.Model.LocaisArray;
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
public class GetLocal {

    private WebServiceAPI wsAPI;
    Context context;

    public GetLocal(Context context) {
        this.context = context;
    }

    public void getLocais() {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getLocais(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {
                    LocaisArray locais = gson.fromJson(serverResponse.getResponse(), LocaisArray.class);
                    ArrayList<Locais> locaisSalvos = new ArrayList<Locais>(Arrays.asList(locais.getLocais()));
                    DataHolder.getInstance().setLocaisSalvos(locaisSalvos);

                    Intent intent = new Intent(Constants.kGetLocaisDone);
                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
