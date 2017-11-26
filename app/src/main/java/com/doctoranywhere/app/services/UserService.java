package com.doctoranywhere.app.services;


import com.google.common.util.concurrent.ListenableFuture;
import com.doctoranywhere.app.concurrency.ExecutorUtils;
import com.doctoranywhere.app.constants.ApiConstants;
import com.doctoranywhere.app.models.UserResult;
import com.doctoranywhere.app.network.RequestGenerator;
import com.doctoranywhere.app.network.RequestHandler;
import com.doctoranywhere.app.parsers.UserParser;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.concurrent.Callable;


public class UserService {

    public ListenableFuture<ArrayList<UserResult>> getUserList(final int offset)
    {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<ArrayList<UserResult>>()
        {
            @Override
            public ArrayList<UserResult> call() throws Exception
            {
                String url = ApiConstants.BASEURL + "?offset=" + offset + "&limit=10";

                Request request = RequestGenerator.get(url);
                String response = RequestHandler.makeRequest(request);
                ArrayList<UserResult> searchResults = new UserParser().getUserList(response);
                return searchResults;
            }
        });
    }
}
