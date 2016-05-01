package com.example.mutti.interusp_android.Manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.mutti.interusp_android.Model.ServerResponse;
import com.example.mutti.interusp_android.Model.Token;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.WebServices.WebServiceAPI;
import com.google.gson.Gson;

/**
 * Created by Mutti on 01/05/16.
 */
public class UpdateJogo {


    private WebServiceAPI wsAPI;
    Context context;

    Intent intent = new Intent(Constants.kLoginDone);

    public UpdateJogo(Context context) {
        this.context = context;
    }

    public void updateJogo(String username, String password) {
        wsAPI = new WebServiceAPI(context);

        wsAPI.userLogin(username, password, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//Callback da resposta  pode ser um erro
                Gson gson = new Gson();
                ServerResponse serverResponse = gson.fromJson(response, ServerResponse.class);//Parse do json segundo o modelo SeverResponse

                if (serverResponse.isSuccess()) {

                    Token token = gson.fromJson(response, Token.class);//Parse do json segundo o modelo SeverResponse

                    Log.d("TOKEN" , token.getToken());
                    android.content.SharedPreferences settings = context.getSharedPreferences(Constants.MY_PREFS_NAME, 0);
                    android.content.SharedPreferences.Editor editor = settings.edit();
                    editor.putString("token", token.getToken());
                    editor.commit();

                    context.sendBroadcast(intent);

                } else {
                    Toast.makeText(context, serverResponse.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
