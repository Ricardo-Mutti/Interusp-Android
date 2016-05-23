package com.appsimples.mutti.interusp_android.Model;

import com.google.gson.JsonObject;

/**
 * Created by Mutti on 01/05/16.
 */
public class ServerResponse {

    public ServerResponse(){
    }

    private String message;
    private JsonObject response;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonObject getResponse() {
        return response;
    }

    public void setResponse(JsonObject response) {
        this.response = response;
    }

}

