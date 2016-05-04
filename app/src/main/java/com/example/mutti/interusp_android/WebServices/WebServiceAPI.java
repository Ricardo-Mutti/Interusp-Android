package com.example.mutti.interusp_android.WebServices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.mutti.interusp_android.Utils.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mutti on 01/05/16.
 */
public class WebServiceAPI { private Context context;

    public WebServiceAPI(Context context) {
        this.context = context;
    }


//    public void getContatos (String userID, Response.Listener successListener) {
//        String url = Constants.kServiceURL + Constants.kServiceContatos;
//        String req = url + userID; //url+userID
//
//        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
//                req,
//                null, successListener);
//
//        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
//        Log.d("Request:",request.toString());
//    }

    public void getLocais (Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();

        String url = Constants.kServiceURL + Constants.kServiceGetLocation;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:",request.toString());
    }


    public void userLogin (String username, String password, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        String url = Constants.kServiceURL + Constants.kServiceLogin;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:",request.toString());
    }

//TODO comecei e nao terminei
    public void getJogos( Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();

        String url = Constants.kServiceURL + Constants.kServiceLogin;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:",request.toString());
    }



    public void getOnibus( Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetOnibus;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:",request.toString());
    }








    public void sendRequest(String url, RequestCallback callback) {
        new SendRequestTask(callback).execute(url);
    }

    public boolean checkConnection(String url) {
        ConnectivityManager connMgr = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }

    // Given a URL, establishes an HttpUrlConnection and retrieves the web page content as a InputStream,
    // which it returns as a string.
    private String connect(String myurl) throws IOException {
        InputStream is = null;
        int len = 1000;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("latitude", "-23.5680422")
                    .appendQueryParameter("longitude", "-46.7333438");
            String query = builder.build().getEncodedQuery();

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("WS", "The response code is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String res = convertStreamToString(is);
            return res;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
    private class SendRequestTask extends AsyncTask<String, Void, String> {

        private RequestCallback callback;

        public SendRequestTask(RequestCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                return connect(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return "erro";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            callback.onSuccess(result);
        }
    }
}