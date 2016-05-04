package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.LocaisArray;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.Model.OnibusArray;
import com.example.mutti.interusp_android.Model.ServerResponse;
import com.example.mutti.interusp_android.Model.Token;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 04/05/16.
 */
public class GetOnibus {

    private WebServiceAPI wsAPI;
    Context context;

    Intent intent = new Intent(Constants.kGetOnibusDone);

    public GetOnibus(Context context) {
        this.context = context;
    }

    public void getOnibus() {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getOnibus(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    OnibusArray onibus = gson.fromJson(response, OnibusArray.class);//Parse do json segundo o modelo SeverResponse
                    ArrayList<Onibus> onibuses = new ArrayList<Onibus>(Arrays.asList(onibus.getOnibus()));
                    DataHolder.getInstance().setOnibus(onibuses);

                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
