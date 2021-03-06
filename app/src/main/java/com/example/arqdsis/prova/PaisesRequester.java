package com.example.arqdsis.prova;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by heitor on 05/05/2017.
 * Métodos para requisitar as informações usando REST
 */
public class PaisesRequester {
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Paises> get(String url, String chave) throws IOException {
        ArrayList<Paisese> lista = new ArrayList<>();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute(); //error aqui
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                int id = item.getInt("id");
                String nome = item.getString("nome");
                String fone = item.getString("fone");
                String email = item.getString("email");
                    Paises pais = new Paises(id, nomedopais, imagemban, area, populacao, moedas);
                lista.add(paises);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Bitmap getImage(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();
        Bitmap img = BitmapFactory.decodeStream(is);
        is.close();

        return img;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}

