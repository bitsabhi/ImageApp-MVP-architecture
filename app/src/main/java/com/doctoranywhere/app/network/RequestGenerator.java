package com.doctoranywhere.app.network;

import android.support.annotation.NonNull;

import com.squareup.okhttp.Request;

public class RequestGenerator {

    /**
     * Builds a get Request object
     *
     * @param url
     * @return Request
     */
    public static Request get(@NonNull String url)
    {
        Request.Builder builder = new Request.Builder().url(url);

        return builder.build();
    }
}
