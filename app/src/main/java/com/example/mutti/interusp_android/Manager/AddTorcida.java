package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.Onibus;
import com.example.mutti.interusp_android.Model.OnibusArray;
import com.example.mutti.interusp_android.Model.ServerResponse;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.example.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 05/05/16.
 */
public class AddTorcida {
    private WebServiceAPI wsAPI;
    Context context;


    public AddTorcida(Context context) {
        this.context = context;
    }

    public void addTorcida(String facul_id) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.addTorcida(facul_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

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
