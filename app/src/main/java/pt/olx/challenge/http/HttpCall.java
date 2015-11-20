package pt.olx.challenge.http;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import pt.olx.challenge.domain.OlxItem;
import pt.olx.challenge.interfaces.IOlxAds;

/**
 * Created by Asus on 20-11-2015.
 */
public class HttpCall extends AsyncTask<String, Void, String> {

    final String url = "https://olx.pt/i2/ads/?json=1&search[category_id]=25";
    private IOlxAds iOlxAds;

    public HttpCall(IOlxAds iOlxAds) {
        super();
        this.iOlxAds = iOlxAds;
    }

    @Override
    protected String doInBackground(String... params) {

        HttpURLConnection c = null;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    return sb.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        OlxItem olxItem = new Gson().fromJson(result, OlxItem.class);
        iOlxAds.getOlxAdsCalback(olxItem.getAds());
        super.onPostExecute(result);
    }
}
