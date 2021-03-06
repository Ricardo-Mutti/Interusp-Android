package com.appsimples.mutti.interusp_android.WebServices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.appsimples.mutti.interusp_android.Model.Jogo;
import com.appsimples.mutti.interusp_android.Model.Locais;
import com.appsimples.mutti.interusp_android.Model.Modalidade;
import com.appsimples.mutti.interusp_android.Utils.Constants;

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
public class WebServiceAPI {
    private Context context;

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

    public void getLocais(Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();

        String url = Constants.kServiceURL + Constants.kServiceGetLocation;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }


    public void userLogin(String username, String password, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();
        params.put("login", username);
        params.put("password", password);

        String url = Constants.kServiceURL + Constants.kServiceLogin;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }


    public void placar(Jogo jogo, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();
        String placar_1 = jogo.getPlacar_1();
        String placar_2 = jogo.getPlacar_2();

        params.put("placar_1",placar_1);
        params.put("placar_2",placar_2);
        params.put("_id", jogo.get_id());
        params.put("ganhador", String.valueOf(jogo.getGanhador()));

        String url = Constants.kServiceURL + Constants.getkServiceUpdateJogosPlacar;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void infos(Jogo jogo, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();

        params.put("_id", jogo.get_id());
        params.put("data", jogo.getData());
        params.put("local", jogo.getLocal());

        String url = Constants.kServiceURL + Constants.getkServiceUpdateJogosInfo;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }


    public void getJogos(Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetJogos;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void getChaveamento(int modalidade, Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetJogos;

        url = url + "modalidade=" + modalidade;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void getFaculdades(Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetFaculdades;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void getPontosFaculdades(String facul_id, Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetPontosFacul + facul_id;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void getOnibus(Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetOnibus;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }


    public void addTorcida(String facul_id, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();
        params.put("facul_id", facul_id);


        String url = Constants.kServiceURL + Constants.kServiceGetTorcidas;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void editOnibus(String facul_id, String placa, String informacoes, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();
        params.put("facul_id", facul_id);
        params.put("placa", placa);
        params.put("informacoes", informacoes);

        String url = Constants.kServiceURL + Constants.kServiceEditOnibus;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void editLocal(Locais local, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();
        if (local.getId() != null) {
            params.put("_id", local.getId());
        }
        if (local.getNome() != null) {
            params.put("nome", local.getNome());
        }
        if (local.getDescricao() != null) {
            params.put("descricao", local.getDescricao());
        }
        if (local.getFoto() != null) {
            params.put("foto", local.getFoto());
        }
        if (local.getCoordenadas() != null) {
            double[] d = local.getCoordenadas();
            params.put("latitude", String.valueOf(d[0]));
            params.put("longitude", String.valueOf(d[1]));
        }
        if (local.getTipo() != 0) {
            params.put("tipo", String.valueOf(local.getTipo()));
        }

        String url = Constants.kServiceURL + Constants.kServiceEditLocal;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }

    public void updateModalidade(Modalidade modalidade, Response.Listener successListener) {

        Map<String, String> params = new HashMap<>();

        params.put("id", String.valueOf(modalidade.getId()));
        if(modalidade.getPontuacao_total()!=null) {
            params.put("total1", String.valueOf(modalidade.getPontuacao_total()[0].getPontuacao()));
            params.put("total2", String.valueOf(modalidade.getPontuacao_total()[1].getPontuacao()));
            params.put("total3", String.valueOf(modalidade.getPontuacao_total()[2].getPontuacao()));
            params.put("total4", String.valueOf(modalidade.getPontuacao_total()[3].getPontuacao()));
            params.put("total5", String.valueOf(modalidade.getPontuacao_total()[4].getPontuacao()));
            params.put("total6", String.valueOf(modalidade.getPontuacao_total()[5].getPontuacao()));
            params.put("total7", String.valueOf(modalidade.getPontuacao_total()[6].getPontuacao()));
            params.put("total8", String.valueOf(modalidade.getPontuacao_total()[7].getPontuacao()));

            params.put("posicao1", String.valueOf(modalidade.getPontuacao_total()[0].getPosicao()));
            params.put("posicao2", String.valueOf(modalidade.getPontuacao_total()[1].getPosicao()));
            params.put("posicao3", String.valueOf(modalidade.getPontuacao_total()[2].getPosicao()));
            params.put("posicao4", String.valueOf(modalidade.getPontuacao_total()[3].getPosicao()));
            params.put("posicao5", String.valueOf(modalidade.getPontuacao_total()[4].getPosicao()));
            params.put("posicao6", String.valueOf(modalidade.getPontuacao_total()[5].getPosicao()));
            params.put("posicao7", String.valueOf(modalidade.getPontuacao_total()[6].getPosicao()));
            params.put("posicao8", String.valueOf(modalidade.getPontuacao_total()[7].getPosicao()));

            params.put("max1", String.valueOf(modalidade.getPontuacao_total()[0].getPontuacao()));
            params.put("max2", String.valueOf(modalidade.getPontuacao_total()[1].getPontuacao()));
            params.put("max3", String.valueOf(modalidade.getPontuacao_total()[2].getPontuacao()));
            params.put("max4", String.valueOf(modalidade.getPontuacao_total()[3].getPontuacao()));
            params.put("max5", String.valueOf(modalidade.getPontuacao_total()[4].getPontuacao()));
            params.put("max6", String.valueOf(modalidade.getPontuacao_total()[5].getPontuacao()));
            params.put("max7", String.valueOf(modalidade.getPontuacao_total()[6].getPontuacao()));
            params.put("max8", String.valueOf(modalidade.getPontuacao_total()[7].getPontuacao()));

            params.put("min1", String.valueOf(modalidade.getPontuacao_total()[0].getPontuacao()));
            params.put("min2", String.valueOf(modalidade.getPontuacao_total()[1].getPontuacao()));
            params.put("min3", String.valueOf(modalidade.getPontuacao_total()[2].getPontuacao()));
            params.put("min4", String.valueOf(modalidade.getPontuacao_total()[3].getPontuacao()));
            params.put("min5", String.valueOf(modalidade.getPontuacao_total()[4].getPontuacao()));
            params.put("min6", String.valueOf(modalidade.getPontuacao_total()[5].getPontuacao()));
            params.put("min7", String.valueOf(modalidade.getPontuacao_total()[6].getPontuacao()));
            params.put("min8", String.valueOf(modalidade.getPontuacao_total()[7].getPontuacao()));

        }else {

            params.put("total1", String.valueOf(0));
            params.put("total2", String.valueOf(0));
            params.put("total3", String.valueOf(0));
            params.put("total4", String.valueOf(0));
            params.put("total5", String.valueOf(0));
            params.put("total6", String.valueOf(0));
            params.put("total7", String.valueOf(0));
            params.put("total8", String.valueOf(0));

            params.put("posicao1", String.valueOf(0));
            params.put("posicao2", String.valueOf(0));
            params.put("posicao3", String.valueOf(0));
            params.put("posicao4", String.valueOf(0));
            params.put("posicao5", String.valueOf(0));
            params.put("posicao6", String.valueOf(0));
            params.put("posicao7", String.valueOf(0));
            params.put("posicao8", String.valueOf(0));

            params.put("max1", String.valueOf(modalidade.getPontuacao_max()[0].getPontuacao()));
            params.put("max2", String.valueOf(modalidade.getPontuacao_max()[1].getPontuacao()));
            params.put("max3", String.valueOf(modalidade.getPontuacao_max()[2].getPontuacao()));
            params.put("max4", String.valueOf(modalidade.getPontuacao_max()[3].getPontuacao()));
            params.put("max5", String.valueOf(modalidade.getPontuacao_max()[4].getPontuacao()));
            params.put("max6", String.valueOf(modalidade.getPontuacao_max()[5].getPontuacao()));
            params.put("max7", String.valueOf(modalidade.getPontuacao_max()[6].getPontuacao()));
            params.put("max8", String.valueOf(modalidade.getPontuacao_max()[7].getPontuacao()));

            params.put("min1", String.valueOf(modalidade.getPontuacao_min()[0].getPontuacao()));
            params.put("min2", String.valueOf(modalidade.getPontuacao_min()[1].getPontuacao()));
            params.put("min3", String.valueOf(modalidade.getPontuacao_min()[2].getPontuacao()));
            params.put("min4", String.valueOf(modalidade.getPontuacao_min()[3].getPontuacao()));
            params.put("min5", String.valueOf(modalidade.getPontuacao_min()[4].getPontuacao()));
            params.put("min6", String.valueOf(modalidade.getPontuacao_min()[5].getPontuacao()));
            params.put("min7", String.valueOf(modalidade.getPontuacao_min()[6].getPontuacao()));
            params.put("min8", String.valueOf(modalidade.getPontuacao_min()[7].getPontuacao()));

        }
        String url = Constants.kServiceURL + Constants.kServiceUpdateModalidade;

        Request request = new InteruspWSRequest(Request.Method.POST, this.context,
                url,
                params, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }


    public void getModalidades(String modalidade_id, Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetModalidades + modalidade_id;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
    }


    public void getTorcida(Response.Listener successListener) {

        String url = Constants.kServiceURL + Constants.kServiceGetTorcidas;

        Request request = new InteruspWSRequest(Request.Method.GET, this.context,
                url,
                null, successListener);

        WebServiceSingleton.getInstance(this.context).addToRequestQueue(request);
        Log.d("Request:", request.toString());
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