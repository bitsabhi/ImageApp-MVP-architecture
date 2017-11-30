package com.doctoranywhere.app.network;

import com.doctoranywhere.app.models.RootObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface {

    @GET()
    Call<RootObject> getList(@Url String url);
}