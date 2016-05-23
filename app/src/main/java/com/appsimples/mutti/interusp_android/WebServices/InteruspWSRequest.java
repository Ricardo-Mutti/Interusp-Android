package com.appsimples.mutti.interusp_android.WebServices;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.appsimples.mutti.interusp_android.Utils.Constants;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Mutti on 01/05/16.
 */
public class InteruspWSRequest extends StringRequest {
    private Map<String, String> params;
    Context context;

    public InteruspWSRequest(int method, final Context context, String url, Map<String, String> params, Response.Listener<String> listener) {

        super(method, url, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) { //Erros de comunicao, gerais
                Log.d("W1S", volleyError.toString());
//                Toast.makeText(context, R.string.falha_ws, Toast.LENGTH_LONG).show();
            }
        });
        setRetryPolicy(new DefaultRetryPolicy(10000, 10, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        if(method== Method.POST){//Se tiver body mostra o body
            Log.d("WS", "Request: " + url + "; Params: " + params.toString());
        }

        this.params = params;
        this.context=context;
    }

    @Override
    public String getBodyContentType() {
//        TODO:verificar qual tipo de body vamos usar
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        SharedPreferences settings = context.getSharedPreferences(Constants.MY_PREFS_NAME, 0);
        String  token = settings.getString("token", null);
        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.TOKEN_KEY, token );
        return headers;
    }
}