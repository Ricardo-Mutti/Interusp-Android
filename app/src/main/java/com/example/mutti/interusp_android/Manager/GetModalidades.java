package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.Locais;
import com.example.mutti.interusp_android.Model.LocaisArray;
import com.example.mutti.interusp_android.Model.Modalidade;
import com.example.mutti.interusp_android.Model.ModalidadeArray;
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
public class GetModalidades {

    private WebServiceAPI wsAPI;
    Context context;

    public GetModalidades(Context context) {
        this.context = context;
    }

    public void getModalidades() {
        wsAPI = new WebServiceAPI(context);

        wsAPI.getModalidades(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {
                    ModalidadeArray modalidadeArray = gson.fromJson(serverResponse.getResponse(), ModalidadeArray.class);
                    ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>(Arrays.asList(modalidadeArray.getModalidades()));
                    DataHolder.getInstance().setModalidades(modalidades);

                    Intent intent = new Intent(Constants.kGetModalidadesDone);
                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
