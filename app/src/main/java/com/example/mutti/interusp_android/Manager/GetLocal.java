package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.Local;
import com.example.mutti.interusp_android.Model.ServerResponse;
import com.example.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Mutti on 01/05/16.
 */
public class GetLocal {

    private WebServiceAPI wsAPI;
    Context context;

    public GetLocal(Context context) {
        this.context = context;
    }

    public void getLocais(final String lat, final String lng) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getLocais(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {
                    Locais locais = gson.fromJson(serverResponse.getResponse(), Locais.class);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
