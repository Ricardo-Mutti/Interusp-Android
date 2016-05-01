package com.example.mutti.interusp_android.WebServices;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mutti on 01/05/16.
 */
public class WebServiceSingleton {

    private static WebServiceSingleton mInstance;
        private RequestQueue mrequestQueue;
        private static Context mCtx;

        private WebServiceSingleton(Context context) {
            mCtx = context;
            mrequestQueue = getRequestQueue();

        }

        public static synchronized WebServiceSingleton getInstance(Context context) {
            if (mInstance == null) {
                mInstance = new WebServiceSingleton(context);
            }
            return mInstance;
        }

        public RequestQueue getRequestQueue() {
            if (mrequestQueue == null) {
                // getApplicationContext() is key, it keeps you from leaking the
                // Activity or BroadcastReceiver if someone passes one in.
                mrequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
            }
            return mrequestQueue;
        }

        public <T> void addToRequestQueue(Request<T> req) {
            getRequestQueue().add(req);

        }

}
