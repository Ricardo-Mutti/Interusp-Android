package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.Faculdade;
import com.example.mutti.interusp_android.Model.FaculdadeArray;
import com.example.mutti.interusp_android.Model.Jogo;
import com.example.mutti.interusp_android.Model.JogoArray;
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
public class GetPontuacaoGeral {

    private WebServiceAPI wsAPI;
    Context context;

    public GetPontuacaoGeral(Context context) {
        this.context = context;
    }

    public void sendRequest() {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getFaculdades( new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    FaculdadeArray faculdadeArray = gson.fromJson(serverResponse.getResponse(), FaculdadeArray.class);
                    ArrayList<Faculdade> faculdades = new ArrayList<>(Arrays.asList(faculdadeArray.getFaculdades()));
                    DataHolder.getInstance().setFaculdades(faculdades);

                    Intent intent = new Intent(Constants.kGetFaculdadesDone);
                    context.sendBroadcast(intent);


                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
