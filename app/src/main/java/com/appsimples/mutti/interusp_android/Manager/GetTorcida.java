package com.appsimples.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.ServerResponse;
import com.appsimples.mutti.interusp_android.Model.Torcida;
import com.appsimples.mutti.interusp_android.Model.TorcidaArray;
import com.appsimples.mutti.interusp_android.Utils.Constants;
import com.appsimples.mutti.interusp_android.Utils.DataHolder;
import com.appsimples.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 04/05/16.
 */
public class GetTorcida {

    private WebServiceAPI wsAPI;
    Context context;

    Intent intent = new Intent(Constants.kGetTorcidaDone);

    public GetTorcida(Context context) {
        this.context = context;
    }

    public void getTrocida() {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getTorcida(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    TorcidaArray torcidaArray = gson.fromJson(serverResponse.getResponse(), TorcidaArray.class);//Parse do json segundo o modelo SeverResponse
                    ArrayList<Torcida> torcidas = new ArrayList<>(Arrays.asList(torcidaArray.getTracking()));
                    DataHolder.getInstance().setTorcidas(torcidas);

                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
