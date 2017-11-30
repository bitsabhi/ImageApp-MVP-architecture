package com.doctoranywhere.app.mvp;

import com.doctoranywhere.app.constants.ApiConstants;
import com.doctoranywhere.app.models.RootObject;
import com.doctoranywhere.app.models.UserResult;
import com.doctoranywhere.app.network.APIClient;
import com.doctoranywhere.app.network.APIInterface;
import com.doctoranywhere.app.parsers.UserParser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 11/26/2017.
 */
public class MainInteractor {

    interface OnFinishedListener {
        void onSuccess(ArrayList<UserResult> items);

        void onFailure(Throwable t);

    }

    public void makeAPICall(int offset, final OnFinishedListener listener) {

        APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);
        String url = ApiConstants.BASEURL + "api/users?offset=" + offset + "&limit=10";

        Call<RootObject> call = apiService.getList(url);
        call.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                ArrayList<UserResult> searchResults = response.body().getData().getUsers();
                listener.onSuccess(searchResults);
            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {
                listener.onFailure(t);

            }
        });
    }
}
