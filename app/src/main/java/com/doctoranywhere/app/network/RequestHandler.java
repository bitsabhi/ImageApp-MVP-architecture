package com.doctoranywhere.app.network;

import android.util.Log;

import com.doctoranywhere.app.Factory;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;

import java.io.IOException;


public class RequestHandler {

    public static String makeRequest(Request request) throws IOException, JSONException {
        return doRequest(request, false);
    }

    private static String doRequest(Request request, boolean doValidate) throws IOException, JSONException {
        Log.i("HTTP", request.method() + " : " + request.urlString());
        OkHttpClient httpClient = Factory.getOkHTTPClient();
        Response response = httpClient.newCall(request).execute();
        String body = response.body().string();
        Log.i("HTTP", response.code() + " : " + body);
        if (!response.isSuccessful()) {
            // TODO Handle via custom exception, ommitted in this code
            return null;
        } else {
            return body;
        }
    }
}
